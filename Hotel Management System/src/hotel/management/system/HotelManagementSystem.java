
package hotel.management.system;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;

import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
	
	HotelManagementSystem()
	{
		setBounds(50,50,1280,600);
//		setSize(400,400);
//		setLocation(300,300);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpeg"));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(0,0,1280,600);
		add(l1);
		
		JLabel l2 = new JLabel("Hotel Management System");
		l2.setBounds(275,20,1000,90);
		l2.setForeground(Color.white);
		l2.setFont(new Font("serif",Font.PLAIN,70));
		l1.add(l2);
		
		JButton b1 = new JButton("NEXT");
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.setBounds(1150,450,100,100);
		b1.setFont(new Font("serif",Font.PLAIN,20));
		b1.addActionListener(this);
		l1.add(b1);
		
		setLayout(null);
		setVisible(true);
		/*while(true)
		{
			l2.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
		
			}
			l2.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
		
			}
		}*/
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		new Login().setVisible(true);
		this.setVisible(false);
	}
	
	public static void main(String[] args) {
		new HotelManagementSystem();

	}

}
