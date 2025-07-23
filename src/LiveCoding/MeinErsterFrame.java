package LiveCoding;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class MeinErsterFrame {
    public static void main(String[] args) {
        JFrame meineErsterFrame = new JFrame("MeinErsterFrame");
        meineErsterFrame.setVisible(true);
        meineErsterFrame.setSize(400, 300);
        meineErsterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Erweiterung 1 durch ein Label->
        JLabel meinErstesLabel = new JLabel("Erstes Label");
        meinErstesLabel.setHorizontalAlignment(JLabel.CENTER);
        meinErstesLabel.setVerticalAlignment(JLabel.CENTER);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        meinErstesLabel.setBorder(border);
        meinErstesLabel.setVisible(true);
        meinErstesLabel.setBackground(new Color(171, 205, 247));
        meinErstesLabel.setOpaque(true);
//        meinErstesLabel.setSize(125, 50);
//        meinErstesLabel.setLocation(25,25);
//        meineErsterFrame.add(meinErstesLabel);

        // Erweiterung 2 durch das GridBagLayout->
        meinErstesLabel.setPreferredSize(new Dimension(125, 50));
        GridBagLayout gridBag = new GridBagLayout();
        meineErsterFrame.getContentPane().setLayout(gridBag);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        meineErsterFrame.getContentPane().add(meinErstesLabel, constraints);

        // Erweiterung 3 durch ein Button->
        JButton meinErsterButton = new JButton("Erster Button");
        meinErsterButton.addActionListener((event) ->
                JOptionPane.showMessageDialog(meineErsterFrame, "Der Button wurde geklickt!")
        );
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        meineErsterFrame.getContentPane().add(meinErsterButton, constraints);

        // Erweiterung 4 durch ein Menu und Icons->
        JMenuBar menuBar = new JMenuBar();
        ImageIcon exitIcon = new ImageIcon(Objects.requireNonNull(Icons.EXIT_16.getImage()));
        ImageIcon addButtonIcon = new ImageIcon(Objects.requireNonNull(Icons.ADDBUTTON_16.getImage()));
        JMenu menu = new JMenu("Menü");
        menu.setMnemonic(KeyEvent.VK_M);
        JMenuItem exitMenuItem = new JMenuItem("Exit", exitIcon);
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Beendet das Programm.");
        exitMenuItem.addActionListener((ActionEvent event) -> System.exit(0));
        menu.add(exitMenuItem);
        JMenuItem addMenuItem = new JMenuItem("Add", addButtonIcon);
        addMenuItem.setMnemonic(KeyEvent.VK_A);
        addMenuItem.setToolTipText("Fügt ein weiteres Label hinzu.");
        addMenuItem.addActionListener((ActionEvent event) -> {
            JLabel neuesLabel = new JLabel("Ein Label");
            GridBagConstraints labelConstraints = new GridBagConstraints();
            labelConstraints.gridx = 0;
            labelConstraints.gridy = meineErsterFrame.getContentPane().getComponentCount();
            meineErsterFrame.getContentPane().add(neuesLabel, labelConstraints);
            meineErsterFrame.revalidate();
        });

        menu.add(addMenuItem);
        menuBar.add(menu);
        meineErsterFrame.setJMenuBar(menuBar); //<- // Fenster-Icon festlegen: meinFrame.setIconImage(Icons.MEN_16.getImage());
    }

    private enum Icons {
        ADDBUTTON_16("addButton_16.png"), // Definiert eine Konstante mit dem Namen ADDBUTTON_16 und dem Pfad "addButton_16.png"
        EXIT_16("exit_16.png"), // Definiert eine Konstante mit dem Namen EXIT_16 und dem Pfad "exit_16.png"
        MEN_16("men_16.png"); // Definiert eine Konstante mit dem Namen MEN_16 und dem Pfad "men_16.png"
        private String pfad; // Definiert eine private Variable zum Speichern des Pfads

        Icons(String pfad) { // Der Konstruktor der enum, der den Pfad setzt
            this.pfad = pfad;
        }

        public Image getImage() {
            // Eine öffentliche Methode zum Abrufen des Bildes
            URL url = getClass().getResource("/" + pfad); // Versucht, die Ressource aus dem Pfad zu holen
            if (url != null) { // Wenn die Ressource gefunden wurde
                try {
                    return ImageIO.read(url); // Versucht, das Bild aus der URL zu lesen und zurückzugeben
                } catch (IOException ex) { // Wenn ein Fehler beim Lesen des Bildes auftritt
                    return null; // Gibt null zurück
                }
            }
            return null; // Wenn die Ressource nicht gefunden wurde, gibt null zurück
        }
    }
}
