import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonAdapter implements ActionListener {
  
   int lastButtonRandomNumber=0;
   int buttonPressed=0;
   JButton lastButtonRef;
   boolean cards[];
   int remainingCards=16;
   ButtonAdapter(){
	   cards=new boolean[16];
	   for(int i=0;i<16;i++)
		   cards[i]=false;
   }

   
   
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		  JButton b=(JButton) e.getSource();
		 // System.out.println("get out");
		  if(buttonPressed==0)
			  {buttonPressed++;
			     b.setBackground(Color.RED);
		         lastButtonRandomNumber=RandomPhoto.map.get(b);
		         lastButtonRef=b;}         
		  else { 
			  int min=Math.min(lastButtonRandomNumber,RandomPhoto.map.get(b));
			  
			  if((Math.abs(lastButtonRandomNumber-RandomPhoto.map.get(b)))==1 && min%2==1 )
			  {   b.setText("");
		          b.setBackground(Color.white);
			      b.setIcon(new ImageIcon("image/"+Integer.toString(RandomPhoto.map.get(b))+".png"));
				  ActionListener[] adapter= b.getActionListeners();
			      b.removeActionListener(adapter[0]);
				  lastButtonRef.setText("");
			      lastButtonRef.setBackground(Color.white);
				  lastButtonRef.setIcon(new ImageIcon("image/"+Integer.toString(RandomPhoto.map.get(b))+".png"));
				  //lastButtonRef.setEnabled(false);
				  ActionListener[] a= lastButtonRef.getActionListeners();
			      lastButtonRef.removeActionListener(a[0]);
			  }
			  
			  else {
				  b.setIcon(null);
				  lastButtonRef.setIcon(null);
				  b.setBackground(Color.BLACK);
				  b.setText("card");
				  lastButtonRef.setText("card");
				  lastButtonRef.setBackground(Color.BLACK);
				  remainingCards-=2;
				  //if(remainingCards==0) {}
					  
			  }
			  buttonPressed=0;
			  
		  }
	}
}
