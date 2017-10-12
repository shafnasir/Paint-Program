package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.colorchooser.AbstractColorChooserPanel;

/**
 * 
 * @author student
 * Creates another GUI JPanel which includes some basic colours for the user to select for the paint component. 
 */
public class BasicColourPanel extends AbstractColorChooserPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private View view;
	private JButton bSelectColour;
	
	/**
	 * Constructs a BasicColourPanel
	 * @param view View object, hooks up to View for MVC
	 * @param bSelectColour JButton that shows current colour selected.
	 */
	public BasicColourPanel(View view, JButton bSelectColour) {
		this.view = view;
		this.bSelectColour = bSelectColour;
	}

	@Override
	protected void buildChooser() {
		ButtonGroup colours = new ButtonGroup();

		Color[] colourLabels = { Color.black, Color.darkGray, Color.gray, Color.lightGray, Color.white, Color.pink,
				Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.magenta,
				new Color(165, 42, 42) };
		setLayout(new GridLayout(2, colourLabels.length));

		// Creates the buttons for the basic colours provided on main panel.
		for (int i = 0; i < colourLabels.length; i++) {
			JButton button = new JButton();
			button.setBackground(colourLabels[i]);
			button.setActionCommand(colourLabels[i].toString());
			colours.add(button);
			add(button);
			button.addActionListener(this);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color newColor = null;
		String command = ((JButton) e.getSource()).getActionCommand();
		// List of basic colours provided to user. Checks which colour user
		// selected.
		if ("java.awt.Color[r=0,g=0,b=0]".equals(command)) {
			newColor = Color.black;
		} else if ("java.awt.Color[r=64,g=64,b=64]".equals(command)) {
			newColor = Color.darkGray;
		} else if ("java.awt.Color[r=128,g=128,b=128]".equals(command)) {
			newColor = Color.gray;
		} else if ("java.awt.Color[r=192,g=192,b=192]".equals(command)) {
			newColor = Color.lightGray;
		} else if ("java.awt.Color[r=255,g=255,b=255]".equals(command)) {
			newColor = Color.white;
		} else if ("java.awt.Color[r=255,g=175,b=175]".equals(command)) {
			newColor = Color.pink;
		} else if ("java.awt.Color[r=255,g=0,b=0]".equals(command)) {
			newColor = Color.red;
		} else if ("java.awt.Color[r=255,g=200,b=0]".equals(command)) {
			newColor = Color.orange;
		} else if ("java.awt.Color[r=255,g=255,b=0]".equals(command)) {
			newColor = Color.yellow;
		} else if ("java.awt.Color[r=0,g=255,b=0]".equals(command)) {
			newColor = Color.green;
		} else if ("java.awt.Color[r=0,g=255,b=255]".equals(command)) {
			newColor = Color.cyan;
		} else if ("java.awt.Color[r=0,g=0,b=255]".equals(command)) {
			newColor = Color.blue;
		} else if ("java.awt.Color[r=255,g=0,b=255]".equals(command)) {
			newColor = Color.magenta;
		} else if ("java.awt.Color[r=165,g=42,b=42]".equals(command)) {
			newColor = new Color(165, 42, 42);
		}
		view.getPaintPanel().setColour(newColor);
		bSelectColour.setBackground(newColor);
	}

	@Override
	public String getDisplayName() {
		return "Colours";
	}

	@Override
	public Icon getLargeDisplayIcon() {
		return null;
	}

	@Override
	public Icon getSmallDisplayIcon() {
		return null;
	}

	@Override
	public void updateChooser() {

	}

}
