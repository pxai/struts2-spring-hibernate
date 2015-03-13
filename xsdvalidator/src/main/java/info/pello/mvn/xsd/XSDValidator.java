
package info.pello.mvn.xsd;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

import org.xml.sax.SAXException;
import java.io.File;

/**
 * XSD file validator sample in a project using Maven:
 * To execute goto maven dir and:
 * java -cp target/xsdvalidator-0.0.1-SNAPSHOT.jar info.pello.mvn.xsd.XSDValidator
 * @author Pello Altadill
 * @greetz you, for reading this.
 */
public class XSDValidator {

	/**
	 * @param args
	 */
		public static void main(String [] args)  {
			// First we load both the schema and the xml to validate
			// sorry for the hardcoded file locations...
	        Source schemaFile = new StreamSource(new File("src/main/resources/hello.xsd"));
	        Source xmlFile = new StreamSource(new File("src/main/resources/hello.xml"));
	        
	        try{
	        	SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	        	Schema schema = schemaFactory.newSchema(schemaFile);
	        	Validator validator = schema.newValidator();
	            validator.validate(xmlFile);
	            System.out.println(xmlFile.getSystemId() + " file is VALID XML");
	        } catch (SAXException saxe) {
	            System.out.println(xmlFile.getSystemId() + " file is NOT VALID");
	            System.out.println("Message: " + saxe.getLocalizedMessage());
	        } catch (Exception e) {
	            System.out.println("Message: " + e.getMessage());
	        }
	    }


}
