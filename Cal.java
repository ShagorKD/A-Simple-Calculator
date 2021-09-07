package Calculator_java_swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cal implements ActionListener {
	
	
	// variables and as well as objects
	JFrame frm;//fram
	JTextField txf;//text field or screen;
	JButton[] numbtn = new JButton[10];//for 0 to 10 numbers array type object 
	JButton[] funbtn = new JButton[9];// for 9 function in calcultor.
	JButton ad_btn,sub_btn,m_btn,div_btn,dmal_btn,eql_btn,neg_btn,del_btn,clr_btn;// here is the 9 function 
	
	JPanel pnl;
	
	// customfont
	Font cstm = new Font("",Font.BOLD,30);// " " defult arial font;
	
	
	//instance variable;
	
	double num1=0,num2=0,res=0; // as our calculator can only deals two value. 
	char op;// for + , - , / , *
	
	/*Shagor Kumar Das
	 * 201002403
	 * 01772621944
	 * shagorkumardas@gmail.com
	 * Green University of Bangladesh*/
	
	
	
	
	
	
	
	Cal(){
		
		// just setting the fram or Jframe. 
		frm = new JFrame(" Priculator");// set the title;
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(550,550);
		
		frm.setLayout(null);
		
		// setting the screen and its properties
		txf = new JTextField();
		txf.setBounds(50,25,300,50);
		txf.setFont(cstm);
		txf.setBackground(Color.green);
		txf.setEditable(false);// for this we can not write on the screen;
		
		// operatinons buttons
		ad_btn =  new JButton("+");
		sub_btn =  new JButton("-");
		m_btn =  new JButton("*");
		div_btn =  new JButton("/");
		dmal_btn =  new JButton(".");
		eql_btn =  new JButton("=");
		del_btn =  new JButton("DEL");
		clr_btn =  new JButton("CLR");
		neg_btn = new JButton("(-)");
		
		// adding buttons to the object type Jbutton array 
		funbtn[0]= ad_btn;
		funbtn[1]= sub_btn;
		funbtn[2]= m_btn;
		funbtn[3]= div_btn;
		funbtn[4]= dmal_btn;
		funbtn[5]= eql_btn;
		funbtn[6]= del_btn;
		funbtn[7]= clr_btn;
		funbtn[8]= neg_btn;
		
		//to perform the actoins we need action listener; we use a for loop to do it faster.
		for(int i =0;i<9;i++) {
			funbtn[i].addActionListener(this);// adding action listener for each function buttons.
			funbtn[i].setFont(cstm);
			funbtn[i].setFocusable(false);// for no odd out line on the btn
		}
		
		// now adding action for 0 to 10 btn numbers . 
		for(int i =0;i<10;i++) {
			numbtn[i] = new JButton(String.valueOf(i));
			numbtn[i].addActionListener(this);// adding action listener for each function buttons.
			numbtn[i].setFont(cstm);
			numbtn[i].setFocusable(false);// for no odd out line on the btn
		}
		
		//delet and cler buttons
		neg_btn.setBounds(50,430,100,50);
		del_btn.setBounds(150,430,100,50);
		clr_btn.setBounds(250,430,100,50);
		
		
		// Jpanel attributes
		pnl = new JPanel();
		pnl.setBounds(50,100,300,300);
		pnl.setLayout(new GridLayout(4,4,10,10));
		pnl.setBackground(Color.DARK_GRAY);
		
		// adding the function and number btn to the panel;
		pnl.add(numbtn[1]);
		pnl.add(numbtn[2]);
		pnl.add(numbtn[3]);
		pnl.add(ad_btn);
		
		pnl.add(numbtn[4]);
		pnl.add(numbtn[5]);
		pnl.add(numbtn[6]);
		pnl.add(sub_btn);
		
		pnl.add(numbtn[7]);
		pnl.add(numbtn[8]);
		pnl.add(numbtn[9]);
		pnl.add(m_btn);
		pnl.add(dmal_btn);
		pnl.add(numbtn[0]);
		
		pnl.add(eql_btn);
		pnl.add(div_btn);
		
		
		frm.add(txf);// adding txt field to the frame. 
		frm.add(del_btn);// adding delet to fram
		frm.add(clr_btn);// clr to fram
		frm.add(pnl);
		frm.add(neg_btn);
		
		frm.setVisible(true);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource()==numbtn[i]) {
				txf.setText(txf.getText().concat(String.valueOf(i)));
			}// get number 1,2,3 and visible them to screen
		}
		if(e.getSource()==dmal_btn) {
			txf.setText(txf.getText().concat("."));
		}// to write 5.87 or 6.66 etc
		
		if(e.getSource()==ad_btn) {
			num1 = Double.parseDouble(txf.getText());
			op='+';
			txf.setText(" ");
			
		}
		if(e.getSource()==sub_btn) {
			num1 = Double.parseDouble(txf.getText());
			op='-';
			txf.setText(" ");
			
		}
		if(e.getSource()==m_btn) {
			num1 = Double.parseDouble(txf.getText());
			op='*';
			txf.setText(" ");
			
		}
		if(e.getSource()==div_btn) {
			num1 = Double.parseDouble(txf.getText());
			op='/';
			txf.setText(" ");
			
		}
		if(e.getSource()==eql_btn) {
			num2 = Double.parseDouble(txf.getText());
			switch(op) {
			case'+':
				res=num1+num2;
				break;
			case'-':
				res=num1-num2;
				break;
			case'*':
				res=num1*num2;
				break;
			case'/':
				res=num1/num2;
				break;
			}
			txf.setText(String.valueOf(res));
			num1=res;
		}
		if(e.getSource()==clr_btn) {
			txf.setText("");
		}
		if(e.getSource()==del_btn) {
			String str = txf.getText();
			txf.setText("");
			for(int i =0;i<str.length()-1;i++) {
				txf.setText(txf.getText()+str.charAt(i));
			}
		}
		if(e.getSource()==neg_btn) {
			double temp = Double.parseDouble(txf.getText());
			temp *= -1;
			txf.setText(String.valueOf(temp));
		}
	}
	
	
	

	public static void main(String[] args) {
		
		
		Cal  c = new Cal();
		

	}

	

}
