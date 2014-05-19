package model.menu;

/**
 * Factory to create a menu of food or beverage.
 * @author Riva Syafri Rachmatullah
 * @version 1.0
 * @since 1.4
 */
public class MenuFactory {
    public static Menu createMenu(MenuType n, String name, int price) {
        Menu menu = null;
        switch (n) {
            case FOOD:
                menu = new Food(name, price);
                break;
            case BEVERAGE:
                menu = new Beverage(name, price);
                break;
            default:
                // throw some exception
                break;
        }
        return menu;
    }
}
