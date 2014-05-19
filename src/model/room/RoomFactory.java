package model.room;

/**
 * Factory to create Room and Restroom.
 * @author Riva Syafri Rachmatullah
 * @version 1.0
 * @since 1.4
 */
public class RoomFactory {
    public static Room createRoom(RoomType r, String name, int floor) {
        Room room = null;
        switch (r) {
            case ROOM:
                room = new Room(name, floor);
                break;
            case RESTROOM:
                room = new Restroom(name, floor);
                break;
            default:
                // throw some exception
                break;
        }
        return room;
    }
}