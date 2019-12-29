import  javax.swing.*;


public class StartSwing {
	JFrame frame;
	StartSwing()
	{
	 frame= new JFrame("this ");
	frame.setSize(800,800);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//frame.setLayout(new GridLayout(4,4));
	frame.setLayout(null);
	RandomPhoto r=new RandomPhoto(frame);
	
	frame.setVisible(true);
	}
	
	
}
