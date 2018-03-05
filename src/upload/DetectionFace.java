package upload;

import java.io.File;

import javax.swing.JOptionPane;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

public class DetectionFace {
	
	static File file;
	
	public DetectionFace() {}
	
	public void Extract(File file) {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
       /// String opencvpath = System.getProperty("user.dir") + "\\files\\";
        //String libPath = System.getProperty("java.library.path");
        //System.load("opencv_java341");
        System.out.println("\nRunning FaceDetector");
        Mat image = Imgcodecs.imread(file.getPath());
        CascadeClassifier faceDetector = new CascadeClassifier(System.getProperty("user.dir")+ "/haarcascade_frontalface_alt.xml");  
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        
        JOptionPane.showMessageDialog(null,String.format("Detected %s faces", faceDetections.toArray().length));
        //System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
 
        RecognitionFace recognition = new RecognitionFace();
		recognition.Recognition(file, image, faceDetections);

	}

}
