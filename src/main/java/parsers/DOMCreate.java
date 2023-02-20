package parsers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMCreate {
    private static final Logger logger = LogManager.getLogger(ParsersMain.class);

    public static void main(String [] args){
        String documentPath = "src/main/java/parsers/suppliers.xml";
        File f = new File(documentPath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("Suppliers");

            Element supplier = doc.createElement("Supplier");

            Element supplierID = doc.createElement("SupplierID");
            Text idValue = doc.createTextNode("4");
            supplierID.appendChild(idValue);

            Element supplierName = doc.createElement("SupplierName");
            Text nameValue = doc.createTextNode("WollyMart");
            supplierName.appendChild(nameValue);


            supplier.appendChild(supplierID);
            supplier.appendChild(supplierName);

            root.appendChild(supplier);

            doc.appendChild(root);

            DOMSource source = new DOMSource(doc);

            String path = "src/main/java/parsers/suppliers.xml";
            File file = new File(path);
            Result result = new StreamResult(file);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            logger.info("Data has been written successfully to file " + path);

        } catch (ParserConfigurationException e) {
            logger.log(Level.WARN, e);
        } catch (TransformerConfigurationException te) {
            logger.log(Level.WARN, te);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
