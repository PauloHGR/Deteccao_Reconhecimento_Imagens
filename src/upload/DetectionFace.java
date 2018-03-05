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
        MatOfRect eyeRightDetections = new MatOfRect();
        MatOfRect eyeLeftDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        
        JOptionPane.showMessageDialog(null,String.format("Detected %s faces", faceDetections.toArray().length));
        //System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
 
        CascadeClassifier eyeRightDetector = new CascadeClassifier(System.getProperty("user.dir")+ "/haarcascade_righteye_2splits.xml");
        CascadeClassifier eyeLeftDetector = new CascadeClassifier(System.getProperty("user.dir")+ "/haarcascade_lefteye_2splits.xml");
        eyeRightDetector.detectMultiScale(image, eyeRightDetections);
        eyeLeftDetector.detectMultiScale(image, eyeLeftDetections);

        
        RecognitionFace recognition = new RecognitionFace();
		recognition.Recognition(file, image, faceDetections, eyeRightDetections, eyeLeftDetections);
		

	}

}
