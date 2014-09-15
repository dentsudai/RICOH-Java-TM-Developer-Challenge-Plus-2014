package opencvtest;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello, OpenCV");

	    // Load the native library.
	    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	    //new DetectFaceDemo().run();
		JFrame frame = new ScanResult();
		
	}

}
