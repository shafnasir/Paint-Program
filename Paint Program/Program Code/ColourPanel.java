package ca.utoronto.utm.paint;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

/**
 * 
 * @author student
 *
 *         Sets up GUI for the Colour panel, and also allos user to change the
 *         color of paint as they desire.
 */
public class ColourPanel extends JPanel implements ActionListener {
	private Color currentColor = Color.black;

	private JButton bSelectColour;
	private View view;
/**
 * Creates and contructs the ColourPanel
 * @param view View object, which hooks up ColourPanel to the MVC
 */
	ColourPanel(View view) {
		this.view = view;

		// will be the button to select more advance colours, and the colour of
		// button should show current colour.
		bSelectColour = new JButton();
		bSelectColour.setBackground(currentColor);
		bSelectColour.setPreferredSize(new Dimension(40, 40));
		bSelectColour.addActionListener(this);
		this.add(bSelectColour);

		// create a "quick access" to some simple colours.
		JColorChooser jcc = new JColorChooser();
		jcc.setPreviewPanel(new JPanel());
		// Override the chooser panels with our own.
		AbstractColorChooserPanel panels[] = { new BasicColourPanel(view, bSelectColour) };
		jcc.setChooserPanels(panels);

		this.add(jcc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// opens a JColorChooser preview box for the user to have more options
		// on colours to select.
		JColorChooser jcc = new JColorChooser();
		currentColor = jcc.showDialog(null, "Please select a colour", Color.BLUE);

		view.getPaintPanel().setColour(currentColor);
		bSelectColour.setBackground(currentColor);

	}
}
