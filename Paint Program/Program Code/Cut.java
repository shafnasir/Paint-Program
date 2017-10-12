package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
/**
 * 
 * @author student
 * Cut Drawable, Copies and removes what the user has highlighted. 
 */
public class Cut extends Drawable {
	private Point origin, anchor;
	private int width = 0;
	private int height = 0;
	private int thickness;
	private Color color;
	private boolean fill;
	
	
	@Override
	public void setInitialClickValues(int x, int y){
		this.origin=new Point(x,y);
		this.anchor=new Point(x,y);
	}
	/**
	 * Sets the origin, width, and height to match the end point, So that the shape 
	 * can be created under those restrictions. 
	 * @param end_point is a type Point and is the current position point of the mouse when released/dragging
	 */
	public void setEnd(Point end_point) {
		int minX = Math.min(end_point.getX(), anchor.getX());
		int minY = Math.min(end_point.getY(), anchor.getY());
		int maxX = Math.max(end_point.getX(), anchor.getX());
		int maxY = Math.max(end_point.getY(), anchor.getY());
		this.origin.setX(minX);
		this.origin.setY(minY);
		this.width = maxX - minX;
		this.height = maxY - minY;
	}
	/**
	 * Set the height of the outline.
	 * @param height int value for the height.
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * Set the width of the outline.
	 * @param width int value for the width.
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * Sets the Origin point of the outline (the top right coordinate)
	 * @param origin Point value representing the x,y coordinate of the shapes origin.
	 */
	public void setOrigin(Point origin) {
		this.origin = origin;
	}
	/**
	 * Sets the point on which the outline is anchored on,
	 * thus allowing it to pivot on that point.
	 * @param anchor Point value representing the x,y coordinate of the first point mouse was pressed on. 
	 */
	public void setAnchor(Point anchor) {
		this.anchor = anchor;
	}
	/**
	 * Retrieves the origin of the outline
	 * @return Point value representing the x,y coordinate of the origin.
	 */
	public Point getOrigin() {
		return origin;
	}
	/**
	 * Retrieves the height of the outline.
	 * @return int value representing height of outline.
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Retrieves the width of the outline.
	 * @return int value representing width of outline.
	 */
	public int getWidth() {
		return width;
	}

	@Override
	public void updateValues(int x, int y) {
		this.setEnd(new Point(x, y));
	};
	

	@Override
	public void drawObject(Graphics2D g2d) {
		g2d.setColor(color.WHITE);
		g2d.drawRect(origin.x, origin.y, width, height);	//draws the outline of what the user wants to copy.
	}

}