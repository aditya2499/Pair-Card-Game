import java.awt.Color;
import java.awt.event.*;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.*;
//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class RandomPhoto  {
    JFrame frame;
    static int noOfCards=16;
    //public static int s=0;
    int arr[]; 
    JButton button[];
    static int lastPosition=noOfCards-1;
    public static HashMap<JButton, Integer> map;
   
    public ButtonAdapter adapter;
	RandomPhoto(JFrame frame)
	{  
		 map = new HashMap<>(); 
		this.frame=frame;
		arr= new int[noOfCards];
		for(int i=0;i<noOfCards;i++)
			arr[i]=i+1;
		 adapter= new ButtonAdapter();
		createButton();
	}
	
	void createButton() {
		try {
			button = new JButton[noOfCards];
	Rectangle r=frame.getBounds();
	int width=r.width;
	int height= r.height;
	for(int i=0;i<noOfCards;i++)
	{   int buttonnumber=getRandomNumber();
	     
		//button[i]= new JButton(new ImageIcon("image/"+Integer.toString(buttonnumber)+".png"));
	      button[i]= new JButton("card");
	      map.put(button[i],buttonnumber);
	      button[i].setBackground(Color.BLACK);
	      int w=(width-72*(noOfCards/2)-3*(noOfCards/2-1))/2; 
		   int h= (height-193)/2;
	 if(i<noOfCards/2)
	 { 
	button[i].setBounds(i*75+w, h, 72, 95);
	 }
	 else 
	button[i].setBounds((i-noOfCards/2)*75+w, h+98, 72, 95);
	
	 
	//button[i].addActionListener(new ButtonAdapter(button[i]));
	 button[i].addActionListener(adapter);
	//button[i].addActionListener(this);
		
	frame.add(button[i]);
     }
	}
		catch(NullPointerException e)
		{}
	
	}
	
	int getRandomNumber()
	{   int number=1;
		try {
		 Random rand = new Random(); 
		  number=rand.nextInt(lastPosition+1);
		  if(number!=lastPosition) {
		 arr[number]=arr[number]+arr[lastPosition];
		 arr[lastPosition]=arr[number]-arr[lastPosition];
		 arr[number]=arr[number]-arr[lastPosition];
		  }	 
		lastPosition--;
		}
	catch(IllegalArgumentException e) {}
	return arr[lastPosition+1];
	}
	
}

