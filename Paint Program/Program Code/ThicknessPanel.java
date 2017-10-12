package ca.utoronto.utm.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
/**
 * 
 * @author student
 *
 * This class creates a separate panel just for the thickness selection menu
 * 
 */
public class ThicknessPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of
	// the view
	
	public ThicknessPanel(View view){
		this.view = view;
		
		JMenuBar Thickness = new JMenuBar(); // menu bar for selecting thickness
		JMenu menu;
		JMenuItem menuItem;
		
		String thicknessIcon = "resources\\icon images\\Thickness.png"; //png image for thickness
		
		menu = new JMenu();
		menu.setIcon(new ImageIcon(thicknessIcon));
		
		Thickness.add(menu);
		this.add(Thickness);

		menuItem = new JMenuItem("1"); // adding each thickness that can be selected to menu
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem = new JMenuItem("5");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem = new JMenuItem("10");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem = new JMenuItem("20");
		menuItem.addActionListener(this);
		menu.add(menuItem);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		
		if (action == "1") { // When a thickness is selected set the thickness to that value
			this.view.getPaintPanel().setThickness(1);
		}
		else if (action == "5") {
			this.view.getPaintPanel().setThickness(5);
		}
		else if (action == "10") {
			this.view.getPaintPanel().setThickness(10);
		}
		else if (action == "20") {
			this.view.getPaintPanel().setThickness(20);
		}
	}

}
