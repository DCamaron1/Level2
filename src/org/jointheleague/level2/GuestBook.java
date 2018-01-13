package org.jointheleague.level2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	ArrayList<String> guestList = new ArrayList<String>();

	public void CreateGUI() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setTitle("GuestBook");
		panel.add(button1);
		panel.add(button2);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button1.setText("Add Guest");
		button2.setText("View Guests");
		frame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == button1) {
			String newGuest = JOptionPane.showInputDialog("Enter name here:");
			System.out.println(newGuest);
			guestList.add(newGuest);
		}
		
		if (buttonPressed == button2) {
			String guestListNames = "";
			for (int i = 0; i < guestList.size(); i++) {
				int guestNum= i +1;
				guestListNames = guestListNames + "Guest " + guestNum + ": " + guestList.get(i) +"\n" ;
			}
			if (buttonPressed == button2 && guestListNames == "") {
				guestListNames = "There are no guests yet.";
			}
			JOptionPane.showMessageDialog(null, guestListNames);
			
		}
	}

	public static void main(String[] args) {
		GuestBook bob = new GuestBook();
		bob.CreateGUI();

	}
}
