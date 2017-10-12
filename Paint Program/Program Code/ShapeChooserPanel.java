package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;


// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/
/**
 * 
 * @author student
 * Creates GUI panel where user can select which mode they would like to paint in. Also access other features they can apply.
 */
class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of
						// the view
	private String[] available_modes={ "Circle", "Rectangle", "Square", "Squiggle", "Polyline", "Copy", "Cut", "Paste"};
	private String selected_buttonstring;
	private ButtonGroup group;
	private ArrayList<JToggleButton> toggle_buttons=new ArrayList<JToggleButton>();
	public ShapeChooserPanel(View view) {
		this.view = view;
		this.group=new ButtonGroup();
		String[] buttonIcons = { "resources\\icon images\\Circle.png",
				"resources\\icon images\\Rectangle.png", "resources\\icon images\\Square.png",
				"resources\\icon images\\Squiggle.png", "resources\\icon images\\PolyLine.png",
				"resources\\icon images\\Fill.png", "resources\\icon images\\Copy.png",
				"resources\\icon images\\Cut.png", "resources\\icon images\\Paste.png"};
		//gets all the icons for the buttons
		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline", "Fill", 
				"Copy", "Cut", "Paste" };
		this.setLayout(new GridLayout(buttonLabels.length + 1, 1));
		
		for (int i = 0; i < buttonLabels.length; i++) {
			JToggleButton button = new JToggleButton();
			button.setActionCommand(buttonLabels[i]);
			button.setIcon(new ImageIcon(buttonIcons[i]));
			this.toggle_buttons.add(button);
			this.group.add(button);
			this.add(button);
			
			button.addActionListener(this);
		}	//creates each button for the panel, aswell as asigning there action commands and icons. 
	}

	private boolean fillB = false;

	/**
	 * Controller aspect of this.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String action_command = e.getActionCommand();

		for(String drawable:this.available_modes){
			if(drawable==action_command){
				this.view.getPaintPanel().setMode(action_command);}
			}
		//System.out.println(e.getActionCommand());

		if (action_command == "Fill") {

			if (fillB) {
				fillB = false;
			} else {
				fillB = true;
			}
			this.view.getPaintPanel().setFill(fillB);
		}

	}
}
