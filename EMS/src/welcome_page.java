
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Thread;

class welcome_page implements ActionListener {
	
	JFrame frame;
	JButton b;
	
	
	welcome_page(){
	
		frame = new JFrame("EMS");
		frame.setBackground(Color.red);
		frame.setLayout(null); // absolute layout used
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		JButton b = new JButton("Click Here To Continue");
		b.setBounds(525,400,200,50);
		b.addActionListener(this);
		b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
		
		
		JLabel id = new JLabel();
		id.setBounds(0,0,1165,650);
		id.setLayout(null);
		
		
		JLabel lid = new JLabel("EMPLOYEE MANAGEMENT SYSTEM"); 
		lid.setBounds(80,200,1140,100);
		lid.setFont(new Font("Serif",Font.PLAIN,63));
		id.add(lid);
		
		id.add(b);
		frame.add(id);
		
		frame.getContentPane().setBackground(Color.WHITE);
		
		frame.setVisible(true);
		frame.setSize(1260,650);
		frame.setLocation(50,50);
		
		
		
	}

	public void actionPerformed(ActionEvent ae) {
			frame.setVisible(false);
			 new login_page();  
	}
	
	public static void main(String [] args) {
		welcome_page wel = new welcome_page();
	}
	
}
