package aufgaben;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Lösung1 {

	public static void main(String[] args) {
		new Window();
	}
}

class Window extends JFrame {

	public Window() {
		init();
	}

	private void init() {
		setTitle("Aufgabe 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 500, 500);
		setResizable(false);
		addButton();
		setVisible(true);

	}

	private void addButton() {
		JButton addTextAreaButton = new JButton("add Textarea");
		addTextAreaButton.setMnemonic(KeyEvent.VK_C);
		addTextAreaButton.setBounds(10, 10, 100, 25);
		addTextAreaButton.addActionListener((event) -> addTextArea());
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		addTextAreaButton.setBorder(border);
		getContentPane().setLayout(null);
		addTextAreaButton.setOpaque(true);
		add(addTextAreaButton);
	}

	private void addTextArea() {
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 35, 200, 200);
		add(textArea);
		repaint();
	}
}
