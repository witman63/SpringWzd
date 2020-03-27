
package nl.ciz.rechtspraak.rinis.request.v3;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.ciz.rechtspraak.rinis.request.v3 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.ciz.rechtspraak.rinis.request.v3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RechtspraakRequestBericht }
     * 
     */
    public RechtspraakRequestBericht createRechtspraakRequestBericht() {
        return new RechtspraakRequestBericht();
    }

    /**
     * Create an instance of {@link RechtspraakRequestBericht.Stuk }
     * 
     */
    public RechtspraakRequestBericht.Stuk createRechtspraakRequestBerichtStuk() {
        return new RechtspraakRequestBericht.Stuk();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

}
