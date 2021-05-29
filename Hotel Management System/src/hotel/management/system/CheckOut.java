package hotel.management.system;
import java.awt.Font;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CheckOut extends JFrame implements ActionListener{
	Choice c1;
	JTextField t1;
	JButton b1,b2,b3;
	
	CheckOut(){
		JLabel l1 = new JLabel("Check Out");
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		l1.setBounds(120,20,100,30);
		add(l1);
		
		JLabel l2 = new JLabel("Name");
		l2.setBounds(30,80,100,30);
		add(l2);
		
		c1 = new Choice();
		try {
			Connectiontosql c = new Connectiontosql();
			ResultSet rs = c.s.executeQuery("select * from customers");
			while(rs.next()) {
				c1.add(rs.getString("name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		c1.setBounds(180,80,150,25);
		add(c1);
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(30,130,100,30);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(180,130,150,25);
		add(t1);
		
		b1 = new JButton("Check-Out");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(80,180,100,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(200,180,100,30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleventh.jpg"));
		b3 = new JButton(i1);
		b3.setBounds(370,70,100,100);
		b3.addActionListener(this);
		add(b3);
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setBounds(400,250,500,260);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				Connectiontosql c = new Connectiontosql();
				String name = c1.getSelectedItem();
				String room = t1.getText();
				String s1 = "delete from customers where name = '"+name+"'";
				String s2 = "update rooms set available = 'Available' where room = '"+room+"'";
				c.s.executeUpdate(s1);
				c.s.executeUpdate(s2);
				
				JOptionPane.showMessageDialog(null,"Check Out Done");
				new Reception().setVisible(true);
				this.setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource()==b3) {
			try {
				String name = c1.getSelectedItem();
				Connectiontosql c = new Connectiontosql();
				ResultSet rs = c.s.executeQuery("select * from customers where name = '"+name+"'");
				while(rs.next()) {
					t1.setText(rs.getString("room"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new CheckOut();
	}

}
