package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
/**
 * 
 * @author student
 *
 * The abstract class for all the shapes that will be drawn
 */
public class Drawable {
	/**
	 * The values of the Drawable are updated
	 * @param x: the x coordinate of the shape
	 * @param y: the y coordinate of the shape
	 */
	public void updateValues(int x, int y){}
	
	/**
	 * Draws the object into the panel
	 * @param g2d: the graphics used to draw the Drawable
	 */
	public void drawObject(Graphics2D g2d) {	
	}
	
	/**
	 * Sets the color of the Drawable
	 * @param color: color of the Drawable
	 */
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Sets the thickness of the Drawable
	 * @param thickness: thickness of the Drawable
	 */
	public void setThickness(int thickness) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Sets true or false as to whether the Drawable will be filled or not
	 * @param fill: filled or not to be filled
	 */
	public void setFill(boolean fill) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Set the first click value of the Drawable.
	 * @param x: the initial x value of the Drawable
	 * @param y: the initial xy value of the Drawable
	 */
	public void setInitialClickValues(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * To check if the current Drawable is done drawing
	 * @return true or false
	 */
	public boolean finishedDrawing() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * Increments the Draw Stage 
	 */
	public void incrementDrawStage() {
		// TODO Auto-generated method stub
		
	}
	public void setFinished(){
		
	}

}
