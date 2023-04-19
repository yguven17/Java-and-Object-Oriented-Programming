package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import computer.Computer;

public class ComputerStore extends JFrame {
	private ArrayList<Computer> computers;

	private final JTextField text;
	private final JLabel label;

	public ComputerStore() {
		super();
		computers = new ArrayList<Computer>();

		text = new JTextField(20);
		label = new JLabel();

		
		setSize(500, 100);
		setVisible(true);

		label.setText("Please press Enter after you write the filter name (wearable or portable)");
		label.setVisible(true);

		add(label);
		add(text);

		TextFieldHandler actions = new ComputerStore().new TextFieldHandler();
		text.addActionListener(actions);
	}

	public void addComputer(Computer computer) {
		computers.add(computer);
	}

	public void listComputers() {
		for (Computer computer : computers) {
			System.out.println(computer);
		}
	}

	private class TextFieldHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			// your code here.
			String string = text.getText();

			switch (string) {
			case "wearable":
				System.out.println("Wearable Computers:");
				for (Computer computer : computers) {

					if (computer.isWearable()) {
						System.out.println(computer.toString());
					}
				}

				break;
			case "portable":
				System.out.println("Portable Computers:");
				for (Computer computer : computers) {
					if (computer.isPortable()) {
						System.out.println(computer.toString());
					}
				}
				break;
			default:
				System.out.println("Unknown command");

			}

		}
	}
}
