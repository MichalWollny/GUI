package RestaurantBestellsystemT2.model;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu {
    private List<MenuItem> menu;

    public RestaurantMenu(){
        menu = new ArrayList<>();
        menu.add(new MenuItem(1, "Pizza Margherita", 8.50f));
        menu.add(new MenuItem(2, "Spaghetti Carbonara", 9.50f));
        menu.add(new MenuItem(3, "Lasagne", 10.00f));
        menu.add(new MenuItem(4, "Tiramisu", 4.50f));
        menu.add(new MenuItem(5, "Caesar Salad", 7.00f));

    }

    public List<MenuItem> getMenuItems() {
        return menu;
    }
}
