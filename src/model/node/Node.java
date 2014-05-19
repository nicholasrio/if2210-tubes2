package model.node;

import java.util.LinkedList;
import model.Point;

/**
 * A point representing a location in (x,y) coordinate space on Earth position,
 * specified in double precision.
 * @author created by : Joshua Bezaleel Abednego
 * @author modified by : Riva Syafri Rachmatullah and Yusuf Rahmatullah
 * @version 1.4
 * @since 1.0
 */
public class Node {
    private int ID;
    private Point location;
    LinkedList<Integer> neighborID;
    
    /**
     * Constructs and initializes a node at the Point location.
     * @param p a point
     * @since 1.1
     */
    public Node(Point p) {
        ID = 0;
        location = p;
        neighborID = new LinkedList<>();
    }
    
    /**
     * Constructs and initializes a node at the (x,y) location.
     * @param x the X coordinate
     * @param y the Y coordinate
     * @since 1.3
     */
    public Node(double x, double y) {
        ID = 0;
        location = new Point(x, y);
        neighborID = new LinkedList<>();
    }

    /**
     * Constructs and initializes a node at the Point location with its ID.
     * @param p a point
     * @param ID ID of node
     * @since 1.4
     */
    public Node(Point p, int ID) {
        this.ID = ID;
        location = p;
        neighborID = new LinkedList<>();
    }
    
    /**
     * Constructs and initializes a node at the (x,y) location with its ID.
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param ID ID of node
     * @since 1.4
     */
    public Node(double x, double y, int ID) {
        this.ID = ID;
        location = new Point(x, y);
        neighborID = new LinkedList<>();
    }
    
    /**
     * Set location of node to point location.
     * @param p a point
     * @since 1.1
     */
    public void setLocation(Point p) {
        location = p;
    }

    /**
     * Set location of node to (x,y) location.
     * @param x the new X coordinate.
     * @param y the new Y coordinate.
     * @since 1.3
     */
    public void setLocation(double x, double y) {
        location = new Point(x, y);
    }
    
    /**
     * Get location of node which return a point.
     * @return location of node.
     * @since 1.1
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Get the ID of this node.
     * @return ID of this node
     * @since 1.3
     */
    public int getID() {
        return ID;
    }   
    
    /**
     * Set the ID of this node
     * @param ID ID of this node
     * @since 1.4
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
    /**
     * Get list of adjacency node correspond to this node.
     * @return the linked list of adjacency node which contain the ID of node.
     * @since 1.2
     */
    public LinkedList<Integer> getListOfNeighbours() {
        return neighborID;
    }

    /**
     * Returns number of neighbor node correspond to this node.
     * @return number of neighbor
     * @since 1.2
     */
    public int numberOfNeighbor() {
        return neighborID.size();
    }
    
    /**
     * Get ID of neighbor node from list of neighbor node from certain index.
     * @param index index on list
     * @return element of list on index.
     * @exception IndexOutOfBoundsException if the index is out of range 
     * (index < 0 || index >= numberofNeighbor())
     * @since 1.3
     */
    public Integer getIDNeighbor(int index) throws IndexOutOfBoundsException {
        return neighborID.get(index);
    }
    
    /**
     * Set ID of neighbor node from list of neighbor node on certain index.
     * @param index index on list
     * @param ID new ID Node element of list.
     * @throws IndexOutOfBoundsException if the index is out of range 
     * (index < 0 || index >= numberofNeighbor())
     * @since 1.3
     */
    public void setIDNeighbor(int index, Integer ID) throws IndexOutOfBoundsException {
        neighborID.set(index, ID);
    }
    
    /**
     * Add ID of node to list of adjacency node which means that the node with 
     * that ID is adjacent to this node.
     * @param ID ID of node
     * @since 1.1
     */
    public void addNeighbor(int ID) {
        neighborID.add(ID);
    }

    /**
     * Remove ID of node from list of adjacency node which means that node with 
     * that ID is not adjacent anymore to this node.
     * @param ID ID of Node that wants to be removed
     * @since 1.1
     */
    public void removeNeighbor(Integer ID) {
        assert(neighborID.remove(ID));
    }
}
