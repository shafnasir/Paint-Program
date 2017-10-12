package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * 
 * @author student
 *
 * This class lets the user press and drag to create a square
 */
public class Square extends Drawable{
	private Point origin, anchor;
	private int dimension, thickness;
	private Color color;
	private boolean fill;
	
	/**
	 * Constructs a new square to be drawn
	 * @param color: color of square
	 * @param thickness: thickness of square
	 * @param fill: to be filled or not 
	 */
	public Square(Color color, int thickness, boolean fill) {
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
	 * Where the square has been completely dragged so it can be drawn
	 * @param end_point: The current position point of the mouse when released/dragging 
	 */
	public void setEnd(Point end_point) {
		int end_x = end_point.getX();
		int end_y = end_point.getY();
		int anchor_x = anchor.getX();
		int anchor_y = anchor.getY();
		int width = Math.abs(end_x - anchor_x);
		int height = Math.abs(end_y - anchor_y);
		this.dimension = Math.min(width, height);
		int x_location, y_location;
		if (end_x >= anchor_x && end_y >= anchor_y) {
			x_location = anchor_x;
			y_location = anchor_y;
		} else if (end_x >= anchor_x && end_y <= anchor_y) {
			x_location = anchor_x;
			y_location = anchor_y - this.dimension;
		} else if (end_x <= anchor_x && end_y >= anchor_y) {
			x_location = anchor_x - this.dimension;
			y_location = anchor_y;
		} else {
			x_location = anchor_x - this.dimension;
			y_location = anchor_y - this.dimension;
		}
		this.origin.setX(x_location);
		this.origin.setY(y_location);
	}
	
	/**
	 * Returns the origin point of the square
	 * @return origin
	 */
	public Point getOrigin() {
		return origin;
	}
	
	/**
	 * Returns the dimensions of the square
	 * @return dimension
	 */
	public int getDimension() {
		return dimension;
	}
	
	/**
	 * Sets the value for the origin of the square
	 * @param origin: the origin value of the square
	 */
	public void setOrigin(Point origin) {
		this.origin = origin;
	}
	
	/**
	 * Sets the anchor value for the square.
	 * @param anchor: First click point
	 */
	public void setAnchor(Point anchor) {
		this.anchor = anchor;
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
			g2d.fillRect(this.origin.x, this.origin.y, this.dimension, this.dimension);
		} else {
			g2d.drawRect(this.origin.x, this.origin.y, this.dimension, this.dimension);
		}
	}
}
