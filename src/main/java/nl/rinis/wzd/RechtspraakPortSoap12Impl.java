package nl.rinis.wzd;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import javax.xml.bind.helpers.DefaultValidationEventHandler;

import org.slf4j.LoggerFactory;
import org.apache.commons.codec.binary.Base64;
import org.apache.cxf.common.util.StringUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;


/*
 * Client CIZ (producer) : very loose xsd/wsdl composition,  insufficient  for rechtspraak (consumer) and no developers to correct this
 * We made the following definitions between producer and RINIS
 * XSD items : ConversationId not mandatory --> must be mandatory --> Responsefault to CIZ if missing
 *           : Action not mandatory         --> must be mandatory and enum!--> Reponsefault to CIZ if missing or incorrect
 *           : Bestandsnaam not mandatory   --> must be mandatory and formatted properly--> Responsefault to CIZ if missing
 *           : Attachments (Stuk/Content)   --> must be pdf mime  --> Responsefault to CIZ is missing
 *           TESTCASES in TESTSET soapui , checked in in GIT project :  git@git.rinis.cloud:java-projecten/ciz-wzd-service.git
 *           Generic spring-boot runner implements this class
 *           After the checks the payload is stored (or queued in the future 
 */

@Service

public class RechtspraakPortSoap12Impl implements RechtspraakPort {

	private static final Logger LOG = LoggerFactory.getLogger(RechtspraakPortSoap12Impl.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.ciz.rechtspraak.rinis.request.v4.RechtspraakPort#rechtspraakRequest(nl.ciz
	 * .rechtspraak.rinis.request.v4.RechtspraakRequestBericht
	 * rechtspraakRequestBericht)*
	 */

	String faultMessage = "";

	public Response rechtspraakRequest(RechtspraakRequestBericht rechtspraakRequestBericht) {

		LOG.info("Started Executing operation: rechtspraakRequest ");

		nl.rinis.wzd.Response response = new nl.rinis.wzd.Response();
		response.setResponse("NOK");

		
		String path = PropertiesFile.getStringProperty("output.folder.default");
        
		File filePath = new File(path);
		if (!filePath.exists()) {
			LOG.error(String.format("PATH to store messages does not exist: %s", path));
			System.exit(-1);
		}
	
		try {
			if (!validateFunctions(rechtspraakRequestBericht)) {
				response.setResponse("NOK");
				response.setFault(faultMessage);
				return response;
			}
			
			String filename = FilenameHelper.createUniqueFilename(path, rechtspraakRequestBericht.getConversationId());

			storeXmlToFile(rechtspraakRequestBericht, filename);

			LOG.info("Message is written , process OK");
			response.setResponse("OK");
			return response;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Write the given request to file using the given path as filename.
	 *
	 * @param request
	 * @param path
	 * @throws JAXBException
	 */
	private void storeXmlToFile(RechtspraakRequestBericht request, String path) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(RechtspraakRequestBericht.class);
		LOG.info("Marshal");
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		LOG.info("eventHandler");
		jaxbMarshaller.setEventHandler(new DefaultValidationEventHandler());
		LOG.info("marshal");
		jaxbMarshaller.marshal(request, new File(path));
		LOG.info("Wrote request with Referentienummer: " + request.getConversationId() + " to file at " + path);
	}

	private boolean validateFunctions(RechtspraakRequestBericht rechtspraakBericht) {
		StringWriter writer = new StringWriter();
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RechtspraakRequestBericht.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(rechtspraakBericht, writer);
			LOG.info(writer.toString());
			
			if (!checkConvId(rechtspraakBericht)) return false;
				
			if (!checkAction(rechtspraakBericht)) return false;

			if (!checkBestandsnaam(rechtspraakBericht)) return false;
			
			if (!validateAttachment(rechtspraakBericht)) return false;

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}

	private boolean checkConvId(RechtspraakRequestBericht rechtspraakBericht) {
		/**
		 * conversationId is mandatory!@arechtspraak  While we don't have the XSD , we can't use JAXB
		 * Soap response fault must be returned in case of false
		 */
		if (!StringUtils.isEmpty(rechtspraakBericht.getConversationId())) {
			return true;
		}

		faultMessage = "conversationId is empty";
		LOG.info(faultMessage);
		return false;
	}

	private boolean checkAction(RechtspraakRequestBericht rechtspraakBericht) {
		/*
		 * While we don't have a XSD (formally) we have to check the right actions.
		 * Spring injectoin could be used? for flexibility
		 * SOAP response fault must be returned in case of fault
		 */
		if (rechtspraakBericht.getAction().equals("BD-030001_Indiening") || rechtspraakBericht.getAction().equals("BD-030004_Verzoek_verstrekking"))
			return true;
		faultMessage = String.format("Action not valid or empty %s",rechtspraakBericht.getAction());
		LOG.info(faultMessage);
		
		return false;
	}

	private boolean checkBestandsnaam(RechtspraakRequestBericht rechtspraakBericht) {

		/**
		 * filenames MUST exist at the ebms interface missing filenames must raise an
		 * SOAP response error
		 */
	

		
		List<RechtspraakRequestBericht.Stuk> stukken = new ArrayList<RechtspraakRequestBericht.Stuk>();
		stukken = rechtspraakBericht.getStuk();
		for (RechtspraakRequestBericht.Stuk stuk : stukken) {
			if (stuk.getBestandsnaam() == null || StringUtils.isEmpty(stuk.getBestandsnaam()) || !(stuk.getBestandsnaam().endsWith(".pdf") || stuk.getBestandsnaam().endsWith(".PDF"))) {
				
				faultMessage = String.format("missing bestandsnaam %s", stuk.getBestandsnaam()) ;
				LOG.info(faultMessage);
				return false;
			}
			
		}
		return true;
	}

	private boolean validateAttachment(RechtspraakRequestBericht rechtspraakBericht) {
		/*
		 *  stukken is a List 
		 */
		
		
		List<RechtspraakRequestBericht.Stuk> stukken = new ArrayList<RechtspraakRequestBericht.Stuk>();
		stukken = rechtspraakBericht.getStuk();
		for (RechtspraakRequestBericht.Stuk stuk : stukken) { 
	   
			byte[] document =stuk.getContent();
	        LOG.info(new String(stuk.getContent()));
	  		if (!is_pdf(document)) {
	  			faultMessage=String.format("MIME of file:%s has no PDF header", stuk.getBestandsnaam());
	  			LOG.info(faultMessage);
				return false;
			} 
	  
			
		}

		return true;
	}

	/**
	 * Test if the data in the given byte array represents a PDF file.
	 */
	public static boolean is_pdf(byte[] data) {

		if (data != null && data.length > 4 && data[0] == 0x25 && // %
				data[1] == 0x50 && // P
				data[2] == 0x44 && // D
				data[3] == 0x46 && // F
				data[4] == 0x2D) { // -

			// search for the EOF markers
			if (data[data.length - 6] == 0x25 && data[data.length - 5] == 0x25 && data[data.length - 4] == 0x45
					&& data[data.length - 3] == 0x4F && data[data.length - 2] == 0x46) {
				return true;
			}
			if (data[data.length - 7] == 0x25 && data[data.length - 6] == 0x25 && data[data.length - 5] == 0x45
					&& data[data.length - 4] == 0x4F && data[data.length - 3] == 0x46) {
				return true;
			}
		}
		return false;
	}

}
