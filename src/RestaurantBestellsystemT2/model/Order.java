package RestaurantBestellsystemT2.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> billItemsArray;
    private String customerName;

    public Order(String customerName){
        this.customerName = customerName;
        this.billItemsArray = new ArrayList<>();
    }

    public void addToBill(MenuItem item){
        billItemsArray.add(item);
    }

    public float calculateTotal(){
        float total = 0;
        for (MenuItem item : billItemsArray){
            total += item.getPrice();
        }
        return total;
    }

    public List<MenuItem> getBillItemsArray(){
        return billItemsArray;
    }

}
