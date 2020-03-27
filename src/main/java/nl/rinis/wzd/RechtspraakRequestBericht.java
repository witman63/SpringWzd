
package nl.rinis.wzd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ConversationId" type="{http://www.ciz.nl/rechtspraak/rinis/request/v4}Token60"/&gt;
 *         &lt;element name="Action"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="BD-030001_Indiening"/&gt;
 *               &lt;enumeration value="BD-030004_Verzoek_verstrekking"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Stuk" maxOccurs="1729" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="MimeContentType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="MimeContentId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Bestandsnaam" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;pattern value="[a-zA-Z0-9 ][a-zA-Z0-9 -.]{0,199}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Content"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;any processContents='lax' namespace='##other'/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "conversationId",
    "action",
    "stuk",
    "content"
})
@XmlRootElement(name = "RechtspraakRequestBericht")
public class RechtspraakRequestBericht {

    @XmlElement(name = "ConversationId", required = true)
    protected String conversationId;
    @XmlElement(name = "Action", required = true)
    protected String action;
    @XmlElement(name = "Stuk")
    protected List<RechtspraakRequestBericht.Stuk> stuk;
    @XmlElement(name = "Content", required = true)
    protected RechtspraakRequestBericht.Content content;

    /**
     * Gets the value of the conversationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConversationId() {
        return conversationId;
    }

    /**
     * Sets the value of the conversationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConversationId(String value) {
        this.conversationId = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the stuk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stuk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStuk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RechtspraakRequestBericht.Stuk }
     * 
     * 
     */
    public List<RechtspraakRequestBericht.Stuk> getStuk() {
        if (stuk == null) {
            stuk = new ArrayList<RechtspraakRequestBericht.Stuk>();
        }
        return this.stuk;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link RechtspraakRequestBericht.Content }
     *     
     */
    public RechtspraakRequestBericht.Content getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link RechtspraakRequestBericht.Content }
     *     
     */
    public void setContent(RechtspraakRequestBericht.Content value) {
        this.content = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;any processContents='lax' namespace='##other'/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class Content {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * Gets the value of the any property.
         * 
         * @return
         *     possible object is
         *     {@link Element }
         *     {@link Object }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         * 
         * @param value
         *     allowed object is
         *     {@link Element }
         *     {@link Object }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="MimeContentType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="MimeContentId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Bestandsnaam" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;pattern value="[a-zA-Z0-9 ][a-zA-Z0-9 -.]{0,199}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mimeContentType",
        "mimeContentId",
        "bestandsnaam",
        "content"
    })
    public static class Stuk {

        @XmlElement(name = "MimeContentType", required = true)
        protected String mimeContentType;
        @XmlElement(name = "MimeContentId", required = true)
        protected String mimeContentId;
        @XmlElement(name = "Bestandsnaam")
        protected String bestandsnaam;
        @XmlElement(name = "Content", required = true)
        protected byte[] content;

        /**
         * Gets the value of the mimeContentType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMimeContentType() {
            return mimeContentType;
        }

        /**
         * Sets the value of the mimeContentType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMimeContentType(String value) {
            this.mimeContentType = value;
        }

        /**
         * Gets the value of the mimeContentId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMimeContentId() {
            return mimeContentId;
        }

        /**
         * Sets the value of the mimeContentId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMimeContentId(String value) {
            this.mimeContentId = value;
        }

        /**
         * Gets the value of the bestandsnaam property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBestandsnaam() {
            return bestandsnaam;
        }

        /**
         * Sets the value of the bestandsnaam property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBestandsnaam(String value) {
            this.bestandsnaam = value;
        }

        /**
         * Gets the value of the content property.
         * 
         * @return
         *     possible object is
         *     byte[]
         */
        public byte[] getContent() {
            return content;
        }

        /**
         * Sets the value of the content property.
         * 
         * @param value
         *     allowed object is
         *     byte[]
         */
        public void setContent(byte[] value) {
            this.content = value;
        }

    }

}
