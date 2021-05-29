package hotel.management.system;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class PickupService extends JFrame implements ActionListener{
	Choice c1;
	JButton b1,b2;
	JTable t1;
	
	PickupService(){
		JLabel l1 = new JLabel("Pickup Service");
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		l1.setBounds(300,30,200,30);
		add(l1);
		
		JLabel l2 = new JLabel("Type Of Car");
		l2.setBounds(50,75,100,20);
		add(l2);
		
		c1 = new Choice();
		try {
			Connectiontosql c = new Connectiontosql();
			String str = "select * from drivers";
			ResultSet rs = c.s.executeQuery(str);
			while(rs.next()) {
				c1.add(rs.getString("company"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		c1.setBounds(150,75,200,25);
		add(c1);
		
		t1 = new JTable();
		t1.setBounds(0,150,1000,300);
		add(t1);
		
		b1 = new JButton("Submit");
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.setBounds(350,470,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.setBounds(500,470,120,30);
		b2.addActionListener(this);
		add(b2);
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(50,120,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Age");
		l4.setBounds(200,120,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Gender");
		l5.setBounds(330,120,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Company");
		l6.setBounds(470,120,100,20);
		add(l6);
		
		JLabel l7 = new JLabel("Model");
		l7.setBounds(620,120,100,20);
		add(l7);
		
		JLabel l8 = new JLabel("Availability");
		l8.setBounds(750,120,100,20);
		add(l8);
		
		JLabel l9 = new JLabel("Location");
		l9.setBounds(900,120,100,20);
		add(l9);
		
		setLayout(null);
		setBounds(200,150,1000,550);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				Connectiontosql c = new Connectiontosql();
				String s1 = "select * from drivers where company = '"+c1.getSelectedItem()+"'";
                ResultSet rs = c.s.executeQuery(s1);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			    
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new PickupService();

	}

}
