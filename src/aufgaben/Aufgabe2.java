package aufgaben;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Aufgabe2 {
    private JFrame myFrame;

    public static void main(String[] args) {
        // Erstellt eine Instanz der Klasse Aufgabe1, was den Konstruktor aufruft.
        Aufgabe2 m = new Aufgabe2();
    }

    public Aufgabe2() {
        // Ruft die Methode initialize() auf, um das GUI-Fenster zu initialisieren.
        initialize();
    }

    private void initialize(){
        myFrame = new JFrame("Aufgabe2");
        myFrame.setSize(500, 500);
        myFrame.setResizable(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.getContentPane().setBackground(Color.PINK);

        GridBagLayout gridBag = new GridBagLayout();
        myFrame.getContentPane().setLayout(gridBag);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menü");
        menu.setMnemonic(KeyEvent.VK_M);

        JMenuItem addButtons = new JMenuItem("Add Buttons");
        addButtons.addActionListener((ActionEvent event) -> {
            addOneButton();
        });
        addButtons.setMnemonic(KeyEvent.VK_B);
        addButtons.setToolTipText("Add One Button");
        menu.add(addButtons);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Beendet das Programm.");
        exitMenuItem.addActionListener((ActionEvent event) -> System.exit(0));
        menu.add(exitMenuItem);

        menuBar.add(menu);
        myFrame.setJMenuBar(menuBar);
        myFrame.setVisible(true);
    }

    private void addOneButton(){
        JButton myButton = new JButton("Button Number " + (1 + myFrame.getContentPane().getComponentCount()));
        myButton.setSize(100, 25);
        myButton.setMargin(new Insets(5, 5, 5, 5));
        myButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        myButton.addActionListener((event) -> {
            System.exit(0);
        });
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = myFrame.getContentPane().getComponentCount();
        buttonConstraints.insets = new Insets(5, 5, 5, 5);
        myFrame.getContentPane().add(myButton, buttonConstraints);
        myFrame.revalidate();

    }
}
