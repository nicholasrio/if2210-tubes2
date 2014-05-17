/**
 *
 * @author Darwin Prasetio (13512015) Chrestella Stephanie (13512005) Jan Wira
 * Gotama Putra (13512015) Eric (13512021) Willy(13512070) Melvin Fonda
 * (13512085)
 */
package controller;

import exception.*;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.Player;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class MainMenuConsole {

    private List<Player> players = new ArrayList<Player>();
    private Player loginPlayer;
    private static MainMenuConsole instance = new MainMenuConsole();

    /**
     * Default Constructor
     */
    private MainMenuConsole() {
    }

    /**
     * Log player (username) to the game
     */
    public void login(String username) throws NameNotExistException {
        int idx = searchPlayer(username);
        if (idx != -1) {
            loginPlayer = players.get(idx);
        } else {
            throw new NameNotExistException();
        }
    }

    /**
     * Create new player within given username
     */
    public void newPlayer(String username) throws Exception {
        int idx = searchPlayer(username);
        if (idx != -1) {
            throw new NameExistException();
        } else {
            Player temp = new Player(username, 0);
            players.add(temp);
        }
    }

    /**
     * Delete player within given username
     */
    public void deletePlayer(String username) throws NameNotExistException {
        int idx = searchPlayer(username);
        if (idx != -1) {
            players.remove(idx);
        } else {
            throw new NameNotExistException();
        }
    }

    /**
     * Search player within given username
     */
    public int searchPlayer(String username) {
        int idx = -1;
        int i = 0;
        for (Player px : players) {
            if (username.equalsIgnoreCase(px.getName())) {
                idx = i;
                break;
            }
            i++;
        }
        return idx;
    }

    /**
     * Playing tower defense game
     */
    public void playGameConsole(boolean newGame) throws FileNotFoundException, IOException {
        GameController gameControl = GameController.getInstance();
        if (newGame == false) {
            gameControl.loadGame(loginPlayer);
        } else {
            gameControl.newGame(loginPlayer);
        }
        loginPlayer = gameControl.playGameConsole(loginPlayer);
        int idx = searchPlayer(loginPlayer.getName());
        players.get(idx).setHighScore(loginPlayer.getHighScore());
    }

    /*
     * Playing tower defense game with GIU
     */
    public void playGameGUI(boolean newGame) throws FileNotFoundException, IOException {
        GameController gameControl = GameController.getInstance();
        if (newGame == false) {
            gameControl.loadGame(loginPlayer);
        } else {
            gameControl.newGame(loginPlayer);
        }
        loginPlayer = gameControl.playGameGUI(loginPlayer);
        int idx = searchPlayer(loginPlayer.getName());
        players.get(idx).setHighScore(loginPlayer.getHighScore());
    }

    /**
     * Get player highscore
     */
    public List<Player> getHighScore() {
        SortPlayers();
        return players;
    }

    /**
     * Load player data
     */
    public void loadPlayer() throws FileNotFoundException {
        try {
            String path = "resources/";
            File fXmlFile = new File(path + "Playerlist.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("player");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    int highscore = Integer.parseInt(eElement.getElementsByTagName("highscore").item(0).getTextContent());
                    players.add(new Player(name, highscore));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sort palyers by highscore
     */
    private void SortPlayers() {
        for (int i = 0; i < players.size() - 1; i++) {
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(j).getHighScore() > players.get(i).getHighScore()) {
                    Player temp = players.get(j);
                    players.set(j, players.get(i));
                    players.set(i, temp);
                }
            }
        }
    }

    /**
     * get this class instance
     *
     * @return
     */
    public static MainMenuConsole getInstance() {
        return instance;
    }
    
    /**
     * Save player data
     */
    public void closePlayer() throws FileNotFoundException {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            org.w3c.dom.Document doc = docBuilder.newDocument();
            org.w3c.dom.Element rootElement = doc.createElement("tower_defense");
            doc.appendChild(rootElement);

            for (Player px : players) {
                // staff elements
                org.w3c.dom.Element player = doc.createElement("player");
                rootElement.appendChild(player);

                // firstname elements
                org.w3c.dom.Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(px.getName()));
                player.appendChild(name);

                // highscore elements
                org.w3c.dom.Element highscore = doc.createElement("highscore");
                highscore.appendChild(doc.createTextNode(String.valueOf(px.getHighScore())));
                player.appendChild(highscore);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            String path = "resources/";
            StreamResult result = new StreamResult(new File(path + "Playerlist.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException ex) {
            assert (false);
        }
    }

    /**
     * True if there's any player logged to the game
     */
    public boolean logged() {
        return loginPlayer != null;
    }
}
