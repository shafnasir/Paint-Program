package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * @author student
 *
 * This class lets the use click and drag to create a straight Polyline.
 * 
 */
public class Polyline extends Drawable{
	private Point start_point, end_point;
	private Color color;
	private int thickness,draw_stage=0;
	private boolean fill;
	
	/**
	 * Constructs a new Polyline to be drawn
	 * @param color: the color of the Polyline
	 * @param thickness: the thickness of the Polyline
	 * @param fill: if the Polyline will be filled or not
	 */
	public Polyline(Color color, int thickness, boolean fill) {
		this.color = color;
		this.thickness = thickness;
		this.fill = fill;
	}
	@Override
	public void setInitialClickValues(int x, int y){
		this.start_point=new Point(x,y);
		this.end_point=new Point(x,y);
	}
	
	/**
	 * Returns the starting point of the Polyline
	 * @return starting point
	 */
	public Point getStartpoint() {
		return this.start_point;
	}
	
	/**
	 * Returns the ending point of the Polyline
	 * @return ending point
	 */
	public Point getEndpoint() {
		return this.end_point;
	}
	
	/**
	 * Sets the starting point of the PolyLine
	 * @param start_point: starting point of Polyline
	 */
	public void setStart_point(Point start_point) {
		this.start_point = start_point;
	}
	
	/**
	 * Sets the ending point of the PolyLine
	 * @param end_point: ending point of Polyline
	 */
	public void setEndpoint(Point end_point) {
		this.end_point.setX(end_point.getX());
		this.end_point.setY(end_point.getY());
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
		this.setEndpoint(new Point(x, y));
	};
	@Override
	public void drawObject(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.setStroke(new BasicStroke(this.thickness));
		g2d.drawLine(start_point.getX(), start_point.getY(), end_point.getX(), end_point.getY());
	}
}
