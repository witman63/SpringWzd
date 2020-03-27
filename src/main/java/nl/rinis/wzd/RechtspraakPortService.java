package nl.rinis.wzd;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.4
 * 2019-11-09T16:19:54.340+01:00
 * Generated source version: 3.3.4
 *
 */
@WebServiceClient(name = "RechtspraakPortService",
                  wsdlLocation = "file:/Users/martindewit/development/SpringBoot/SpringWZD/src/main/resources/wsdl/cizrvdrV4.wsdl",
                  targetNamespace = "http://www.ciz.nl/rechtspraak/rinis/request/v4")
public class RechtspraakPortService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.ciz.nl/rechtspraak/rinis/request/v4", "RechtspraakPortService");
    public final static QName RechtspraakPortSoap12 = new QName("http://www.ciz.nl/rechtspraak/rinis/request/v4", "RechtspraakPortSoap12");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/martindewit/development/SpringBoot/SpringWZD/src/main/resources/wsdl/cizrvdrV4.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(RechtspraakPortService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/Users/martindewit/development/SpringBoot/SpringWZD/src/main/resources/wsdl/cizrvdrV4.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public RechtspraakPortService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RechtspraakPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RechtspraakPortService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public RechtspraakPortService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public RechtspraakPortService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public RechtspraakPortService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns RechtspraakPort
     */
    @WebEndpoint(name = "RechtspraakPortSoap12")
    public RechtspraakPort getRechtspraakPortSoap12() {
        return super.getPort(RechtspraakPortSoap12, RechtspraakPort.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RechtspraakPort
     */
    @WebEndpoint(name = "RechtspraakPortSoap12")
    public RechtspraakPort getRechtspraakPortSoap12(WebServiceFeature... features) {
        return super.getPort(RechtspraakPortSoap12, RechtspraakPort.class, features);
    }

}
