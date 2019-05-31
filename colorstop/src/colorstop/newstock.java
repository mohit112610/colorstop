package colorstop;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class newstock extends JFrame {
	JButton b1,b2;
	JLabel l3;
newstock(String user, String pass){
	setSize(756,780);
	setResizable(false);
	setLayout(null);
	getContentPane().setBackground(Color.WHITE);
	setTitle("ColorStop: One stop destination for managing all your business data");
	b1 = new JButton("New Stock");
	b2 = new JButton("View Stock");
	l3 = new JLabel(new ImageIcon("C:/Users/Mohit Kumar/Desktop/supplies.jpg"));
	l3.setBounds(-300,150,1200,800);
	add(l3);
	//b3 = new JButton("Billing System");
	//b4 = new JButton("Profit/Loss");
	//b5 = new JButton("New Type/Brand");
	b1.setBounds(300,150,150,35);
	b2.setBounds(300,195,150,35);
	//b3.setBounds(300,240,150,35);
	//b4.setBounds(300,285,150,35);
	//b5.setBounds(300,330,150,35);
	add(b1);add(b2);
	//add(b5);
	setVisible(true);
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			setVisible(false);
			new b1(user,pass);
		}
	});
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			setVisible(false);
			new b2(user,pass);
		}
	});
	/*b3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			
		}
	});
	b4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			
		}
	});
	b5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			
		}
	});*/
}
}
