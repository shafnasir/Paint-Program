package ca.utoronto.utm.paint;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;

/**
 * This is the top level View+Controller, it contains other aspects of the
 * View+Controller.
 * 
 * @author arnold
 *
 */
public class View extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private PaintModel model;

	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ColourPanel colourPanel;
	private ThicknessPanel thicknessPanel;

	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());

		Container c = this.getContentPane();
		// c.add(new JButton("North"),BorderLayout.NORTH);
		// c.add(new JButton("South"),BorderLayout.SOUTH);
		// c.add(new JButton("East"),BorderLayout.EAST);
		this.shapeChooserPanel = new ShapeChooserPanel(this); //where user selects what shape or feature to use
		this.thicknessPanel = new ThicknessPanel(this); 
		this.shapeChooserPanel.add(thicknessPanel);
		c.add(this.shapeChooserPanel, BorderLayout.WEST);

		this.model = model;

		this.paintPanel = new PaintPanel(model, this);
		c.add(this.paintPanel, BorderLayout.CENTER);

		// ADD COLOURS
		this.colourPanel = new ColourPanel(this);
		c.add(this.colourPanel, BorderLayout.SOUTH);

		this.pack();
		// this.setSize(200,200);
		this.setVisible(true);
	}

	public PaintPanel getPaintPanel() {
		return paintPanel;
	}

	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}

	public ColourPanel getColourPanel() {
		return colourPanel;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem.setMnemonic(KeyEvent.VK_F4);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		KeyStroke keyStrokeToUndo = KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(keyStrokeToUndo);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		KeyStroke keyStrokeToRedo = KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(keyStrokeToRedo);
		
		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Clear All");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuBar.add(menu);
		KeyStroke keyStrokeToClearAll = KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(keyStrokeToClearAll);
		
		return menuBar;
	}

	public void actionPerformed(ActionEvent e) {
		String action_command = e.getActionCommand();
		if(action_command=="Undo"){
			Drawable d=(Drawable)this.paintPanel.getDrawable();
			if(d!=null){
				d.setFinished();
				}
			this.model.undo();}
		if(action_command=="Redo"){
			Drawable d=(Drawable)this.paintPanel.getDrawable();
			if(d!=null){
				d.setFinished();
				}
			this.model.redo();}
		if(action_command == "Clear All"){
			this.model.clearAll();
		}
		if(action_command == "Exit"){
			this.dispose();
		}
	}
}
