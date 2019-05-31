package colorstop;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class b2 extends JFrame{
	JComboBox<String> b1;
	JLabel l7,l1,label;
	String [] a = {"Paints","Primers","PaintBrush","Cement"};
	JPanel panel = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	Object op[] = {"Delete","Cancel"};
	Object op1[] = {"View","Cancel"};
	JTextField t = new JTextField();
	JTextField t8 = new JTextField();
	JTable jt ;
	JButton back,delete;
	JButton view;
	String query;
	int delete_id,result,edit_id,result1,view_id;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	top ab = new top();
	String user,pass,brand="",cost="",lot="",color="",date="",quantity="",weight="";
	JLabel l2,l3,l4,l5,l6,l9,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JFrame jf= new JFrame();
	
	b2(String user,String pass){
		back = new JButton("Go Back <- ");
		view= new JButton("View by brand ");
		delete = new JButton("Delete by ID ");
		label = new JLabel(new ImageIcon("C:/Users/Mohit Kumar/Desktop/supplies.jpg"));
		label.setBounds(-300,150,1200,800);
		
		jf.setLayout(null);
		jf.setSize(700,450);
		jf.setTitle("Edit");
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		//p2.setBounds(10,10,600,400);
		//p2.setSize(new Dimension(250,300));
		l2= new JLabel("Brand");
		l3= new JLabel("Cost");
		l4= new JLabel("Lot No.");
		l5= new JLabel("Color");
		l6= new JLabel("Exp. Date");
		l8= new JLabel("Quantity");
		l9= new JLabel("Weight");
		t1= new JTextField(brand);
		t2= new JTextField(cost);
		t3= new JTextField(lot);
		t4= new JTextField(color);
		t5= new JTextField(date);
		t6= new JTextField(quantity);
		t7= new JTextField(weight);
		
		l2.setBounds(125,80,100,25);
		l3.setBounds(125,115,100,25);
		l4.setBounds(125,150,100,25);
		l5.setBounds(125,185,100,25);
		l6.setBounds(125,220,100,25);
		l8.setBounds(125,255,100,25);
		l9.setBounds(125,290,100,25);
		t1.setBounds(255,80,100,25);
		t2.setBounds(255,115,100,25);
		t3.setBounds(255,150,100,25);
		t4.setBounds(255,185,100,25);
		t5.setBounds(255,220,100,25);
		t6.setBounds(255,255,100,25);
		t7.setBounds(255,290,100,25);
		/*
		l2.setSize(new Dimension(100,25));
		l3.setSize(new Dimension(100,25));
		l4.setSize(new Dimension(100,25));
		l5.setSize(new Dimension(100,25));
		l6.setSize(new Dimension(100,25));
		l8.setSize(new Dimension(100,25));
		l9.setSize(new Dimension(100,25));
		t1.setSize(new Dimension(100,25));
		t2.setSize(new Dimension(100,25));
		t3.setSize(new Dimension(100,25));
		t4.setSize(new Dimension(100,25));
		t5.setSize(new Dimension(100,25));
		t6.setSize(new Dimension(100,25));
		t7.setSize(new Dimension(100,25));
		*/
		//p2.setLayout(null);
		//jf.add(p2);
		this.user = user;
		t.setPreferredSize(new Dimension(100,25));
		t8.setPreferredSize(new Dimension(100,25));
		this.pass = pass;
		setSize(756,780);
		setLayout(null);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		panel.setBackground(Color.WHITE);
		back.setBounds(50,50,100,50);
		p1.add(new JLabel("Enter the id of the product you want to delete"));
		p1.add(t);
		p2.add(new JLabel("Enter the brand of the product you want to view"));
		p2.add(t8);
		setTitle("ColorStop: One stop destination for managing all your business data");
		l1 = new JLabel("Please select the type of stock you want to view");
		b1 = new JComboBox<String>(a);
		l1.setBounds(150,150,350,25);
		b1.setSelectedItem(null);
		b1.setBounds(445,150,150,25);
	panel.setBounds(100,225,565,400);
	add(panel);
	add(back);
	add(label);
	view.setBounds(125,70,125,25);
	delete.setBounds(325,70,125,25);
	add(b1);
	add(l1);
	back.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			new newstock(user,pass);
			
		}
		
	});
	/*edit.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		
	});*/
	setVisible(true);
	b1.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {
			try {
			st = ab.connect(user,pass).createStatement();
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10,130, 545, 260);
			try {
				st = ab.connect(user,pass).createStatement();
			if(arg0.getItem()=="Paints") {
				l7 = new JLabel("View stock details for "+arg0.getItem());
				l7.setBounds(200,5,200,50);
				panel.removeAll();
				panel.add(l7);
				//panel.add(edit);
				panel.add(delete);
				panel.add(view);
				panel.add(scrollPane);
			
				jt = new JTable() ;
				scrollPane.setViewportView(jt);
				query="select * from paints";
				create();
				delete.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						clear(delete);
						//p1.setPreferredSize(new Dimension(800,400));
						result = JOptionPane.showOptionDialog(null,p1,"Delete by ID",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,op,null);
						addWindowListener(new WindowAdapter()
						{
							public void windowClosing(WindowEvent ae) {
							
								System.exit(0);
							}
							
					});

						if(result==JOptionPane.YES_OPTION) {
							delete_id = Integer.parseInt(t.getText());
							try {	
								st.executeUpdate("delete from paints where id = '"+t.getText()+"'");
								create();
								SwingUtilities.updateComponentTreeUI(panel);
								JOptionPane.showMessageDialog(null,"Value has been deleted");
							}
								catch(Exception ae){
									JOptionPane.showMessageDialog(null,"Some error might have accured");
									//JOptionPane.showMessageDialog(null,"Enter correct ID");
								}
						}
					
						
					}
					
				});
			view.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						clear(view);
						result1 = JOptionPane.showOptionDialog(null,p2,"View by brand",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,op1,null);
						addWindowListener(new WindowAdapter()
						{
							public void windowClosing(WindowEvent ae) {
							
								System.exit(0);
							}
							
					});
						if(result==JOptionPane.YES_OPTION) {
						
							try {	
								query ="select * from paints where brand = '"+t8.getText()+"'";
								//st.executeUpdate("select * from paints where id = '"+t8.getText()+"'");
								create();
								SwingUtilities.updateComponentTreeUI(panel);
								//JOptionPane.showMessageDialog(null,"Value has been deleted");
							}
								catch(Exception ae){
									JOptionPane.showMessageDialog(null,"Some error might have accured");
									//JOptionPane.showMessageDialog(null,"Enter correct ID");
								}
						}
					}
					
				});
				
				
				SwingUtilities.updateComponentTreeUI(panel);
			}
			if(arg0.getItem()=="Primers") {
				l7 = new JLabel("View stock details for "+arg0.getItem());
				l7.setBounds(200,5,200,50);
				panel.removeAll();
				panel.add(l7);
				//panel.add(edit);
				panel.add(delete);
				panel.add(view);
				panel.add(scrollPane);
			
				jt = new JTable() ;
				scrollPane.setViewportView(jt);
				query="select * from primers";
				create();
				delete.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						clear(delete);
						//p1.setPreferredSize(new Dimension(800,400));
						result = JOptionPane.showOptionDialog(null,p1,"Delete by ID",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,op,null);
						addWindowListener(new WindowAdapter()
						{
							public void windowClosing(WindowEvent ae) {
							
								System.exit(0);
							}
							
					});

						if(result==JOptionPane.YES_OPTION) {
							delete_id = Integer.parseInt(t.getText());
							try {	
								st.executeUpdate("delete from primers where id = '"+t.getText()+"'");
								create();
								SwingUtilities.updateComponentTreeUI(panel);
								JOptionPane.showMessageDialog(null,"Value has been deleted");
							}
								catch(Exception ae){
									System.out.println(ae);
									JOptionPane.showMessageDialog(null,"Some error might have accured");
									//JOptionPane.showMessageDialog(null,"Enter correct ID");
								}
						}
					
						
					}
					
				});
				view.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						clear(view);
						result1 = JOptionPane.showOptionDialog(null,p2,"View by ID",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,op1,null);
						addWindowListener(new WindowAdapter()
						{
							public void windowClosing(WindowEvent ae) {
							
								System.exit(0);
							}
							
					});
						if(result==JOptionPane.YES_OPTION) {
							
							try {	
								
								query ="select * from primers where brand = '"+t8.getText()+"'";
								//st.executeUpdate("select * from paints where id = '"+t8.getText()+"'");
								create();
								SwingUtilities.updateComponentTreeUI(panel);
								//JOptionPane.showMessageDialog(null,"Value has been deleted");
							}
								catch(Exception ae){
									JOptionPane.showMessageDialog(null,"Some error might have accured");
									//JOptionPane.showMessageDialog(null,"Enter correct ID");
								}
						}
					}
					
				});
				SwingUtilities.updateComponentTreeUI(panel);
			}
			if(arg0.getItem()=="PaintBrush") {
				l7 = new JLabel("View stock details for "+arg0.getItem());
				l7.setBounds(200,5,200,50);
				panel.removeAll();
				panel.add(l7);
				//panel.add(edit);
				panel.add(delete);
				panel.add(scrollPane);
				panel.add(view);
				jt = new JTable() ;
				scrollPane.setViewportView(jt);
				query="select * from paintbrush";
				create();	
				delete.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						clear(delete);
						
						//p1.setPreferredSize(new Dimension(800,400));
						result = JOptionPane.showOptionDialog(null,p1,"Delete by ID",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,op,null);
						addWindowListener(new WindowAdapter()
						{
							public void windowClosing(WindowEvent ae) {
							
								System.exit(0);
							}
							
					});

						if(result==JOptionPane.YES_OPTION) {
							delete_id = Integer.parseInt(t.getText());
							try {	
								st.executeUpdate("delete from paintbrush where id = '"+t.getText()+"'");
								create();
								SwingUtilities.updateComponentTreeUI(panel);
								JOptionPane.showMessageDialog(null,"Value has been deleted");
							}
								catch(Exception ae){
									System.out.println(ae);
									JOptionPane.showMessageDialog(null,"Some error might have accured");
									//JOptionPane.showMessageDialog(null,"Enter correct ID");
								}
						}
					
						
					}
					
				});
				view.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						clear(view);
						result1 = JOptionPane.showOptionDialog(null,p2,"View by brand",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,op1,null);
						addWindowListener(new WindowAdapter()
						{
							public void windowClosing(WindowEvent ae) {
							
								System.exit(0);
							}
							
					});
						if(result==JOptionPane.YES_OPTION) {
						
							try {	
							
								query ="select * from paintbrush where brand = '"+t8.getText()+"'";
								//st.executeUpdate("select * from paints where id = '"+t8.getText()+"'");
								create();
								SwingUtilities.updateComponentTreeUI(panel);
								//JOptionPane.showMessageDialog(null,"Value has been deleted");
							}
								catch(Exception ae){
									JOptionPane.showMessageDialog(null,"Some error might have accured");
									//JOptionPane.showMessageDialog(null,"Enter correct ID");
								}
						}
					}
					
				});
				SwingUtilities.updateComponentTreeUI(panel);
			}
			if(arg0.getItem()=="Cement") {
				l7 = new JLabel("View stock details for "+arg0.getItem());
				l7.setBounds(200,5,200,50);
				
				panel.removeAll();
				panel.add(l7);
			//	panel.add(edit);
				panel.add(delete);
				panel.add(scrollPane);
				panel.add(view);
				jt = new JTable() ;
				scrollPane.setViewportView(jt);
				query="select * from cement";
				create();
				delete.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						clear(delete);
						//p1.setPreferredSize(new Dimension(800,400));
						result = JOptionPane.showOptionDialog(null,p1,"Delete by ID",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,op,null);
						addWindowListener(new WindowAdapter()
						{
							public void windowClosing(WindowEvent ae) {
							
								System.exit(0);
							}
							
					});

						if(result==JOptionPane.YES_OPTION) {
							delete_id = Integer.parseInt(t.getText());
							try {	
								st.executeUpdate("delete from cement where id = '"+t.getText()+"'");
								create();
								SwingUtilities.updateComponentTreeUI(panel);
								JOptionPane.showMessageDialog(null,"Value has been deleted");
							}
								catch(Exception ae){
									System.out.println(ae);
									JOptionPane.showMessageDialog(null,"Some error might have accured");
									//JOptionPane.showMessageDialog(null,"Enter correct ID");
								}
						}
					
						
					}
					
				});
				view.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						clear(view);
						result1 = JOptionPane.showOptionDialog(null,p2,"View by brand",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,op1,null);
						addWindowListener(new WindowAdapter()
						{
							public void windowClosing(WindowEvent ae) {
							
								System.exit(0);
							}
							
					});
						if(result==JOptionPane.YES_OPTION) {
						
							try {	
							
								query ="select * from cement where brand = '"+t8.getText()+"'";
								//st.executeUpdate("select * from paints where id = '"+t8.getText()+"'");
								create();
								SwingUtilities.updateComponentTreeUI(panel);
								//JOptionPane.showMessageDialog(null,"Value has been deleted");
							}
								catch(Exception ae){
									JOptionPane.showMessageDialog(null,"Some error might have accured");
									//JOptionPane.showMessageDialog(null,"Enter correct ID");
								}
						}
					}
					
				});
				SwingUtilities.updateComponentTreeUI(panel);
				}
		}
			catch(Exception ae) {
				System.out.println(ae);
			}
		}
		
		catch(Exception ae) {
			System.out.println(ae);
		}
		}
	}
	
	);
	
	}
	public void paneladd() {
	
	}
	public void get() {
		
		
	}
	public void create () {
		
		try {
			
			pst = ab.connect(user,pass).prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			jt.setModel(DbUtils.resultSetToTableModel(rs));
			jt.setFillsViewportHeight(true);
			jt.setBackground(Color.WHITE);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public void clear(JButton ae) {
		for(ActionListener a1 :ae.getActionListeners()) {
			ae.removeActionListener(a1);	
		}
	}
}
