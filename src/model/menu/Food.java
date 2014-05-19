package model.menu;

/**
 * A class which represent a food menu in Canteen.
 * @author created by : Riva Syafri Rachmatullah
 * @version 1.0
 * @since 1.4
 */
public class Food extends Menu {
    
    /**
     * Constructs and initializes a food menu with its name and price.
     * @param name the name of menu
     * @param price the price of menu in building
     * @since 1.0
     */
    public Food(String name, int price) {
        this.name = new String(name.toCharArray());
        this.price = price;
    }
}
