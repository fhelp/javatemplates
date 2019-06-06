package templates;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Frame {
	
	public Frame(String title) {
		SwingUtilities.invokeLater(new Runnable() {								//Adds a new Runnable to the Event Dispatching Thread's Queue
			public void run() {													//Definition of the Runnabable's run() function (which will be eventually executed
				
				JFrame homeframe = new SubFrame(title);							//Creates a new instance of the SubFrame Class
				
		        homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Makes the red cross button on the top right terminate the program
		        
				homeframe.setVisible(true);										//Makes the SubFrame visible
			}
			
		});
		
	}
	
	

}
