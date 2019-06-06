/*READ: Pay attention to the spelling of the switch cases! Due to the fact that the button text will at the same time be the action title, pay attention so you don't create one of the nasty
little spelling mistakes which will ruin your program and make you jump from a bridge! */

package templates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Action implements ActionListener {
	
	private String action_name;
	
	public Action(String action_name) {				//Constructor which will set the action name 
		
		this.action_name = action_name;
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch(this.action_name) {										//Switch to recognize which action will be performed
		case "Template Button":											//Template action, will open a new JFrame
			JFrame newFrame = new SubFrame("New SubFrame");
			
			newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			newFrame.setVisible(true);
			
			break;
		default:														
			break;
		}
		
	}
	
	
}
