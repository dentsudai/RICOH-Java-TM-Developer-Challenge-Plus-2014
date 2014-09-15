package opencvtest;

import java.awt.Color;

public class Tama {
	private int x,y,size;
	public float v[] = {0,0};
	Color color;
	public Tama(int x, int y, int size) {
		this.setX(x);
		this.setY(y);
		this.setSize(size);
		this.setColor(Color.GREEN);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int getX(){
		
		return this.x;
	}
	
	public int getY(){
		
		return this.y;
	}
	
	public int getSize(){
		
		return this.size;
	}
	
	public Color getColor(){
		
		return this.color;
	}
	
	public void setX(int x){
		
		this.x = x;
	}
	
	public void setY(int y){
		
		this.y = y;
	}
	
	public void setSize(int size){
		
		this.size = size;
	}
	
	public void setColor(Color color){
		
		this.color = color;
	}
	
	public void update(int[] canvasSize){
		if(this.x + this.v[0] > canvasSize[0] || this.x + this.v[0] < 0){
			this.v[0] = -1*this.v[0];
		}
		if(this.y + this.v[1] > canvasSize[1]){
			this.v[1] = -1*this.v[1];
		}
		this.setX(this.getX()+(int)this.v[0]);
		this.setY(this.getY()+(int)this.v[1]);
	}

}
