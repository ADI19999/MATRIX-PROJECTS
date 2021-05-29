package hotel.management.system;

import java.awt.Font;


import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
	
	Dashboard(){
		mb = new JMenuBar();
		add(mb);
		
		m1 = new JMenu("Hotel Management");
		mb.add(m1);
		
		m2 = new JMenu("Admin");
		mb.add(m2);
		
		i1 = new JMenuItem("RECEPTION");
		i1.addActionListener(this);
		m1.add(i1);
		
		i2 = new JMenuItem("ADD EMPLOYEES");
		i2.addActionListener(this);
		m2.add(i2);
		
		i3 = new JMenuItem("ADD ROOMS");
		i3.addActionListener(this);
		m2.add(i3);
		
		i4 = new JMenuItem("ADD DRIVERS");
		i4.addActionListener(this);
		m2.add(i4);
		
		mb.setBounds(0,0,1368,30);
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
		JLabel l1 = new JLabel(i);
		l1.setBounds(0,0,1368,768);
		add(l1);
		
		String str = "THE OBEROI RAJVILLAS WELCOMES YOU";
		JLabel l2 = new JLabel(str);
		l2.setBounds(230,50,1000,70);
		l2.setFont(new Font("Tahoma",Font.PLAIN,50));
		l1.add(l2);
		
		setLayout(null);
		setBounds(0,0,1368,768);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("RECEPTION")) {
			new Reception().setVisible(true);
		}
		else if(ae.getActionCommand().equals("ADD EMPLOYEES")) {
			new AddEmployee().setVisible(true);
		}
		else if(ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms().setVisible(true);
		}
		else if(ae.getActionCommand().equals("ADD DRIVERS")) {
			new AddDriver().setVisible(true);
		}
	}
	
	public static void main(String args[]) {
		new Dashboard();
	}
}
