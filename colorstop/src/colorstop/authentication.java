package colorstop;
import java.util.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


public class authentication extends JFrame{
	JLabel l1,l2,l3,l4;
	JTextField t1;
	Date date = new Date();
	JPasswordField t2;
	JButton b1;
	String u,p;
	authentication(){
		setSize(756,780);
		setLayout(null);
		setTitle("ColorStop: One stop destination for managing all your business data");
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		l1 = new JLabel("username:");
		l2 = new JLabel("password");
		t1=new JTextField("");
		t2= new JPasswordField("");
        l3 = new JLabel(new ImageIcon("C:/Users/Mohit Kumar/Desktop/supplies.jpg"));
		l4= new JLabel(date.toString());
		b1 = new JButton("Sign in");
		l1.setBounds(200,250,100,25);
		l2.setBounds(200,300,100,25);
		//l4.setBounds(550,10,200,25);
		l3.setBounds(-300,150,1200,800);
		t1.setBounds(400,250,100,25);
		t2.setBounds(400,300,100,25);
		b1.setBounds(300,350,100,25);
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(l3);
		//add(l4);
		
		setVisible(true);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			setVisible(false);
			new connection(t1.getText(),t2.getText());
			
			}
			
		});
	
		t2.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==10) {
					setVisible(false);
					new connection(t1.getText(),t2.getText());	
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowListener ae) {
				System.exit(0);
				
			}
		});
		u = t1.getText();
		p = t2.getText();
		
		
	}
	
}
