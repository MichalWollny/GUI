package aufgaben;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.Border;

public class Lösung2 {

	public static void main(String[] args) {
		new Loesung2();
	}

}

class Loesung2 extends JFrame {

	private static int y = 0;
	private static int x = 10;
	private static int buttonCounter = 0;

	public Loesung2() {
		init();
	}

	private void init() {
		setTitle("Aufgabe 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 425, 425);
		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(null);
		setResizable(false);
		addJMenuToFrame();
		setVisible(true);

	}

	private void addJMenuToFrame() {

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Add");

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		// Mit this.getClass().getResource() können wir auf Ressourcen (z.B. Bilder) zugreifen und diese in unser Programm laden.
		// alternative Variante: Loesung2.class.getResource()
		exitMenuItem.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/exit_16.png"))));
		exitMenuItem.setToolTipText("Exit application");
		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenuItem addButtonMenuItem = new JMenuItem("Add");
		addButtonMenuItem.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/addButton_16.png"))));
		addButtonMenuItem.setToolTipText("Add Button");
		addButtonMenuItem.addActionListener((event) -> addButtonToFrame());

		fileMenu.add(addButtonMenuItem);
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);
		setJMenuBar(menuBar);

	}

	private void addButtonToFrame() {

		JButton someButton = new JButton(String.format("Button Nr.: %d => Exit", buttonCounter + 1));
		someButton.addActionListener((event) -> System.exit(0));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		someButton.setBorder(border);

		if (buttonCounter % 3 == 0) {
			x = 10;
			someButton.setBounds(x, y += 35, 125, 25);
		} else {
			someButton.setBounds(x += 135, y, 125, 25);
		}
		getContentPane().add(someButton);
		repaint();
		buttonCounter++;
	}

}