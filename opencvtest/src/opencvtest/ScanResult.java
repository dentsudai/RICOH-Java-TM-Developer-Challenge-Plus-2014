package opencvtest;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class ScanResult extends JFrame{
	MyCanvas canvas;
	GameWindow gamecanvas;
	int canvasSize[] = {0,0};
	public ScanResult() throws HeadlessException {
		super();
		this.setTitle("test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,1000);
        this.setLocationRelativeTo(null);
        BoxLayout boxlayout =new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS);
            this.setLayout(boxlayout);
        Mat circles = new Mat();
        Mat gray = new Mat();
		Mat img = Highgui.imread("res/maru.jpg");
		this.canvasSize[0] = (int) img.size().width;
		this.canvasSize[1] = (int) img.size().height;
		//処理///////////////////////////////////////////////////////
		
		
		Imgproc.cvtColor(img, gray,Imgproc.COLOR_RGB2GRAY);
		Imgproc.HoughCircles(gray, circles, Imgproc.CV_HOUGH_GRADIENT, 2, 10, 160, 50, 10, 20); 
		System.out.println(circles.elemSize());
		System.out.println(circles.dump());
		System.out.println(img.size().height);
		fncDrwCircles(circles,img);

		//表示/////////////////////////////////////////////////////
		canvas = new MyCanvas(mat2image(img),canvasSize);
		this.add(canvas);
		gamecanvas = new GameWindow(circles, canvasSize);
		this.add(gamecanvas);
		this.setVisible(true);
		
		while(true){
			this.gamecanvas.repaint();
			this.repaint();
		}
	}

	/**
	 * 画像(Mat)をImage形式に変換する。
	 * 
	 * @param mat 画像(Mat)
	 * @return 画像(Image)
	 */
	public Image mat2image(Mat mat) {
		 System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		if (mat==null) return null;

		BufferedImage image = null;
		MatOfByte mb = new MatOfByte();
		Highgui.imencode(".bmp", mat, mb); // Mat形式からOpenCVのバイト列作成
		try {
			// バイト列から画像を読み込む
			image = ImageIO.read(new ByteArrayInputStream(mb.toArray()));

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return image;
	}
	
	private void fncDrwCircles(Mat circles ,Mat img) {
		  double[] data;
		  double rho;
		  Point pt = new Point();
		  for (int i = 0; i < circles.cols(); i++){
		    data = circles.get(0, i);
		    pt.x = data[0];
		    pt.y = data[1];
		    rho = data[2];
		    Core.circle(img, pt, (int)rho, new Scalar(255, 0, 0),2);
		  }
		  }
	


}
