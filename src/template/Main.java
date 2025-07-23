package template;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Main
{
    public static void main(String[] args)
    {
        Main m = new Main();
    }

    public Main()
    {
        initialize();
    }

    // Aufbau eines JFrame
    //
    // https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html
    //
    // JFrame ist das Standard-Fenster für die grafische Oberflächenprogrammierung
    // mit Swing.
    // Es nimmt alle anderen Container und Bedienelemente auf und vereint es zu
    // einer Oberfläche.
    // Aufbau:
    // => Frame:
    // Die hinterste Schicht der Gui
    // => RootPane:
    // Stellt den Anfang eines Frames und der dazugehörigen Container-Hierarchie
    // dar. Der RootPane enthält den sogenannten LayeredPane
    // => LayeredPane:
    // Kinder des LayeredPanes lassen sich je nach Verwendung verschieben. Ein
    // LayeredPane wiederum besitzt einen sogenannten ContentPane
    // => ContentPane inklusive JMenuBar:
    // enthält die eigentlichen Bedienelemente

    // Bedienelemente
    // JLabel => statischer Text, nicht editierbar

    // JButton => Schaltfläche (Button)

    // JToggleButton => Schaltfläche, welche zwei Zustände (gedrückt und nicht
    // gedrückt) kennt.

    // JCheckBox => Auswahlkästchen, das, wenn es ausgewählt wurde, mit einem
    // Häkchen oder Kreuz versehen wird.

    // JRadioButton => Schaltfläche zur Auswahl zwischen mehreren Optionen, in der
    // Regel sind sie in einer ButtonGroup angeordnet. Im Gegensatz zur JCheckBox
    // kann nur maximal eine Option selektiert werden.

    // ButtonGroup => Dient der Gruppierung von JRadioButtons. So kann
    // sichergestellt werden, dass tatsächlich nur ein Element aus der Gruppe
    // selektiert wurde.

    // JComboBox => Dropdown-Liste (auch als Auswahlliste oder Listbox bezeichnet),
    // die zur Auswahl eines Elementes aufgeklappt wird. Wenn die JComboBox
    // editierbar
    // ist, kann über ein Textfeld der ausgewählte Wert auch vom Anwender gesetzt
    // werden.

    // JList => Einfache Liste, die mehrere Elemente enthalten kann. Einfach- und
    // Mehrfachauswahl möglich.

    // JTextField => einfache einzeilige Texteingabe

    // JTextArea => einfache mehrzeilige Texteingabe
    // JScrollBar => Schieberegler zum Scrollen.

    // JSlider => Schieberegler, der mit einer Skala versehen werden kann.

    // JProgressBar => Fortschrittsbalken

    // JFormattedTextField => Textfeld, für welches eine Formatierung (z.B. für
    // Datumseingaben) festgelegt werden kann.

    // JPasswordField => Textfeld zur Passworteingabe. Für jeden eingegebenen
    // Buchstaben erscheint ein Sternchen oder ein anderer vorgegebener Character.

    // JSpinner => Ähnlich der JComboBox, allerdings klappt die Liste nicht auf,
    // sondern die Navigation durch die Liste erfolgt über Pfeiltasten.

    // JSeparator => einfache Trennlinie

    // JEditorPane => mehrzeiliges Textfeld zur Bearbeitung von formatiertem Text,
    // mit HTML- und RTF-Unterstützung.

    // JTextPane => Spezialisierung von JEditorPane, dient der Bearbeitung und
    // Anzeige grafisch aufbereiteter Texte.

    // JTree => Baumstruktur. Wird häufig verwendet, um Verzeichnisstrukturen
    // abzubilden, wie man es z.B. vom Windows Explorer kennt.

    // JTable => einfache Tabelle, kann auch Texteingaben entgegennehmen.

    // https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html

    private void initialize()
    {

        // JFrame instanziieren.
        // JFrame ist das Standard-Fenster für die grafische Oberfläche in Swing.
        // Es nimmt alle anderen Container und Bedienelemente auf und vereint es zu einer Oberfläche.
        JFrame meinFrame = new JFrame();

        // Titel des Fensters setzen
        meinFrame.setTitle("Mein erster Frame");

        // Die Position und Größe des Fensters kann mit setBounds() festgelegt werden.
        //meinFrame.setBounds(0, 0, 800, 600);
        // Alternativ nur für die Größe:
        meinFrame.setSize(400,300);

        // Soll das Fenster in der Größe nicht verändert werden können, kann das über setResizable() eingestellt werden.
        meinFrame.setResizable(false);

        // Das Programm soll beendet werden, wenn wir das Fenster schließen:
        meinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel instanziieren.
        // JLabel wird zur Anzeige von statischem Text verwendet, zum Beispiel um Eingabefelder zu beschriften.
        JLabel label = new JLabel("Mein erstes Label");

        // Horizontal und Vertical Alignment bestimmen die Ausrichtung des Textes innerhalb der JLabel-Komponenten.
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        // Um einen Rahmen um das Element zu erstellen, können wir die BorderFactory verwenden und die Border dem Label übergeben.
        // Die Farbe können wir mit Color-Konstanten aus dem AWT-Package festlegen, oder über den Konstruktor und RGB-Werten.
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        // Farbe über Color-Konstanten oder Konstruktor mit RGB-Werten.
        label.setBackground(new Color(171, 205, 247));

        // Damit wir den Hintergrund sehen können, muss das Label Opaque sein.
        label.setOpaque(true);

        // Das Standard-Layout des JFrames ist das BorderLayout.
        // Wenn Elemente fix im Fenster positioniert werden sollen, muss ein Null-Layout verwendet werden:
        //meinFrame.getContentPane().setLayout(null);

        // Größe und Position des Labels festlegen:
        //label.setSize(125,50);
        //label.setLocation(25, 25);
        //meinFrame.add(label);

        // Alternativ: GridBagLayout
        // https://javabeginners.de/Layout/GridBagLayout.php
        GridBagLayout gridBag = new GridBagLayout();
        meinFrame.getContentPane().setLayout(gridBag);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;

        // Label dem Frame hinzufügen:
        meinFrame.getContentPane().add(label, constraints);

        // JButton instanziieren.
        // Buttons sind Schaltflächen, auf die ein Anwender klicken kann.
        JButton button = new JButton("Mein erster Button");
        // Über ActionListener können wir bestimmen, was beim Klicken auf den Button geschehen soll.
        // Beispiel: Es soll ein Dialog geöffnet werden, der eine Meldung anzeigt.
        button.addActionListener((event) ->
            JOptionPane.showMessageDialog(meinFrame, "Der Button wurde geklickt!")
        );

        constraints.gridx = 0;
        constraints.gridy = 1;
        // Mit Insets bestimmen wir den Abstand zu anderen Elementen.
        constraints.insets = new Insets(10,10,10,10);

        // Button dem Frame hinzufügen:
        meinFrame.getContentPane().add(button, constraints);

        // JMenuBar instanziieren.
        // Eine MenuBar ist eine Leiste mit verschiedenen Buttons, über die Funktionieren aufgerufen werden können.
        // Beispiel: Hier in unserer IDE gibt es eine MenuBar mit den Menüs "File", "Edit", "View", "Navigate", etc...
        JMenuBar menuBar = new JMenuBar();

        // Menü-Items können über Icons verfügen, die wir hier über das Enum in unser Programm laden.
        ImageIcon exitIcon = new ImageIcon(Objects.requireNonNull(Icons.EXIT_16.getImage()));
        ImageIcon addButtonIcon = new ImageIcon(Objects.requireNonNull(Icons.ADDBUTTON_16.getImage()));

        // Eine MenuBar besteht aus mehreren Menüs (Klasse: JMenu)
        JMenu menu = new JMenu("Menü");

        // Fügt einen Shortcut hinzu → hier Alt+M
        menu.setMnemonic(KeyEvent.VK_M);

        // Ein Menü kann mehrere Menü-Items haben (Klasse: JMenuItem)
        JMenuItem exitMenuItem = new JMenuItem("Exit", exitIcon);
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Beendet das Programm.");
        // Menüitems funktionieren wie Buttons. Wir können ihnen ActionListener hinzufügen.
        // Beim Klick auf das Menüitem (oder generell beim Aktivieren des Menüitems) wird die Aktion ausgeführt.
        // System.exit() beendet das Programm.
        exitMenuItem.addActionListener((ActionEvent event) -> System.exit(0));
        menu.add(exitMenuItem);

        JMenuItem addMenuItem = new JMenuItem("Add", addButtonIcon);
        addMenuItem.setMnemonic(KeyEvent.VK_A);
        addMenuItem.setToolTipText("Fügt ein weiteres Label hinzu.");
        // Das Add-Menüitem soll ein neues Label der Oberfläche hinzufügen.
        addMenuItem.addActionListener((ActionEvent event) -> {
            JLabel neuesLabel = new JLabel("Ein Label");
            GridBagConstraints labelConstraints = new GridBagConstraints();
            labelConstraints.gridx = 0;
            labelConstraints.gridy = meinFrame.getContentPane().getComponentCount();

            meinFrame.getContentPane().add(neuesLabel, labelConstraints);

            // Mit revalidate() wird das neu hinzugefügte Element dargestellt.
            meinFrame.revalidate();

            // Manchmal ist auch ein repaint() notwendig.
            //meinFrame.repaint();
        });

        menu.add(addMenuItem);

        // Das Menü der Menüleiste hinzufügen:
        menuBar.add(menu);

        // Die Menüleiste dem Frame hinzufügen:
        meinFrame.setJMenuBar(menuBar);

        // Mit der pack()-Methode wird das Fenster auf die minimal notwendige Größe zum Anzeigen des Inhaltes gesetzt.
        // Der Aufruf dieser Methode überschreibt die vorher gesetzte feste größe des Fensters.
        //meinFrame.pack();

        // Um das Fenster in der Mitte des Bildschirms anzeigen zu lassen, kann setLocationRelativeTo(null) verwendet werden.
        meinFrame.setLocationRelativeTo(null);

        // Fenster maximieren:
        //meinFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Fenster-Icon festlegen:
        meinFrame.setIconImage(Icons.MEN_16.getImage());

        // Das Fenster anzeigen:
        meinFrame.setVisible(true);

    }

    // Wir können die Icons für unser Programm über ein Enum darstellen.
    // Die Konstante lässt sich im Code leicht aufrufen und hinter jeder Konstante steht dann der Dateiname.
    private enum Icons
    {
        // Jeweils eine Konstante pro Datei.
        ADDBUTTON_16("addButton_16.png"),
        EXIT_16("exit_16.png"),
        MEN_16("men_16.png");

        private String pfad;

        Icons(String pfad)
        {
            this.pfad = pfad;
        }

        // Lädt die Datei aus dem Resources-Ordner als Image-Objekt:
        public Image getImage()
		{
            // Mit getClass().getResource() können wir Ressourcen unseres Programmes abfragen.
            // Die Ressourcen sind im Resource-Ordner hinterlegt.
            // Ressourcen des Programmes werden beim Kompilieren in den Out-Ordner kopiert.
            // getResource() sucht dann in diesem Out-Ordner nach der gefragten Datei.
            URL url = getClass().getResource("/" + pfad);

			//System.out.println(url.getPath());
            // C:/Users/User/IdeaProjects/OPx/out/production/50_GUI_Einfuehrung/exit_16.png
            //C:/Users/User/IdeaProjects/OPx/out/production/50_GUI_Einfuehrung/addButton_16.png

            if (url != null)
            {
                try
                {
                    // ImageIO.read() liest die Datei am übergebenen Pfad und gibt sie als BufferedImage zurück.
                    return ImageIO.read(url);
                }
                catch (IOException ex)
                {
                    return null;
                }
            }
            return null;
        }
    }
}
