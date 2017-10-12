package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * @author student
 *
 * This class lets the user press and drag to create a Rectangle
 */
public class Rectangle extends Drawable{
	private Point origin, anchor;
	private int width = 0;
	private int height = 0;
	private int thickness;
	private Color color;
	private boolean fill;

	/**
	 * Constructs a new Rectangle to be drawn
	 * @param color: color of rectangle
	 * @param thickness: thickness of rectangle
	 * @param fill: to be filled or not 
	 */
	public Rectangle(Color color, int thickness, boolean fill) {
		this.color = color;
		this.thickness = thickness;
		this.fill = fill;
	}
	@Override
	public void setInitialClickValues(int x, int y){
		this.origin=new Point(x,y);
		this.anchor=new Point(x,y);
	}
	/**
	 * Sets the current position point of the mouse when released/dragging
	 * @param end_point: position point of the mouse when released/dragging
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
	 * Sets the height of the rectangle
	 * @param height: height of the rectangle
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Sets the width of the rectangle
	 * @param width: width of the rectangle
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Sets the origin of the rectangle
	 * @param origin: origin of the rectangle
	 */
	public void setOrigin(Point origin) {
		this.origin = origin;
	}
	
	/**
	 * Sets the anchor of the rectangle
	 * @param anchor: First click point
	 */
	public void setAnchor(Point anchor) {
		this.anchor = anchor;
	}

	/**
	 * Returns the origin of the square
	 * @return: origin of square
	 */
	public Point getOrigin() {
		return origin;
	}
	
	/**
	 * Returns the height of the square
	 * @return: height of square
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns the width of the square
	 * @return: width of square
	 */
	public int getWidth() {
		return width;
	}
	@Override
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	@Override
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	@Override
	public void updateValues(int x, int y) {
		this.setEnd(new Point(x, y));
	};
	@Override
	public void drawObject(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.setStroke(new BasicStroke(this.thickness));
		if (this.fill == true) {
			g2d.fillRect(this.origin.x, this.origin.y, this.width, this.height);
		} else {
			g2d.drawRect(this.origin.x, this.origin.y, this.width, this.height);
		}
	}
}
