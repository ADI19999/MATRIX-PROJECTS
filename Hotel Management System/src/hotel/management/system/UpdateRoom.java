package hotel.management.system;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateRoom extends JFrame implements ActionListener{
	Choice c1;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	UpdateRoom(){
		JLabel l1 = new JLabel("Update Room Status");
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		l1.setBounds(30,20,250,30);
		add(l1);
		
		JLabel l2 = new JLabel("Guest ID");
		l2.setBounds(30,80,120,20);
		add(l2);
		
		c1 = new Choice();
		try {
			Connectiontosql c = new Connectiontosql();
			String str = "select * from customers";
			ResultSet rst = c.s.executeQuery(str);
			while(rst.next()) {
				c1.add(rst.getString("name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		c1.setBounds(200,80,120,25);
		add(c1);
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(30,130,120,20);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(200,130,120,25);
		add(t1);
		
		JLabel l4 = new JLabel("Availability");
		l4.setBounds(30,180,120,20);
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(200,180,120,25);
		add(t2);
		
		JLabel l5 = new JLabel("Clean Status");
		l5.setBounds(30,230,120,20);
		add(l5);
		
		t3 = new JTextField();
		t3.setBounds(200,230,120,25);
		add(t3);
		
		b1 = new JButton("Check");
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.setBounds(50,300,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.setBounds(190,300,120,30);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setForeground(Color.white);
		b3.setBackground(Color.black);
		b3.setBounds(110,355,120,30);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nineth.jpg"));
		JLabel l = new JLabel(i1);
		l.setBounds(360,15,600,395);
		add(l);
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setBounds(250,150,1000,470);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			String s1 = c1.getSelectedItem();
			String room = null;
			Connectiontosql c = new Connectiontosql();
			try {
				ResultSet rst = c.s.executeQuery("select * from customers where name = '"+s1+"'");
				while(rst.next()) {
					t1.setText(rst.getString("room"));
					room = rst.getString("room");
				}
				ResultSet rst1  = c.s.executeQuery("select * from rooms where room = '"+room+"'");
				while(rst1.next()) {
					t2.setText(rst1.getString("available"));
					t3.setText(rst1.getString("status"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==b2) {
			try {
				Connectiontosql c= new Connectiontosql();
				String room = t1.getText();
				String available = t2.getText();
				String status = t3.getText();
				
				String str = "update rooms set available = '"+available+"', status = '"+status+"' where room = '"+room+"'";
				c.s.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null,"Room Updated Successfully");
				new Reception().setVisible(true);
				this.setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateRoom();

	}

}
