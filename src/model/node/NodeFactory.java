package model.node;

import model.Point;

/**
 * Factory to create Node, Building, and Canteen.
 * @author Riva Syafri Rachmatullah
 * @version 1.0
 * @since 1.4
 */
public class NodeFactory {
    public static Node createNode(NodeType n, Point p, int ID) {
        Node node = null;
        switch (n) {
            case NODE:
                node = new Node(p, ID);
                break;
            case BUILDING:
                node = new Building(p, ID);
                break;
            case CANTEEN:
                node = new Canteen(p, ID);
                break;
            default:
                // throw some exception
                break;
        }
        return node;
    }
}
