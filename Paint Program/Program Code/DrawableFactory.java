package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;

/**
 * 
 * @author student
 * 
 * To choose which drawable needs to be drawn next
 */
public class DrawableFactory {
	private Copy copy = null; // values needed for copy, cut and paste
	private Cut cut = null;
	private String type ="";
	
	/**
	 * Constructs the drawable that will be drawn next
	 * @param drawable: drawable to be drawn
	 * @param thickness: thickness of the drawable
	 * @param color: color of the drawable
	 * @param fill: whether the drawable will be filled or not
	 * @return: which drawable will be drawn
	 */
	public Object createDrawable(String drawable, int thickness, Color color, boolean fill) {
		if (drawable == "Circle") // Checking which drawable needs to be drawn next.
			return new Circle(color, thickness, fill); // creates and returns the requested drawable.
		if (drawable == "Square")
			return new Square(color, thickness, fill);
		if (drawable == "Rectangle")
			return new Rectangle(color, thickness, fill);
		if (drawable == "Squiggle")
			return new Squiggle(color, thickness, fill);
		if (drawable == "Polyline")
			return new Polyline(color, thickness, fill);
		if (drawable == "Copy"){
			copy = new Copy();
			type = "copy";
			return  copy;}
		if (drawable == "Cut"){
			cut = new Cut();
			type = "cut";
			return cut;}
		if (drawable == "Paste")
			return new Paste(copy, cut, type);
		return null;
	}
}
