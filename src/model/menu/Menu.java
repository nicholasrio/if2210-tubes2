package model.menu;

/**
 * An abstract class which represent a menu of food and beverage in Canteen.
 * @author created by : Riva Syafri Rachmatullah
 * @version 1.0
 * @since 1.4
 */
public abstract class Menu {
    protected int price;
    protected String name;
    
    /**
     * Set the new name of this menu.
     * @param name the new name of this menu
     * @since 1.0
     */
    public void setName(String name) {
        this.name = new String(name.toCharArray());
    }

    /**
     * Get the name of this menu.
     * @return the name of menu.
     * @since 1.0
     */
    public String getName() {
        return name;
    }

    /**
     * Set the new price of menu.
     * @param price the new price of this menu
     * @since 1.0
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Get the price of menu.
     * @return the price of menu (price).
     * @since 1.0
     */
    public int getPrice() {
        return price;
    }
}
