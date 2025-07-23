package RestaurantBestellsystemT1.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;
    private String customerName;

    public Order(String customerName){
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        items.add(item);
    }

    public float calculateTotal(){
        float total = 0;
        for (MenuItem item : items){
            total += item.getPreis();
        }
        return total;
    }

    public void printReceipt(){
        System.out.println("===== QUITTUNG =====");
        System.out.println("Kunde: " + customerName);
        for (MenuItem item : items){
            System.out.println(item.getName() + " " + item.getPreis() + " €");
        }
        System.out.println("Gesamtbetrag: " + calculateTotal() + " €");
        System.out.println("Vielen Dank für Ihre Bestellung!");
    }
}
