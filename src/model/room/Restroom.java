package model.room;

/**
 * A class which represent a restroom on building.
 * @author created by : Riva Syafri Rachmatullah 
 * @since 1.4
 * @version 1.0
 */
public class Restroom extends Room {
    /**
     * Constructs and initializes a restroom with its name and floor.
     * @param ID the ID of restroom that differentiate other restroom
     * @param floor the location of restroom in building
     * @since 1.0
     */
    public Restroom(String ID, int floor) {
        super(ID, floor);
    }
}
