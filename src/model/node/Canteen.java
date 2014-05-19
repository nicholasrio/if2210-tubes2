package model.node;

import java.util.LinkedList;
import model.Point;
import model.menu.Menu;

/**
 * A class which represent a canteen with list of all the menu it has and its
 * position on x and y in global position (GPS value).
 * @author created by : Riva Syafri Rachmatullah
 * @version 1.0
 * @since 1.4
 */
public class Canteen extends Node {
    private String name;
    private LinkedList<Menu> listofmenus;

    /**
     * Constructs and initializes a canteen at the Point location.
     * @param P a point
     * @since 1.0
     */
    public Canteen(Point P) {
        super(P);
        listofmenus = new LinkedList<>();
    }

    /**
     * Constructs and initializes a canteen at the (x,y) location.
     * @param x the X coordinate of canteen
     * @param y the Y coordinate of canteen
     * @since 1.3
     */
    public Canteen(double x, double y) {
        super(x, y);
        listofmenus = new LinkedList<>();
    }
    
    /**
     * Constructs and initializes a canteen at the Point location with its ID.
     * @param P a point
     * @param ID ID of node
     * @since 1.0
     */
    public Canteen(Point P, int ID) {
        super(P, ID);
        listofmenus = new LinkedList<>();
    }
    
    /**
     * Constructs and initializes a canteen at the (x,y) location with its ID.
     * @param x the X coordinate of canteen
     * @param y the Y coordinate of canteen
     * @param ID ID of node
     * @since 1.0
     */
    public Canteen(double x, double y, int ID) {
        super(x, y, ID);
        listofmenus = new LinkedList<>();
    }
    
    /**
     * Set the name of canteen.
     * @param name the new name of canteen
     * @since 1.0
     */
    public void setName(String name) {
        this.name = new String(name.toCharArray());
    }

    /**
     * Get the name of canteen.
     * @return the name of canteen
     * @since 1.0
     */
    public String getName() {
        return name;
    }

    /**
     * Add menu to list of menu in canteen.
     * @param m the menu to add.
     * @since 1.0
     */
    public void addMenu(Menu m) {
        listofmenus.add(m);
    }

    /**
     * Remove menu from list of menus that canteen has.
     * @param m the menu to remove from list
     */
    public void removeMenu(Menu m) {
        assert(listofmenus.remove(m));
    }

    /**
     * Returns number of menus on this canteen.
     * @return number of menus
     * @since 1.0
     */
    public int numberOfMenus() {
        return listofmenus.size();
    }
    
    /**
     * Get list of menus on this canteen.
     * @return the linked list of menus on this canteen.
     * @since 1.0
     */
    public LinkedList<Menu> getListOfMenus() {
        return listofmenus;
    }

    /**
     * Get menu from list of menu from certain index.
     * @param index index on list
     * @return element menu of list on index.
     * @exception IndexOutOfBoundsException if the index is out of range 
     * (index < 0 || index >= numberOfMenus())
     * @since 1.0
     */
    public Menu getMenu(int index) throws IndexOutOfBoundsException {
        return listofmenus.get(index);
    }
    
    /**
     * Set menu from list of menu on certain index.
     * @param index index on list
     * @param m new menu on canteen replacing existing menu on index.
     * @throws IndexOutOfBoundsException if the index is out of range 
     * (index < 0 || index >= numberOfMenus())
     * @since 1.0
     */
    public void setMenu(int index, Menu m) throws IndexOutOfBoundsException {
        listofmenus.set(index, m);
    }
}
