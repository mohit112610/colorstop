
package colorstop;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class b1 extends JFrame{
	JComboBox<String> b1,b2,b3;
	
	String day[] = new String[31];
	String month[] = new String[12];
	
	String [] a = {"Paints","Primers","PaintBrush","Cement"};
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,label;
	Statement st;
	int lot,quan,cost;
	Double weigh;
	String brand,color,date;
	Date df;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton jb1,back;
	JPanel panel = new JPanel();
	b1(String user,String pass){
		getContentPane().setBackground(Color.WHITE);
		for(int i=0;i<day.length;i++)
		{
			
			day[i]=new DecimalFormat("00").format(i+1);
		}
		for(int i=0;i<month.length;i++)
		{
			month[i]= new DecimalFormat("00").format(i+1);
		}
		back = new JButton("Go Back <- ");
		top ab = new top();
		setSize(756,780);
		setResizable(false);
		setLayout(null);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		setTitle("ColorStop: One stop destination for managing all your business data");
		l1 = new JLabel("Please select the type of stock you want to add");
		l2 = new JLabel("Brand");
		l3 = new JLabel ("Cost Price");
		label = new JLabel(new ImageIcon("C:/Users/Mohit Kumar/Desktop/supplies.jpg"));
		label.setBounds(-300,150,1200,800);
		l4 = new JLabel("Quantity");
		l5 = new JLabel("Expiry Date");
		l6 = new JLabel("Lot No.");
		l11= new JLabel("Weight");
		l12 = new JLabel("PaintColor");
		t1 = new JTextField("");
		t2 = new JTextField("");
		t3 = new JTextField("");
		t4 = new JTextField("");
		t5 = new JTextField("");
		t6 = new JTextField("");
		t7 = new JTextField("");
		l8 = new JLabel("day");
		l9 = new JLabel("month");
		l10 = new JLabel("year");
		jb1 = new JButton("Submit");
		
		b1 = new JComboBox<String>(a);
		b2 = new JComboBox<String>(day);
		b3 = new JComboBox<String>(month);		
		
		l1.setBounds(150,150,350,25);
		b1.setSelectedItem(null);
	b1.setBounds(445,150,150,25);
	panel.setBounds(100,200,550,400);
	panel.setBorder(BorderFactory.createLineBorder(Color.gray));
	l2.setBounds(125,80,100,25);
	l3.setBounds(125,115,100,25);
	l4.setBounds(125,150,100,25);
	l5.setBounds(125,185,100,25);
	l6.setBounds(125,220,100,25);
	t1.setBounds(255,80,100,25);
	t2.setBounds(255,115,100,25);
	t3.setBounds(255,150,100,25);
	t4.setBounds(255,220,100,25);
	b2.setBounds(255,185,40,25);
	l8.setBounds(300,185,25,25);
	b3.setBounds(325,185,40,25);
	l9.setBounds(370,185,40,25);
	t5.setBounds(415,185,40,25);
	l10.setBounds(460,185,55,25);
	l11.setBounds(125,250,100,25);
	l12.setBounds(125,280,100,25);
	jb1.setBounds(255,310,100,25);
	t6.setBounds(255,250,100,25);
	t7.setBounds(255,280,100,25);
	back.setBounds(50,50,100,50);
	add(panel);
	add(l1);
	add(b1);
	setVisible(true);
	add(back);
	add(label);
	back.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			new newstock(user,pass);
			
		}
		
	});
	
	b1.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {
			try {
				st = ab.connect(user,pass).createStatement();
			if(arg0.getItem()=="Paints") {
				clear();
				
				l7 = new JLabel("Add new stock details for "+arg0.getItem());
				l7.setBounds(150,30,200,50);
				
				panel.removeAll();
				panel.add(l2);
				panel.add(l3);
				panel.add(l4);
				panel.add(l5);
				panel.add(t2);
				panel.add(t3);
				panel.add(t4);
				panel.add(t5);
				panel.add(t1);
				panel.add(l6);
				panel.add(jb1);
				panel.add(l8);
				panel.add(l7);
				panel.add(l9);
				panel.add(b2);
				panel.add(b3);
				panel.add(l10);
				panel.add(l11);
				panel.add(l12);
				panel.add(t6);
				panel.add(t7);
				
				jb1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						
						try {	
							check();
						st.executeUpdate("insert into paints values(null,'"+brand+"','"+cost+"','"+lot+"','"+color+"','"	+df+"','"+quan+"','"+weigh+"')");
					}
						catch(Exception ae){
							//System.out.println(ae);
							JOptionPane.showMessageDialog(null,"Enter correct values");
						}
					}
					
				});
				SwingUtilities.updateComponentTreeUI(panel);
			}
			if(arg0.getItem()=="Primers") {clear();
				l7 = new JLabel("Add new stock details for "+arg0.getItem());
				l7.setBounds(150,30,200,50);
				panel.removeAll();
				panel.add(l2);
				panel.add(l3);
				panel.add(l4);
				panel.add(l5);
				panel.add(t2);
				panel.add(t3);
				panel.add(t5);
				panel.add(b2);
				panel.add(b3);
				panel.add(l8);
				panel.add(l9);
				panel.add(l10);
				panel.add(t1);
				panel.add(jb1);
				panel.add(l7);
				panel.add(l6);
				panel.add(t4);
				panel.add(t6);
				panel.add(l11);
				jb1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg1) {
						
						try {	
							check();
						st.executeUpdate("insert into primers values(null,'"+brand+"','"+cost+"','"+quan+"','"+df+"','"	+lot+"','"+weigh+"')");
					}
						catch(Exception ae){
							//System.out.println(ae);
							JOptionPane.showMessageDialog(null,"Enter correct values");
						}
					}
					
				});
				
				SwingUtilities.updateComponentTreeUI(panel);
			}
			if(arg0.getItem()=="PaintBrush") {
				clear();
				l7 = new JLabel("Add new stock details for "+arg0.getItem());
				l7.setBounds(150,30,200,50);
				panel.removeAll();
				panel.add(l2);
				panel.add(l3);
				panel.add(t1);
				panel.add(t2);
				panel.add(jb1);
				panel.add(l7);
				panel.add(t3);
				panel.add(l4);
				jb1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg2) {
						try {	
							check();	
						st.executeUpdate("insert into paintbrush values(null,'"+brand+"','"+cost+"','"+quan+"')");
					}
						catch(Exception ae){
							//String x = ae.getMessage().replaceAll("For input string:","Enter correct value in");
							JOptionPane.showMessageDialog(null,"Enter correct values");
						}
					}
					
				});
				SwingUtilities.updateComponentTreeUI(panel);
			}
			if(arg0.getItem()=="Cement") {
				clear();
				l7 = new JLabel("Add new stock details for "+arg0.getItem());
				l7.setBounds(150,30,200,50);
				panel.removeAll();
				panel.add(l2);
				panel.add(l3);
				panel.add(l4);
				panel.add(l5);
				panel.add(t2);
				panel.add(t3);
				panel.add(t5);
				panel.add(b2);
				panel.add(b3);
				panel.add(l8);
				panel.add(l9);
				panel.add(l10);
				panel.add(t1);
				panel.add(jb1);
				panel.add(l7);
				panel.add(l6);
				panel.add(t4);
				panel.add(t6);
				panel.add(l11);
				
				
				
				jb1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg3) {
						
						try {	
							check();
						st.executeUpdate("insert into cement values(null,'"+brand+"','"+cost+"','"+quan+"','"+df+"','"	+lot+"','"+weigh+"')");
					}
						catch(Exception ae){
							//System.out.println(ae);
							JOptionPane.showMessageDialog(null,"Enter correct values");
						}
					}
					
				});
				SwingUtilities.updateComponentTreeUI(panel);
			}			
		}
		
	catch(Exception aqs){
		System.out.println(aqs);
	}
			}
		
	}
	);
	
	
	}
public void check() {
			brand = t1.getText();
			color = t7.getText();
			cost = Integer.parseInt(t2.getText());
			quan = Integer.parseInt(t3.getText());
			date = t5.getText()+"-"+b3.getSelectedItem().toString()+"-"+b2.getSelectedItem().toString();
			df = Date.valueOf(date);
			System.out.println(df);
			lot = Integer.parseInt(t4.getText());
			weigh = Double.parseDouble(t6.getText());
	}
public void clear() {
	for(ActionListener a1 :jb1.getActionListeners()) {
		jb1.removeActionListener(a1);	
	}
}
}
