package model.node;

import model.room.Room;
import model.Point;
import java.util.LinkedList;

/**
 * A class which represent a building with list of all the room it has and its
 * position on x and y in global position (GPS value).
 * @author created by : Yusuf Rahmatullah
 * @author modified by : Riva Syafri Rachmatullah and Yusuf Rahmatullah
 * @version 1.3
 * @since 1.0
 */
public class Building extends Node {
    private String name;
    private LinkedList<Room> listofrooms;

    /**
     * Constructs and initializes a building at the Point location.
     * @param P a point
     * @since 1.0
     */
    public Building(Point P) {
        super(P);
        listofrooms = new LinkedList<>();
    }

    /**
     * Constructs and initializes a building at the (x,y) location.
     * @param x the X coordinate of building
     * @param y the Y coordinate of building
     * @since 1.3
     */
    public Building(double x, double y) {
        super(x, y);
        listofrooms = new LinkedList<>();
    }
    
    /**
     * Constructs and initializes a building at the Point location with its ID.
     * @param P a point
     * @param ID ID of node
     * @since 1.3
     */
    public Building(Point P, int ID) {
        super(P, ID);
        listofrooms = new LinkedList<>();
    }
    
    /**
     * Constructs and initializes a building at the (x,y) location with its ID.
     * @param x the X coordinate of building
     * @param y the Y coordinate of building
     * @param ID ID of node
     * @since 1.3
     */
    public Building(double x, double y, int ID) {
        super(x, y, ID);
        listofrooms = new LinkedList<>();
    }
    
    /**
     * Set the name of building.
     * @param name the new name of building
     * @since 1.0
     */
    public void setName(String name) {
        this.name = new String(name.toCharArray());
    }

    /**
     * Get the name of building.
     * @return the name of building
     * @since 1.0
     */
    public String getName() {
        return name;
    }

    /**
     * Add room to list of room in building.
     * @param r the room to add.
     * @since 1.0
     */
    public void addRoom(Room r) {
        listofrooms.add(r);
    }

    /**
     * Remove room from list of rooms that building has.
     * @param r the room to remove from list
     */
    public void removeRoom(Room r) {
        assert(listofrooms.remove(r));
    }

    /**
     * Returns number of rooms on this building.
     * @return number of rooms
     * @since 1.1
     */
    public int numberOfRooms() {
        return listofrooms.size();
    }
    
    /**
     * Get list of rooms on this building.
     * @return the linked list of rooms on this building.
     * @since 1.2
     */
    public LinkedList<Room> getListOfRooms() {
        return listofrooms;
    }

    /**
     * Get room from list of room from certain index.
     * @param index index on list
     * @return element room of list on index.
     * @exception IndexOutOfBoundsException if the index is out of range 
     * (index < 0 || index >= numberOfRooms())
     * @since 1.2
     */
    public Room getRoom(int index) throws IndexOutOfBoundsException {
        return listofrooms.get(index);
    }
    
    
    
    /**
     * Set room from list of room on certain index.
     * @param index index on list
     * @param r new room on building replacing existing room on index.
     * @throws IndexOutOfBoundsException if the index is out of range 
     * (index < 0 || index >= numberOfRooms())
     * @since 1.2
     */
    public void setRoom(int index, Room r) throws IndexOutOfBoundsException {
        listofrooms.set(index, r);
    }
}
