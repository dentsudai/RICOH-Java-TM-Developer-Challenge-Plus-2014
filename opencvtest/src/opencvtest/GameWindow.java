package opencvtest;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;

import org.opencv.core.Mat;

public class GameWindow extends Canvas {
	Tama[] tama;
	int size[] ={0,0};
	public GameWindow(Mat circles, int[] size) {
		// TODO Auto-generated constructor stub
		this.setSize(size[0],size[1]);
		this.size =size;
		this.setBackground(Color.black);
		//検出したデータから玉のインスタンスを生成
		this.tama = new Tama[circles.cols()];
		for(int i=0;circles.cols() > i;i++){
			double[] data = circles.get(0,i);
			tama[i] = new Tama((int)data[0],(int)data[1],(int)data[2]*2);
		}
		
		this.setVisible(true);
	}

	public GameWindow(GraphicsConfiguration config) {
		super(config);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics g){
		//tamaの描画
		for(int i = 0;tama.length > i;i++){
			g.setColor(tama[i].getColor());
			g.fillOval(tama[i].getX(), tama[i].getY(), tama[i].getSize(), tama[i].getSize());
		}
	}
	
	public void update(Graphics g){
		super.update(g);
		for(int i =0 ;tama.length > i;i++){
			tama[i].v[1] += 0.1;
			tama[i].update(size);
		}
		
	}

}
