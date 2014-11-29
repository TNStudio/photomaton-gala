package application.model;

import imageProcessing.ImageBuilder;
import imageProcessing.ImageConverter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import observerPattern.MyObservable;
import observerPattern.MyObserver;
import edsdk.utils.CanonCamera;

public class Modele implements MyObservable{
	
	public static int POLLING_TIME = 1000;
	public static String photoFolder = "E:\\Dropbox\\Gala2014\\3"; //temp file
	public static String photoNoCanva = "E:\\Dropbox\\studio\\GALA";
	
	private CanonCamera slr;
	private int photo_number = 0;
	private BufferedImage image = null;
	private BufferedImage canvas = null;
	private BufferedImage result = null;
	
	private ArrayList<MyObserver> obsList;

	private DownloadThread downloadThread;
	
	public Modele(){
		obsList = new ArrayList<MyObserver>();
		
		slr = new CanonCamera();
		
		slr.openSession();
		
		downloadThread = new DownloadThread(this, slr, photoNoCanva);
		
	}


	public void MyUpdate(File photo, String name) {

			try {
				image = ImageIO.read(photo);
				canvas = ImageIO.read(new File("Canvas.jpg"));
				ImageBuilder builder = new ImageBuilder(canvas, image);
				//result = builder.getResult();
				result = canvas;
				updateObserver();
				ImageIO.write(result, "JPG", new File(photoFolder+name+".jpg"));
				//Save photo
			} catch (IOException e) {
				e.printStackTrace();
			}
			//ImageConverter process = new ImageConverter(image);
			//updateObserver();
		}



	public BufferedImage getImage() {
		return image;
	}


	public void setImage(BufferedImage image) {
		this.image = image;
	}


	public BufferedImage getResult() {
		return result;
	}


	public void setResult(BufferedImage result) {
		this.result = result;
	}


	@Override
	public void addObserver(MyObserver obs) {
		obsList.add(obs);
		
	}


	@Override
	public void updateObserver() {
		for(int i=0;i<obsList.size();i++){
			obsList.get(i).update();
		}
		
	}

	
}
