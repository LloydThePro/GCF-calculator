/*[READ_ME]
 * When creating the project you must also create a package inside the project
 * please name the package "euclid" to avoid import errors!
 * 
 * You also need to create your main class and add this file to your project directory where your main file is located
 * 	
 * 
 * 
 * in your main class/main method do this
 *
 * EX:
 *
 *package euclid;
 *import euclid.Gui;
 *
 *	
 *public class YourFileName {
 *
 *	public static void main(String[] args) {
 *		
 *		Gui window = new Gui();
 *	}
 *
 *}
 * 
 */


package euclid;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui implements ActionListener {
	
	private JFrame MyWindow;
	private JPanel MyPanel;
	private JTextField text1;
	private JTextField text2;
	private JButton button;
	
	public Gui()  {
		
		text1 = new JTextField("",14);
		text2 = new JTextField("",14);
		
		/*
		 * This is the text label
		 * You can change this to your whatever you want to put
		 * EX:
		 * 	JLabel label2 = new JLabel("number1: ");
		 *	JLabel label = new JLabel("number2: " );
		 */
		JLabel label2 = new JLabel("2nd number: ");
		JLabel label = new JLabel("1st number: " );
		
		/*
		 * This is the button your can also change its string to your liking
		 * EX:
		 * 	button = new JButton("Fuck GCF");
		 */
		button = new JButton("Get GCF");
		
		
		MyWindow = new JFrame();
		MyWindow.setResizable(false);
		MyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * You can change the window size by changing this values below
		 * EX:
		 * 		MyWindow.setSize(190, 240);
		 */
		MyWindow.setSize(320, 260);
		/*
		 * You can change the title of the window by changing the string below
		 * 
		 * EX:
		 * 		MyWindow.setTitle("Fuck");
		 */
		MyWindow.setTitle("EuclidsAlgorithm");
		
		MyWindow.setVisible(true);
		MyPanel = new JPanel();
		MyPanel.setLayout(null);
		
		
		
		
		
		
		//Set the position of the components
		//x, y, width, height
		label.setBounds(10, 20, 120, 25);
		text1.setBounds(100 , 20, 50, 25);
		label2.setBounds(10, 65, 120, 25);
		text2.setBounds(100 , 65, 50, 25);
		
		button.addActionListener(this);
		button.setBounds(75, 140, 120,40);
		
		MyPanel.add(label);
		MyPanel.add(text1);
		MyPanel.add(label2);
		MyPanel.add(text2);
		MyPanel.add(button);
		
		/*Sets the background color
		 *(To change the background color you can do this
		 * EX:
		 *
		 * MyPanel.setBackground(color.RED);
		 * 
		 * Or you want to get a specific color
		 * 
		 * The format is RGB (Red,Green,blue);
		 * The values if from 0 - 1;
		 * don't forget to put 'f' after the number to indicate that it is a float
		 *  
		 * EX:
		 * MyPanel.setBackground(new Color(0.6f,0.59f,0.61f));
		 * 
		 * (This produces grey background color)
		 * 
		 */
		MyPanel.setBackground(new Color(0.6f,0.59f,0.61f));
		
		MyWindow.add(MyPanel);
		
		
		
		
		
	}

	//Button receiver
	@Override
	public void actionPerformed(ActionEvent arg) {
		
		try {
			int a = Integer.parseInt(text1.getText());
			int b = Integer.parseInt(text2.getText());
			
			
			//we throw error when values is less than 1
			//You can change the error message
			if(a <= 0 || b <= 0)throw new ArithmeticException("ERROR! Values must be greater than zero");
			
			//calculate gcf
			int gcf = euclidr(a,b);
			//shows the gcf after calculation
			JOptionPane.showMessageDialog(null, "GCF: " + String.valueOf(gcf));
			
		}
		catch(NumberFormatException n){
			//throws an exception when a non-numerical values is detected
			//shows this error when the inputs are not numbers
			//You can change the message
			JOptionPane.showMessageDialog(null, "ERROR! Non numerical values!");
		}
		catch(ArithmeticException a) {
			//shows this error when the input is less than zero
			JOptionPane.showMessageDialog(null, a.getMessage());
		}
		
		
		
		
	}
	
	private static int euclidr(int a, int b)
	{
		//returns 0 if a is 0
		if(a == 0)return 0;
		// returns a if b is zero
		if(b == 0)return a;
		//else it recursively perform another operation by calling this method again and returns a value
		else return euclidr(b, a % b);
	}
	
	
}
