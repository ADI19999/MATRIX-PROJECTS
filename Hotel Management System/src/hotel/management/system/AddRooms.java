package hotel.management.system;

import java.awt.Color;


import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{
	
	JTextField t1,t2;
	JComboBox c1,c2,c3;
	JButton b1,b2;
	AddRooms(){
		JLabel l1 = new JLabel("Add Rooms");
		l1.setFont(new Font("Tahoma",Font.BOLD,18));
		l1.setBounds(120,20,100,20);
		add(l1);
		
		JLabel room = new JLabel("Room Number");
		room.setFont(new Font("Tahome",Font.PLAIN,15));
		room.setBounds(50,60,100,30);
		add(room);
		
		t1 = new JTextField();
		t1.setBounds(175,65,100,25);
		add(t1);
		
		JLabel available = new JLabel("Available");
		available.setFont(new Font("Tahome",Font.PLAIN,15));
		available.setBounds(50,110,100,30);
		add(available);
		
		c1 = new JComboBox(new String[] {"Available" , "Occupied"});
		c1.setBounds(175,110,100,25);
		add(c1);
		
		JLabel status = new JLabel("Status");
		status.setFont(new Font("Tahome",Font.PLAIN,15));
		status.setBounds(50,160,100,30);
		add(status);
		
		c2 = new JComboBox(new String[] {"Clean" , "Dirty"});
		c2.setBounds(175,160,100,25);
		add(c2);
		
		JLabel price = new JLabel("Price");
		price.setFont(new Font("Tahome",Font.PLAIN,15));
		price.setBounds(50,210,100,30);
		add(price);
		
		t2 = new JTextField();
		t2.setBounds(175,210,100,25);
		add(t2);
		
		JLabel type = new JLabel("Bed Type");
		type.setFont(new Font("Tahome",Font.PLAIN,15));
		type.setBounds(50,260,100,30);
		add(type);
		
		c3 = new JComboBox(new String[] {"Single" , "Double"});
		c3.setBounds(175,260,100,25);
		add(c3);
		
		b1 = new JButton("Add Room");
		b1.setBounds(50,330,100,30);
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(175,330,100,30);
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.jpg"));
		JLabel l = new JLabel(i1);
		l.setBounds(315,50,400,300);
		add(l);
		
		setBounds(280,180,750,450);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			String room = t1.getText();
			String available = (String)c1.getSelectedItem();
			String status = (String)c2.getSelectedItem();
			String price = t2.getText();
			String type = (String)c3.getSelectedItem();
			
			Connectiontosql c = new Connectiontosql();
			
			try{
				String rst = "insert into rooms values ('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
				c.s.executeUpdate(rst);
				
				JOptionPane.showMessageDialog(null, "New Room Added");
				this.setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==b2) {
			this.setVisible(false);
		}
	}
	
	public static void main(String args[]) {
		new AddRooms();
	}
}
