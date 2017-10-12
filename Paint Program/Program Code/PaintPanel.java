package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener {
	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way
								// painting works
	private View view; // So we can talk to our parent or other components of
						// the view
	private int thickness;
	private boolean fill;
	private Color color;
	private String mode; // modifies how we interpret input (could be better?)
	private Object drawable;

	
	public PaintPanel(PaintModel model, View view) {
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(300, 300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.model = model;
		this.model.addObserver(this);
		this.thickness = 1;
		this.view = view;
		this.color = Color.BLACK;
		this.fill = false;

	}

	/**
	 * View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!

		super.paintComponent(g); // paint background
		Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		// setBackground (Color.blue);
		this.model.drawAll(g2d);
		
		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}

	public void setThickness(int t) {
		this.thickness = t;
	}

	/**
	 * Controller aspect of this
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.drawable!=null){
			((Drawable) this.drawable).updateValues(e.getX(), e.getY());
			this.repaint();
		}
	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// set colour/thickness/fill...
		if (this.mode != null) {
			if(this.drawable==null||(this.drawable!=null&&((Drawable) this.drawable).finishedDrawing())){
				this.drawable = this.model.createDrawable(this.mode, this.thickness, this.color, this.fill);
				((Drawable) this.drawable).setInitialClickValues(e.getX(), e.getY());
				((Drawable) this.drawable).incrementDrawStage();
				}
			else{
				((Drawable) this.drawable).incrementDrawStage();
				((Drawable) this.drawable).updateValues(e.getX(),e.getY());
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.drawable!=null){
			((Drawable) this.drawable).incrementDrawStage();
		}
		//this.drawable=null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
	
	public void setColour(Color c) {
		this.color = c;
	}

	public void setFill(boolean b) {
		this.fill = b;

	}
	public Drawable getDrawable(){
		return (Drawable) this.drawable;
	}

}
