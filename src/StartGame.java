import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//import javax.swing.SwingUtilities;
import java.awt.*;

public class StartGame {
	
	public static void main(String str[])
	{
	  SwingUtilities.invokeLater(new Runnable() {
		  public void run() {
			  new StartSwing();
		  }
	  });	
		
		
	}
	
}
