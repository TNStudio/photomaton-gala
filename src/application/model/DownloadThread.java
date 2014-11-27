package application.model;

import java.io.File;

import edsdk.utils.CanonCamera;
import edsdk.utils.commands.DownloadTask;

public class DownloadThread implements Runnable{
	
	private CanonCamera slr;
	private Thread t;
	private File photoFolder;
	private File photoFile;
	private Modele modele;
	private int photo_number;
	private String photo_name;

	public DownloadThread(Modele modele, CanonCamera slr, String photoFolder) {
		this.slr=slr;
		this.photoFolder = new File(photoFolder);
		this.modele = modele;
		t = new Thread(this);
		t.run();
	}
	
	@Override
	public void run() {
		while(true){
			photo_number =  photoFolder.list().length+1;
			photo_name = photoFolder.getPath()+"\\photo"+photo_number+".jpg";
			 String photo_name_string = "\\photo"+photo_number;
			photoFile = new File(photo_name);
			DownloadTask task = new DownloadTask(photoFile);
			slr.executeNow(task);
			modele.MyUpdate(photoFile, photo_name_string);
		}
	}

	public File getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(File photoFile) {
		this.photoFile = photoFile;
	}

	public int getPhoto_number() {
		return photo_number;
	}

	public void setPhoto_number(int photo_number) {
		this.photo_number = photo_number;
	}

	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	
	

}
