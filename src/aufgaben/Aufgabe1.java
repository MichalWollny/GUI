package aufgaben;

//Erstelle eine Gui welche auf Button Click ein TextArea hinzufügt
//        beachte folgendes
//        Gui
//        => soll einen Titel haben
//        => die größe soll 500 x 500 sein
//        => beim Schließen soll das Programm enden
//        => größe darf nicht veränderbar sein
//        Button
//        => soll einen ShortCut haben
//        => Soll als Aktion ein Textarea hinzufügen
//        => soll einen Border haben
//        => größe 100x25

// Importiert alle Klassen aus dem javax.swing-Paket, das für GUI-Komponenten verwendet wird.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aufgabe1 {
    // myFrame als Instanzvariable
    private JFrame myFrame;

    // Hauptmethode, der Einstiegspunkt des Programms.
    public static void main(String[] args) {
        // Erstellt eine Instanz der Klasse Aufgabe1, was den Konstruktor aufruft.
        Aufgabe1 m = new Aufgabe1();
    }

    // Konstruktor der Klasse Aufgabe1.
    public Aufgabe1() {
        // Ruft die Methode initialize() auf, um das GUI-Fenster zu initialisieren.
        initialize();
    }

    // Methode zur Initialisierung des GUI-Fensters.
    private void initialize() {
        // Erstellt ein neues JFrame-Fenster mit dem Titel "Aufgabe1".
        myFrame = new JFrame("Aufgabe1");
        // Macht das Fenster sichtbar.
        myFrame.setVisible(true);
        // Setzt die Größe des Fensters auf 500x500 Pixel.
        myFrame.setSize(500, 500);
        // Verhindert, dass das Fenster in der Größe verändert wird.
        myFrame.setResizable(false);
        // Beendet das Programm, wenn das Fenster geschlossen wird.
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Erstellt ein GridBagLayout für das Layout-Management.
        GridBagLayout gridBag = new GridBagLayout();
        // Setzt das Layout des Inhaltsbereichs des Fensters auf GridBagLayout.
        myFrame.getContentPane().setLayout(gridBag);
        // Erstellt Constraints für das GridBagLayout.
        GridBagConstraints constraints = new GridBagConstraints();

        // Erstellt einen neuen Button mit dem Text "Click Me".
        JButton myButton = new JButton("Click Me");
        myButton.setSize(100, 25);

        // Ein KeyStroke für den Shortcut (z.B. Strg + B)
        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl B");

        // InputMap und ActionMap des Buttons holen
        InputMap inputMap = myButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = myButton.getActionMap();

        // Den KeyStroke mit einem Namen in der InputMap verknüpfen
        inputMap.put(keyStroke, "buttonShortcut");

        // Eine Action erstellen, die die gewünschte Aktion ausführt
        actionMap.put("buttonShortcut", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTextField();
            }
        });

        // Fügt einen ActionListener hinzu, der auf Klicks reagiert.
        myButton.addActionListener((event) -> {
            addTextField();
        });

        // Setzt die x-Position des Buttons im GridBagLayout.
        constraints.gridx = 0;
        // Setzt die y-Position des Buttons im GridBagLayout.
        constraints.gridy = 0;
        // Setzt die Außenabstände um den Button herum.
        constraints.insets = new Insets(10, 10, 10, 10);
        // Fügt den Button dem Inhaltsbereich des Fensters mit den Constraints hinzu.
        myFrame.getContentPane().add(myButton, constraints);
    }

    private void addTextField(){
        // Aktion: Hinzufügen eines JTextArea
        JTextField newTextField = new JTextField("You actually clicked me! You bastard!");
        newTextField.setMargin(new Insets(5, 5, 5, 5));
        newTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GridBagConstraints textFieldConstraints = new GridBagConstraints();
        textFieldConstraints.gridx = 0;
        textFieldConstraints.gridy = myFrame.getContentPane().getComponentCount();
        textFieldConstraints.insets = new Insets(5, 5, 5, 5);
        myFrame.getContentPane().add(newTextField, textFieldConstraints);
        myFrame.revalidate();
    }
}
