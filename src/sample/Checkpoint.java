package sample;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.SAXException;

public interface Checkpoint {
    public void saveGame(ArrayList<Memento> arrayList) throws ParserConfigurationException, IOException, SAXException, TransformerException;

    public ArrayList<Memento> loadGame() throws IOException, SAXException, ParserConfigurationException ;
}
