package RestaurantBestellsystemT2.gui;

import RestaurantBestellsystemT2.model.MenuItem;
import RestaurantBestellsystemT2.model.Order;
import RestaurantBestellsystemT2.gui.CustomerPanel;

import javax.swing.*;
import java.awt.*;

public class BillPanel extends JPanel {
    private JLabel billText;
    private JLabel billCustomer;
    private JList <MenuItem> billList;
    private JLabel billPrice;
    private DefaultListModel<MenuItem> billListModel;
    private Order order;

    public BillPanel(Order order) {
        this.order = order;

        setLayout(new GridBagLayout());
        setBackground(Color.white);

        setPreferredSize(new Dimension(600, 700));

        billText = new JLabel("===== QUITTUNG =====");

        billCustomer = new JLabel("Customer: Anonymous");

        billListModel = new DefaultListModel<>();
        billList = new JList<>(billListModel);

        billPrice = new JLabel("Your total is: 0.00 €");

        //Layout BillPanel
        GridBagConstraints gbcBillText = new GridBagConstraints();
        gbcBillText.gridx = 0;
        gbcBillText.gridy = 0;
        gbcBillText.anchor = GridBagConstraints.CENTER;
        gbcBillText.insets = new Insets(10, 10, 10, 10);

        GridBagConstraints gbcBillCustomer = new GridBagConstraints();
        gbcBillCustomer.gridx = 0;
        gbcBillCustomer.gridy = 1;
        gbcBillCustomer.anchor = GridBagConstraints.CENTER;
        gbcBillCustomer.insets = new Insets(10, 10, 10, 10);

        GridBagConstraints gbcBillList = new GridBagConstraints();
        gbcBillList.gridx = 0;
        gbcBillList.gridy = 2;
        gbcBillList.anchor = GridBagConstraints.CENTER;
        gbcBillList.insets = new Insets(10, 10, 10, 10);

        GridBagConstraints gbcBillPrice = new GridBagConstraints();
        gbcBillPrice.gridx = 0;
        gbcBillPrice.gridy = 3;
        gbcBillPrice.anchor = GridBagConstraints.CENTER;
        gbcBillPrice.insets = new Insets(10, 10, 10, 10);

        add(billText, gbcBillText);
        add(billCustomer, gbcBillCustomer);
        add(billList, gbcBillList);
        add(billPrice, gbcBillPrice);

        setVisible(true);
    }

    public void updateBillList(){
        billListModel.clear();
        for (MenuItem item : order.getBillItemsArray()){
            billListModel.addElement(item);
        }
        updateTotalPrice();
        billList.revalidate();
        billList.repaint();
    }

    public void updateTotalPrice(){
        float total = order.calculateTotal();
        billPrice.setText("Your total is: " + String.format("%.2f", total)+ " €");
    }

    public void setCustomerName(String name){
        if (!name.isEmpty()){
            billCustomer.setText("Customer: " + name);
        } else {
            billCustomer.setText("Customer: Anonymous");
        }
    }
}
