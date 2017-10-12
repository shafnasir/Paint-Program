
package ca.utoronto.utm.paint;



import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class PaintModel extends Observable {
	//how to keep track of "history" so that redo and undo works?
	private List<Object> drawables_path = new ArrayList<Object>(); //for redo/undo. drawables "history"
	private List<Object> drawable_OnScreen = new ArrayList<Object>();
	private int current_pathIndex = -1;
	private DrawableFactory drawables = new DrawableFactory();
	//private final int 
	
	
	public Object createDrawable(String drawable, int thickness, Color color, boolean fill){
		int next_index = this.current_pathIndex + 1;
		int max_pathIndex = this.drawables_path.size()-1;
		if(next_index<=max_pathIndex){
			for(int i = next_index; i<= max_pathIndex; i++){this.drawables_path.remove(i);}}
		Object drawable_toDraw = this.drawables.createDrawable(drawable, thickness, color, fill);
		this.drawable_OnScreen.add(drawable_toDraw);
		this.drawables_path.add(drawable_toDraw);
		this.current_pathIndex++;
		return drawable_toDraw;
	}

	public void drawAll(Graphics2D g2d){
        for(Object drawable:this.drawable_OnScreen){
        	((Drawable) drawable).drawObject(g2d);
        }
	}
	
	public int getCurrenttDrawIndex(){return this.current_pathIndex;}
	public int getMaxDrawIndex(){return this.drawables_path.size()-1;}
	public void redo(){
		int next_index = this.current_pathIndex + 1;
		int max_pathIndex = this.drawables_path.size()-1;
		if(next_index<=max_pathIndex){
			System.out.println(this.current_pathIndex);
			this.current_pathIndex++;
			this.drawable_OnScreen.add(this.drawables_path.get(this.current_pathIndex));
			this.setChanged();
			this.notifyObservers();}}
	public void undo(){
		if(this.current_pathIndex>=0){
			
			this.drawable_OnScreen.remove(this.current_pathIndex);
			this.current_pathIndex--;
			this.setChanged();
			this.notifyObservers();
		}
	}
	public void clearAll(){
		this.drawable_OnScreen.clear();
		this.drawables_path.clear();
		this.current_pathIndex=-1;
		this.setChanged();
		this.notifyObservers();
	}
	}

