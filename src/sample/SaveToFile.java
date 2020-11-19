package sample;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaveToFile implements Checkpoint {
    Document xmlFile;
    Element root;
    ArrayList<Memento> arrayList;
    File tempFile;
    public void saveGame(ArrayList<Memento> arrayList) throws ParserConfigurationException, IOException, SAXException, TransformerException {
         tempFile = new File("gameDocument.xml");
        boolean exists = tempFile.exists();
        if (!exists) {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            xmlFile = documentBuilder.newDocument();
            root = xmlFile.createElement("Saved");
            xmlFile.appendChild(root);
        } else {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            xmlFile = builder.parse(tempFile);
            root = xmlFile.getDocumentElement();
        }
        for (Memento x : arrayList) {
            Element userElement = xmlFile.createElement("user");
            root.appendChild(userElement);
            Text noOfLives = xmlFile.createTextNode(String.valueOf(x.getNoOfLives()));
            Element name = xmlFile.createElement("Numberoflives");
            name.appendChild(noOfLives);
            userElement.appendChild(name);
            Text scores = xmlFile.createTextNode(String.valueOf(x.getScore()));
            Element score = xmlFile.createElement("Score");
            score.appendChild(scores);
            userElement.appendChild(score);
            Text timer = xmlFile.createTextNode(String.valueOf(x.getTime()));
            Element time = xmlFile.createElement("Time");
            time.appendChild(timer);
            userElement.appendChild(time);
            Element userLevel=xmlFile.createElement("Level");
            Text userlevels=xmlFile.createTextNode(String.valueOf(x.getLevel()));
            userLevel.appendChild(userlevels);
            userElement.appendChild(userLevel);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(xmlFile);
        StreamResult streamResult = new StreamResult(new File("gameDocument.xml"));
        transformer.transform(domSource, streamResult);
    }
    public ArrayList<Memento> loadGame() throws IOException, SAXException, ParserConfigurationException {
         tempFile = new File("gameDocument.xml");
        boolean exists = tempFile.exists();
        arrayList = new ArrayList<Memento>();

        if (exists) {

            File document = new File("gameDocument.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document doc = builder.parse(document);
            NodeList nodeList = doc.getElementsByTagName("user");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nNode;
                    Memento memento = new Memento();
                    memento.setNoOfLives(Integer.parseInt(element.getElementsByTagName("Numberoflives").item(0).getTextContent()));
                    memento.setScore(Integer.parseInt(element.getElementsByTagName("Score").item(0).getTextContent()));
                    memento.setTime(Integer.parseInt(element.getElementsByTagName("Time").item(0).getTextContent()));
                    memento.setLevel(Integer.parseInt(element.getElementsByTagName("Level").item(0).getTextContent()));
                    arrayList.add(memento);

                }
            }

        }
        return arrayList;
    }
    public void delete(){
        tempFile = new File("gameDocument.xml");
        tempFile.delete();
    }
}
