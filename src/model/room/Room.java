package model.room;

/**
 * A class which represent a room on building.
 * @author created by : Yusuf Rahmatullah
 * @author modified by : Riva Syafri Rachmatullah
 * @since 1.2
 * @version 1.1
 */
public class Room {
    private int floor;
    private String name;

    /**
     * Constructs and initializes a room with its name and floor.
     * @param name the name of room
     * @param floor the location of room in building
     * @since 1.0
     */
    public Room(String name, int floor) {
        this.name = new String(name.toCharArray());
        this.floor = floor;
    }

    /**
     * Set the new name of this room.
     * @param name the new name of this room
     * @since 1.1
     */
    public void setName(String name) {
        this.name = new String(name.toCharArray());
    }

    /**
     * Get the name of this room.
     * @return the name of room.
     * @since 1.0
     */
    public String getName() {
        return name;
    }

    /**
     * Set the new location of room.
     * @param floor the new floor of this room
     * @since 1.0
     */
    public void setLocation(int floor) {
        this.floor = floor;
    }

    /**
     * Get the location of room.
     * @return the location of room (floor).
     * @since 1.0
     */
    public int getLocation() {
        return floor;
    }
}
