package hotel.management.system;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.awt.Color;
import java.sql.*;
import net.proteanit.sql.*;
public class Room extends JFrame implements ActionListener{
	JTable t1;
	JButton b1,b2;
	Room(){
		
		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(10,10,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Availability");
		l2.setBounds(150,10,100,20);
		add(l2);
		
		JLabel l3 = new JLabel("Status");
		l3.setBounds(280,10,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(400,10,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(510,10,100,20);
		add(l5);
		
		t1 = new JTable();
		t1.setBounds(0,40,600,400);
		add(t1);
		
		b1 = new JButton("Load Data");
		b1.setBounds(150,460,120,30);
		b1.addActionListener(this);
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(325,460,120,30);
		b2.addActionListener(this);
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		add(b2);
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setBounds(350,130,600,550);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				Connectiontosql c = new Connectiontosql();
				String str = "select * from rooms";
				ResultSet rst = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rst));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	public static void main(String args[]) {
		new Room();
	}
}
