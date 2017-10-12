package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * @author student
 *
 * This class lets the user press and drag to create a Circle
 */
public class Circle extends Drawable{
	private Point centre;
	private int radius;
	private Color color;
	private int thickness;
	private boolean fill;
	private boolean finished_drawing;
	private int draw_stage=0;

	/**
	 * Constructs a new Circle to be drawn
	 * @param color: color of circle
	 * @param thickness: thickness of circle
	 * @param fill: to be filled or not 
	 */
	public Circle(Color color, int thickness, boolean fill) {
		this.color = color;
		this.thickness = thickness;
		this.fill = fill;
	}
	@Override
	public void setInitialClickValues(int x, int y){
		this.centre=new Point(x,y);
	}
	
	/**
	 * Sets the centre point of the circle
	 * @param centre: centre point of the circle
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}

	/**
	 * Sets the radius of the circle
	 * @param radius: radius of the circle
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * Returns the centre of the circle
	 * @return centre of the circle
	 */
	public Point getCentre() {
		return centre;
	}

	/**
	 * Returns the radius of the circle
	 * @return radius of the circle
	 */
	public int getRadius() {
		return radius;
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
		int x_gap = this.centre.getX() - x;
		int y_gap = this.centre.getY() - y;
		int radius = (int) Math.sqrt(Math.pow(x_gap, 2) + Math.pow(y_gap, 2));
		this.radius = radius;
	};
	@Override
	public void drawObject(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.setStroke(new BasicStroke(this.thickness));
		if (this.fill == true) {
			g2d.fillOval(this.centre.x - this.radius, this.centre.y - this.radius, 2 * this.radius, 2 * this.radius);
		} else {
			g2d.drawOval(this.centre.x - this.radius, this.centre.y - this.radius, 2 * this.radius, 2 * this.radius);
		}
	}

	@Override
	public void setFinished(){
		this.finished_drawing=true;
	}
	
	@Override
	public void incrementDrawStage(){
		this.draw_stage++;
	}
	@Override
	public boolean finishedDrawing(){
		if(this.draw_stage>=2||this.finished_drawing==true){return true;}
		return false;
	}
	
}
