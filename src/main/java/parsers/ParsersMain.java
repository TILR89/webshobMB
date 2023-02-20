package parsers;

import entity.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParsersMain {
    private static final Logger logger = LogManager.getLogger(ParsersMain.class);

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        /*File newUsers = new File("src/main/java/parsers/users2.xml");


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(newUsers);
            NodeList usersList = document.getElementsByTagName("users");
            for (int i = 0; i < usersList.getLength(); i++) {
                Node u = usersList.item(i);
                if (u.getNodeType() == Node.ELEMENT_NODE) {
                    Element users = (Element) u;
                    String id = users.getAttribute("id");
                    NodeList nameList = users.getChildNodes();
                    for (int j = 0; j < nameList.getLength(); j++) {
                        Node n = nameList.item(j);
                        if (n.getNodeType() == Node.ELEMENT_NODE) {
                            Element name = (Element) n;
                            logger.info("Person " + id + ":" + name.getTagName() + " " + name.getTextContent());
                        }
                    }
                }

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException s) {
            s.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }

         */


        JsonReader jsonReader = new JsonReader();
        File json = new File("src/main/java/utils/webshop.json");

        List<Users> usersList = jsonReader.getPersons(json);
        for (Users user : usersList){
            logger.info(user);
        }







    }
}
