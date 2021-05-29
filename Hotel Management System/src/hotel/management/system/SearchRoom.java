package hotel.management.system;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener{
	JComboBox c1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
	
	SearchRoom(){
		JLabel l1 = new JLabel("Search For Room");
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		l1.setBounds(300,30,200,30);
		add(l1);
		
		JLabel l2 = new JLabel("Room Bed Type");
		l2.setBounds(50,75,100,20);
		add(l2);
		
		c1 = new JComboBox(new String[] {"Single","Double"});
		c1.setBounds(200,75,150,25);
		c1.setBackground(Color.white);
		add(c1);
		
		c2 = new JCheckBox("Only Available");
		c2.setBounds(650,75,150,25);
		add(c2);
		
		
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
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(50,120,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Availability");
		l4.setBounds(250,120,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Status");
		l5.setBounds(450,120,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Price");
		l6.setBounds(650,120,100,20);
		add(l6);
		
		JLabel l7 = new JLabel("Bed Type");
		l7.setBounds(850,120,100,20);
		add(l7);
		
		setLayout(null);
		setBounds(200,150,1000,550);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				Connectiontosql c = new Connectiontosql();
				String s1 = "select * from rooms where type = '"+c1.getSelectedItem()+"'";
				String s2 = "select * from rooms where available = 'Available' and type = '"+c1.getSelectedItem()+"'";
			    
			    
			    if(c2.isSelected()) {
			    	ResultSet rs2 = c.s.executeQuery(s2);
			    	t1.setModel(DbUtils.resultSetToTableModel(rs2));
			    }else {
			    	ResultSet rs = c.s.executeQuery(s1);
				    t1.setModel(DbUtils.resultSetToTableModel(rs));
			    }
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new SearchRoom();

	}

}
