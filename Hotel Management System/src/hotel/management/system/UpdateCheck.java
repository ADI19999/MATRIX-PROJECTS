package hotel.management.system;
import java.awt.Font;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class UpdateCheck extends JFrame implements ActionListener{
	JButton b1,b2,b3;
	Choice c1;
	JTextField t1,t2,t3,t4,t5;
	UpdateCheck(){
		JLabel l1 = new JLabel("Check-In Details");
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		l1.setBounds(80,30,200,30);
		add(l1);
		
		JLabel l2 = new JLabel("Name");
		l2.setBounds(30,80,100,20);
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
		c1.setBounds(200,80,150,25);
		add(c1);
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(30,120,100,20);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(200,120,150,25);
		add(t1);
		
		JLabel l4 = new JLabel("Customer ID");
		l4.setBounds(30,160,100,20);
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(200,160,150,25);
		add(t2);
		
		JLabel l5 = new JLabel("Check-IN");
		l5.setBounds(30,200,100,20);
		add(l5);
		
		t3 = new JTextField();
		t3.setBounds(200,200,150,25);
		add(t3);
		
		JLabel l6 = new JLabel("Amount Paid");
		l6.setBounds(30,240,100,20);
		add(l6);
		
		t4 = new JTextField();
		t4.setBounds(200,240,150,25);
		add(t4);
		
		JLabel l7 = new JLabel("Amount Pending");
		l7.setBounds(30,280,100,20);
		add(l7);
		
		t5 = new JTextField();
		t5.setBounds(200,280,150,25);
		add(t5);
		
		b1 = new JButton("Check");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(80,340,100,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(210,340,100,30);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setBounds(150,390,100,30);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
		JLabel l = new JLabel(i1);
		l.setBounds(380,80,400,250);
		add(l);
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setBounds(280,150,800,500);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
				try {
				Connectiontosql c = new Connectiontosql();
				String name = c1.getSelectedItem();
				String str = "select * from customers where name  = '"+name+"'";
				ResultSet rst = c.s.executeQuery(str);
				while(rst.next()) {
					t1.setText(rst.getString("room"));
					t2.setText(rst.getString("idnumber"));
					t3.setText(rst.getString("checkin"));
					t4.setText(rst.getString("deposit"));
				}
				String room = t1.getText();
				String deposit = t4.getText();
				String price = null;
				int amountpending;
				ResultSet rs = c.s.executeQuery("select * from rooms where room = '"+room+"'");
				while(rs.next()) {
					price = rs.getString("price");
					amountpending = Integer.parseInt(price) - Integer.parseInt(deposit);
					t5.setText(Integer.toString(amountpending));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==b2) {
			try {
				Connectiontosql c = new Connectiontosql();
				String name = c1.getSelectedItem();
				String number = t1.getText();
				String id = t2.getText();
				String status = t3.getText();
				String deposit = t4.getText();
				c.s.executeUpdate("update customers set room = '"+number+"', idnumber = '"+id+"', checkin = '"+status+"', deposit = '"+deposit+"' where name = '"+name+"'");
				
				JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                new Reception().setVisible(true);
                setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateCheck();

	}

}
