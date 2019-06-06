/*Create a new function for every button added so you can define its position properly. Using the default addButton() method twice will result in two buttons whose size ect will be the same.
 */

package templates;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SubFrame extends JFrame {
	
	
	
	public SubFrame(String title) {										//Constructor for the SubFrame, recieves the frames title
		
		super(title);													//Sets the title of the frame via the mother class JFrame
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));				//Defines the layout of the frame
		
		this.setSize(1000,750);											//Self explanatory
		
		final Container cont = getContentPane();						//Creates the container for interaction elements
		
		newButton("Template Button", cont);								//Creates a new button with the title/action Template Button which will be added to the cont Container
		
		newButton("FuckButton", cont);									//Same shit, different title
		
		}
		
	public void newButton(String action_name, Container cont) {			//Function to add new button, recieves button title which at the same time will be the action 
																		//title and the container which the button will be added to
		JButton templateButton = new JButton();							//Creates new JButton
		
		templateButton.setText(action_name);							//Self explanatory
		
		templateButton.setSize(500, 375);								//Self explanatory
		
		templateButton.addActionListener(new Action(action_name));		//Adds action listener which will get its action from the Action Class
		
		cont.add(templateButton);										//Adds the button to the recieved Container
	}
}
