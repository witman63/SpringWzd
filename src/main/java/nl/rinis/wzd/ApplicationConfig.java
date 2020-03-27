package nl.rinis.wzd;

import javax.xml.ws.BindingType;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.ext.logging.AbstractLoggingInterceptor;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;

import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

@Configuration

public class ApplicationConfig {

	@Bean

	public ServletRegistrationBean<CXFServlet> dispatcherServlet() {

		return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/WzdService/*");

	}

	@Bean

	@Primary

	public DispatcherServletPath dispatcherServletPathProvider() {

		return () -> "";

	}

	@Bean(name = Bus.DEFAULT_BUS_ID)

	public SpringBus springBus(LoggingFeature loggingFeature) {

		SpringBus cxfBus = new SpringBus();

		cxfBus.getFeatures().add(loggingFeature);
		
		
		cxfBus.getInInterceptors().add(logInInterceptor());
	    cxfBus.getInFaultInterceptors().add(logInInterceptor());
	    cxfBus.getOutInterceptors().add(logOutInterceptor());
	    cxfBus.getOutFaultInterceptors().add(logOutInterceptor());

		return cxfBus;

	}

	@Bean

	public LoggingFeature loggingFeature() {

		LoggingFeature loggingFeature = new LoggingFeature();

		loggingFeature.setPrettyLogging(true);

		return loggingFeature;

	}

	@Bean
	public AbstractLoggingInterceptor logInInterceptor() {
	    LoggingInInterceptor logInInterceptor = new LoggingInInterceptor();
	  
	    return logInInterceptor;
	}

	@Bean
	public AbstractLoggingInterceptor logOutInterceptor() {
	    LoggingOutInterceptor logOutInterceptor = new LoggingOutInterceptor();
	    logOutInterceptor.setPrettyLogging(true);
	    return logOutInterceptor;
	}
	
	@Bean

	public Endpoint endpoint(Bus bus, RechtspraakPortSoap12Impl rechtspraakServiceEndpoint,LoggingFeature logFeature) {

	
		
		
		
		
		EndpointImpl endpoint = new EndpointImpl(bus, rechtspraakServiceEndpoint);

		endpoint.setBindingUri(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING);
	
		endpoint.publish("/ciz/endpoint");
		
		endpoint.getFeatures().add(logFeature);
		
		return endpoint;

	}

}