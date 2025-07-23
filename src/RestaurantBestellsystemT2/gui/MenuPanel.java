package RestaurantBestellsystemT2.gui;

import RestaurantBestellsystemT2.model.MenuItem;
import RestaurantBestellsystemT2.model.RestaurantMenu;
import RestaurantBestellsystemT2.model.Order;
import RestaurantBestellsystemT2.gui.CustomerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends JPanel {
    private JList<MenuItem> menuList;
    private JLabel welcomeText;
    private JLabel menuText;
    private Order order;
    private BillPanel billPanel;
    private CustomerPanel customerPanel;


    public MenuPanel(Order order, BillPanel billPanel, CustomerPanel customerPanel) {
        this.order = order;
        this.billPanel = billPanel;
        this.customerPanel = customerPanel;

        setLayout(new GridBagLayout());
        setBackground(Color.white);

        setPreferredSize(new Dimension(600, 700));

        welcomeText = new JLabel("===== WELCOME TO JAVA RESTAURANT =====");
        welcomeText.setFont(new Font("Serif", Font.BOLD, 22));

        menuText = new JLabel("Our Menu:");
        menuText.setFont(new Font("Serif", Font.BOLD, 18));

        DefaultListModel<MenuItem> menuListModel = new DefaultListModel<>();
        RestaurantMenu restaurantMenu = new RestaurantMenu();
        for (MenuItem item : restaurantMenu.getMenuItems()) {
            menuListModel.addElement(item);
        }

        menuList = new JList<>(menuListModel);
        menuList.setFont(new Font("Arial", Font.BOLD, 20));
        menuList.setCellRenderer(new ListCellRenderer<MenuItem>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends MenuItem> list, MenuItem value, int index, boolean isSelected, boolean cellHasFocus) {
                JButton restaurantMenuButton = new JButton(value.toString());
                restaurantMenuButton.setHorizontalAlignment(SwingConstants.LEFT);

                if (isSelected) {
                    restaurantMenuButton.setBackground(list.getSelectionBackground());
                    restaurantMenuButton.setForeground(list.getSelectionForeground());
                } else {
                    restaurantMenuButton.setBackground(list.getBackground());
                    restaurantMenuButton.setForeground(list.getForeground());
                }

                return restaurantMenuButton;
            }
        });

        menuList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = menuList.locationToIndex(e.getPoint());
                if (index != -1) {
                    MenuItem selectedItem = menuList.getModel().getElementAt(index);
                    order.addToBill(selectedItem);
                    String customerName = customerPanel.getCustomerName();
                    billPanel.setCustomerName(customerName);
                    billPanel.updateBillList();
                }
            }
        });

        GridBagConstraints gbcCustomerPanel = new GridBagConstraints();
        gbcCustomerPanel.gridx = 0;
        gbcCustomerPanel.gridy = 0;
        gbcCustomerPanel.anchor = GridBagConstraints.CENTER;
        gbcCustomerPanel.insets = new Insets(10, 10, 10, 10);
        add(customerPanel, gbcCustomerPanel);

        GridBagConstraints gbcText1 = new GridBagConstraints();
        gbcText1.gridx = 0;
        gbcText1.gridy = 1;
        gbcText1.anchor = GridBagConstraints.CENTER;
        gbcText1.insets = new Insets(10, 10, 10, 10);
        add(welcomeText, gbcText1);

        GridBagConstraints gbcText2 = new GridBagConstraints();
        gbcText2.gridx = 0;
        gbcText2.gridy = 2;
        gbcText2.anchor = GridBagConstraints.CENTER;
        gbcText2.insets = new Insets(10, 10, 10, 10);
        add(menuText, gbcText2);

        GridBagConstraints gbcList = new GridBagConstraints();
        gbcList.gridx = 0;
        gbcList.gridy = 3;
        gbcList.anchor = GridBagConstraints.CENTER;
        gbcList.insets = new Insets(10, 10, 10, 10);
        add(new JScrollPane(menuList), gbcList);
    }
}
