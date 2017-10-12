package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.QuadCurve2D;
/**
 * 
 * @author student
 *
 * A squiggle that is drawn with 3 clicks creating 2 curves
 */
public class Squiggle extends Drawable{
	private Point start_point, end_point, focus_point1, focus_point2;
	private QuadCurve2D quadratic_curve;
	private CubicCurve2D cubic_curve;
	private Color color;
	private int thickness, draw_stage=0;
	private boolean fill;
	private boolean finished_drawing;
	
	/**
	 * Constructs a new Squiggle to be drawn
	 * @param color: color of the Squiggle
	 * @param thickness: thickness of the Squiggle
	 * @param fill: whether the Squiggle will be filled or not
	 */
	public Squiggle(Color color, int thickness, boolean fill) {
		this.color = color;
		this.thickness = thickness;
		this.fill = fill;
	}
	@Override
	public void setInitialClickValues(int x, int y){
		this.start_point=new Point(x,y);
		this.end_point=new Point(x,y);
		this.focus_point1=new Point(x,y);
		this.focus_point2=new Point(x,y);
		this.quadratic_curve = new QuadCurve2D.Float();
		this.cubic_curve=new CubicCurve2D.Float();
	}
	
	/**
	 * Returns the starting point of the squiggle
	 * @return starting point of squiggle
	 */
	public Point getStartpoint() {
		return this.start_point;
	}

	/**
	 * Returns the ending point of the squiggle
	 * @return ending point of squiggle
	 */
	public Point getEndpoint() {
		return this.end_point;
	}
	
	/**
	 * Sets the ending point of the squiggle
	 * @param end_point: ending point of the squiggle
	 */
	public void setEndpoint(Point end_point) {
		this.end_point.setX(end_point.getX());
		this.end_point.setY(end_point.getY());
	}
	
	/**
	 * Sets the first focus point for the squiggle
	 * @param focus_point1: the first focus point (curve)
	 */
	public void setFirstFocusPoint(Point focus_point1) {
		this.focus_point1 = focus_point1;
	}
	
	/**
	 * Sets the second focus point for the squiggle
	 * @param focus_point2: the second focus point (curve)
	 */
	public void setSecondFocusPoint(Point focus_point2) {
		this.focus_point2 = focus_point2;
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
		if(draw_stage==1){
			this.setEndpoint(new Point(x, y));
		}
		else if(draw_stage==3){
			this.focus_point1.setX(x);
			this.focus_point1.setY(y);
			this.quadratic_curve.setCurve(this.start_point.getX(),this.start_point.getY(),
					this.focus_point1.getX(),this.focus_point1.getY(),this.end_point.getX(),this.end_point.getY());
		}
		else if(draw_stage==5){
			this.focus_point2.setX(x);
			this.focus_point2.setY(y);
			this.cubic_curve.setCurve(this.start_point.getX(), this.start_point.getY(), 
					this.focus_point1.getX(),this.focus_point1.getY(), 
					this.focus_point2.getX(),this.focus_point2.getY(), 
					this.end_point.getX(),this.end_point.getY());
		}
	}
	@Override
	public void drawObject(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.setStroke(new BasicStroke(this.thickness));
		if(this.draw_stage==1||this.draw_stage==2){
			g2d.drawLine(this.start_point.getX(), this.start_point.getY(), this.end_point.getX(), this.end_point.getY());}
		else if(this.draw_stage==3||this.draw_stage==4){g2d.draw(this.quadratic_curve);}
		else if(this.draw_stage>=5){g2d.draw(this.cubic_curve);}
	}
	@Override
	public void incrementDrawStage(){
		this.draw_stage++;
	}
	@Override
	public void setFinished(){
		this.finished_drawing=true;
	}
	@Override
	public boolean finishedDrawing(){
		if(this.draw_stage>=6||this.finished_drawing==true){return true;}
		return false;
	}
}
