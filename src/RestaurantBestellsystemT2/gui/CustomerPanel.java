package RestaurantBestellsystemT2.gui;

import RestaurantBestellsystemT2.gui.BillPanel;

import javax.swing.*;
import java.awt.*;

public class CustomerPanel extends JPanel {
    private JLabel customerPanelText;
    private JTextField customerNameField;


    public CustomerPanel (){
        setLayout(new GridBagLayout());
        setBackground(Color.white);

        customerPanelText = new JLabel("Customer Name: ");

        customerNameField = new JTextField(20);

        GridBagConstraints gbcPanelText = new GridBagConstraints();
        gbcPanelText.gridx = 0;
        gbcPanelText.gridy = 0;
        gbcPanelText.anchor = GridBagConstraints.CENTER;
        gbcPanelText.insets = new Insets(10, 10, 10, 10);
        add(customerPanelText, gbcPanelText);

        GridBagConstraints gbcNameField = new GridBagConstraints();
        gbcNameField.gridx = 1;
        gbcNameField.gridy = 0;
        gbcNameField.anchor = GridBagConstraints.CENTER;
        gbcNameField.insets = new Insets(10, 10, 10, 10);
        add(customerNameField, gbcNameField);
    }

    public String getCustomerName() {
        return customerNameField.getText().trim();
    }

}
