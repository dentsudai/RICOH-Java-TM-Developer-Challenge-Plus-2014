package opencvtest;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Image;

public class MyCanvas extends Canvas {
	Image image;
	int size[] ={0,0};
	public MyCanvas(Image image , int[] size) {
		// TODO Auto-generated constructor stub
		this.image = image;
		this.setSize(size[0],size[1]);
		this.setVisible(true);
	}

	public MyCanvas(GraphicsConfiguration config) {
		super(config);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void paint(Graphics g){
		g.drawImage(image,0,0,this);
	}

}
