package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener{
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2;
	JComboBox c1;
	Choice c2;
	JRadioButton r1,r2;
	AddCustomer(){
		
		JLabel l1 = new JLabel("New Customer Form");
		l1.setForeground(Color.black);
		l1.setBounds(120,30,300,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(l1);
		
		JLabel l2 = new JLabel("Name");
		l2.setBounds(75,90,100,30);
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(200,90,150,25);
		add(t1);
		
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(75,140,100,30);
		add(l3);
		
		r1 = new JRadioButton("Male");
		r1.setBackground(Color.white);
		r1.setBounds(200,140,60,25);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBackground(Color.white);
		r2.setBounds(280,140,70,25);
		add(r2);
		
		ButtonGroup g = new ButtonGroup();
		g.add(r1);
		g.add(r2);
		
		JLabel l4 = new JLabel("ID");
		l4.setBounds(75,190,100,30);
		add(l4);
		
		c1 = new JComboBox(new String[] {"Passport","Aadhar","Voter-ID","Driveing License"});
		c1.setBackground(Color.white);
		c1.setBounds(200,190,150,25);
		add(c1);
		
		JLabel l5 = new JLabel("ID Number");
		l5.setBounds(75,240,100,30);
		add(l5);
		
		t2 = new JTextField();
		t2.setBounds(200,240,150,25);
		add(t2);
		
		JLabel l6 = new JLabel("Country");
		l6.setBounds(75,290,100,30);
		add(l6);
		
		t3 = new JTextField();
		t3.setBounds(200,290,150,25);
		add(t3);
		
		JLabel l7 = new JLabel("Room Number");
		l7.setBounds(75,340,100,30);
		add(l7);
		
		c2 = new Choice();
		try {
			Connectiontosql c = new Connectiontosql();
			String str = "select * from rooms";
			ResultSet rst = c.s.executeQuery(str);
			while(rst.next()) {
				c2.add(rst.getString("room"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		c2.setBounds(200,340,150,25);
		add(c2);
		
		JLabel l8 = new JLabel("Check IN");
		l8.setBounds(75,390,100,30);
		add(l8);
		
		t4 = new JTextField();
		t4.setBounds(200,390,150,25);
		add(t4);
				
		JLabel l9 = new JLabel("Deposit");
		l9.setBounds(75,440,100,30);
		add(l9);
		
		t5 = new JTextField();
		t5.setBounds(200,440,150,25);
		add(t5);
		
		b1 = new JButton("Add Customer");
		b1.setBounds(80,510,120,30);
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(240,510,120,30);
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eigth.jpg"));
		JLabel l = new JLabel(i1);
		l.setBounds(370,0,530,600);
		add(l);
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(250,120,915,600);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			String name = t1.getText();
			String gender = null;
			if(r1.isSelected())
				gender = "Male";
			else if(r2.isSelected())
				gender = "Female";
			String id = (String)c1.getSelectedItem();
			String idnumber = t2.getText();
			String country = t3.getText();
			String room = c2.getSelectedItem();
			String checkin = t4.getText();
			String deposit = t5.getText();
			
			
		    try {
		    	Connectiontosql c = new Connectiontosql();
		    	String s = "insert into customers values('"+name+"','"+gender+"','"+id+"','"+idnumber+"','"+country+"','"+room+"','"+checkin+"','"+deposit+"')";
		    	String s1 = "update rooms set available = 'Occupied' where room = '"+room+"'";
		    	c.s.executeUpdate(s);
		    	c.s.executeUpdate(s1);
		    	
		    	JOptionPane.showMessageDialog(null,"New Customer Added");
		    	new Reception().setVisible(true);
		    	this.setVisible(false);
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
	    	this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new AddCustomer();

	}

}
