import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Calculator extends JFrame implements ActionListener, MouseListener {
        JPanel p1,p2;
        JTextField textField;
        JButton button[]=new JButton[24];
        String buttonStr[]={"%","CE","C","\u232B","\u00B9/"+"\u2093","x\u00B2","\u00B2"+"\u221A"+"x","/","7","8","9","*","4","5","6","-","1","2","3","+","+/-","0",".","="};
        boolean flag=false;
        double result,oldValue,currValue;
        char operator;
        Color oldColor;
        public Calculator() 
        {
        	setTitle("Calculator");
        	p1=new JPanel(new GridLayout(6,4));
        	for(int i=0;i<24;i++) {
        		button[i] = new JButton(buttonStr[i]);
        		button[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        		p1.add(button[i]);
        		button[i].addActionListener(this);
        		button[i].addMouseListener(this);
        		if (i >= 8 && i <= 10 || i >= 12 && i <= 14 || i >= 16 && i <= 18 || i >= 20 && i <= 22)
        			button[i].setBackground(Color.WHITE);
        		else if (i == 23){
        			Color color = new Color(78, 173, 255);
        			button[i].setBackground(color);
        		}
        		else{
        			button[i].setBackground(Color.lightGray);
        		}

        }


        p1.setPreferredSize(new Dimension(350,350));
        add(p1,BorderLayout.SOUTH);
        p2=new JPanel(new BorderLayout());
        textField=new JTextField();
        textField.setText("0");
        textField.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        p2.add(textField);
        p2.setPreferredSize(new Dimension(350,65));
        add(p2,BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350,450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    JButton b=(JButton)e.getSource();
    String s=b.getText();

    if(Character.isDigit(s.charAt(0))){
        if(flag==false) {
        textField.setText(filter(textField.getText()+s));
        result=currValue=Double.parseDouble(textField.getText());
        }
        else{
            oldValue=result;
            textField.setText(filter(s));
            currValue=Double.parseDouble(textField.getText());
            flag=false;
        }
    }
    else if(isOperator(s.charAt(0))){
        operator=s.charAt(0);
        flag=true;
    }
    else if(s.equals("C")){
        textField.setText("0");
    }
    else if(s.equals("=")){
        if(operator=='+')
            result=oldValue+currValue;
        else if (operator=='-')
            result=oldValue-currValue;
        else if (operator=='*')
            result=oldValue*currValue;
        else if(operator=='/')
            result=oldValue/currValue;
        oldValue=result;
        textField.setText(filter(result+""));

    }
    else if(s.equals("CE")){

    }


    }

    public boolean isOperator(char ch){
        return (ch=='+'|| ch=='-' || ch=='*' || ch=='/');
    }

    public String filter(String s){
        if(s.isEmpty())
            return "0";
        else{
            double n=Double.parseDouble(s);
            if(n==(int)n)
                return (int)n+"";
            else
                return n+"";
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton b=(JButton)e.getSource();
        oldColor=b.getBackground();
        for(int i=0;i<24;i++)
        	if(b==button[i])
        		button[i].setBackground(Color.GRAY);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton b=(JButton)e.getSource();
        for(int i=0;i<24;i++)
            if(b==button[i])
                button[i].setBackground(oldColor);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
