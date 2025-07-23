package RestaurantBestellsystemT1;

import RestaurantBestellsystemT1.model.MenuItem;
import RestaurantBestellsystemT1.model.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantApp {
    private List<MenuItem> menu;

    public RestaurantApp() {
        menu = new ArrayList<>();
        menu.add(new MenuItem(1, "Pizza Margherita", 8.50f));
        menu.add(new MenuItem(2, "Spaghetti Carbonara", 9.50f));
        menu.add(new MenuItem(3, "Lasagne", 10.00f));
        menu.add(new MenuItem(4, "Tiramisu", 4.50f));
        menu.add(new MenuItem(5, "Caesar Salad", 7.00f));
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== WELCOME TO JAVA RESTAURANT =====");
        System.out.println("Unsere Speisekarte:");
        for (MenuItem item : menu){
            System.out.println(item);
        }

        System.out.println("Bitte geben Sie Ihren Namen ein: ");
        String customerName = scanner.nextLine();
        Order order = new Order(customerName);

        boolean ordering = true;
        while (ordering){
            System.out.print("Bitte wählen Sie ein Gericht anhand der ID: ");
            int itemId = scanner.nextInt();
            MenuItem selectedItem = menu.stream()
                    .filter(item -> item.getId() == itemId)
                    .findFirst()
                    .orElse(null);
            if (selectedItem != null){
                order.addItem(selectedItem);
                System.out.print("Möchten Sie noch etwas bestellen? (ja/nein): ");
                String more = scanner.next();
                ordering = more.equalsIgnoreCase("ja");
            } else {
                System.out.println("Ungültige ID. Bitte versuchen Sie es erneut.");
            }
        }
        order.printReceipt();
        scanner.close();
    }

    public static void main(String[] args) {
        RestaurantApp app = new RestaurantApp();
        app.start();
    }
}
