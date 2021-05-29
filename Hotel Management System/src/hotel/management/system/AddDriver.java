package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Color.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
	
	JTextField t1,t2,t3,t4,t5;
	JComboBox c1,c2;
	JButton b1,b2;
	AddDriver(){
		JLabel title = new JLabel("Add Driver");
		title.setFont(new Font("Tahoma",Font.BOLD,18));
		title.setBounds(120,20,100,20);
		add(title);
		
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahome",Font.PLAIN,15));
		name.setBounds(50,60,100,30);
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(200,60,100,30);
		add(t1);
		
		JLabel age = new JLabel("Age");
		age.setFont(new Font("Tahome",Font.PLAIN,15));
		age.setBounds(50,100,100,30);
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(200,100,100,30);
		add(t2);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Tahome",Font.PLAIN,15));
		gender.setBounds(50,140,100,30);
		add(gender);
		
		c1 = new JComboBox(new String[] {"Male" , "Female"});
		c1.setBounds(200,140,100,30);
		c1.setBackground(Color.white);
		add(c1);
		
		JLabel company = new JLabel("Car Company");
		company.setFont(new Font("Tahome",Font.PLAIN,15));
		company.setBounds(50,180,100,30);
		add(company);
		
		t3 = new JTextField();
		t3.setBounds(200,180,100,30);
		add(t3);
		
		JLabel model = new JLabel("Car Model");
		model.setFont(new Font("Tahome",Font.PLAIN,15));
		model.setBounds(50,220,100,30);
		add(model);
		
		t4 = new JTextField();
		t4.setBounds(200,220,100,30);
		add(t4);
		
		JLabel available = new JLabel("Available");
		available.setFont(new Font("Tahome",Font.PLAIN,15));
		available.setBounds(50,260,100,30);
		add(available);
		
		c2 = new JComboBox(new String[] {"Available" , "Busy"});
		c2.setBounds(200,260,100,30);
		c2.setBackground(Color.white);
		add(c2);
		
		JLabel location = new JLabel("Location");
		location.setFont(new Font("Tahome",Font.PLAIN,15));
		location.setBounds(50,300,100,30);
		add(location);
		
		t5 = new JTextField();
		t5.setBounds(200,300,100,30);
		add(t5);
		
		b1 = new JButton("Add Driver");
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.setBounds(50,360,110,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.setBounds(200,360,110,30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
		JLabel l = new JLabel(i1);
		l.setBounds(350,30,500,350);
		add(l);
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setBounds(250,180,880,450);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == b1) {
			String name = t1.getText();
			String age = t2.getText();
			String gender = (String)c1.getSelectedItem();
			String company = t3.getText();
			String model = t4.getText();
			String available = (String)c2.getSelectedItem();
			String location = t5.getText();
			
			Connectiontosql c = new Connectiontosql();
			
			try {
				String str = "insert into drivers values ('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"') ";
				c.s.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null,"New Driver Added");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == b2) {
			setVisible(false);
		}
		
	}
	public static void main(String args[]) {
		new AddDriver();
	}
}
