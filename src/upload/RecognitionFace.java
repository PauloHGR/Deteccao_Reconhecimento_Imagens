package upload;

import java.io.File;

import javax.swing.JOptionPane;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class RecognitionFace {
	
	public RecognitionFace(){}

	public void Recognition(File file, Mat image, MatOfRect faceDetections) {
		// TODO Auto-generated method stub
		for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }
 
        String filename = "gato-maestria.png";
        System.out.println(String.format("Writing %s", filename));
        Imgcodecs.imwrite(filename, image);
        
        if (faceDetections.toArray().length >= 1) {
            JOptionPane.showMessageDialog(null,String.format("FOTO!"));

        } else {
            JOptionPane.showMessageDialog(null,String.format("NÃO É FOTO!"));

        }
	}
	
	
}
