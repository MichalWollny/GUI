package RestaurantBestellsystemT2.gui;

import javax.swing.*;
import java.awt.*;

import RestaurantBestellsystemT2.model.*;

public class MainWindow {
    private JFrame appFrame;

    public static void main(String[] args) {
        MainWindow r = new MainWindow();
    }

    public MainWindow() {
        initialize();
    }

    private void initialize() {
        appFrame = new JFrame("RestaurantApp");
        appFrame.setSize(1400, 700);
        appFrame.setResizable(false);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setLayout(new BorderLayout());
        appFrame.setLocationRelativeTo(null);

        Order order = new Order("Kunde");

        BillPanel billPanel = new BillPanel(order);
        appFrame.add(billPanel, BorderLayout.EAST);

        MenuPanel menuPanel = new MenuPanel(order, billPanel, new CustomerPanel());
        appFrame.add(menuPanel, BorderLayout.WEST);

        appFrame.setVisible(true);
    }
}
