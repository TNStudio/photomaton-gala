package application.view;

import java.util.Timer;
import java.util.TimerTask;

import observerPattern.MyObserver;
import application.Main;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class MainInterfaceController{
	
	private Main main;
	
	@FXML
	private ImageView imageView;
	
	@FXML
	private void initialize(){
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
					try {
						//System.out.println("refresh");
						update();
					} catch (Exception e) {
						//e.printStackTrace();
					}
					}
				});
				
			}
		},0,1000);
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}


	public void update() {
		//System.out.println("updating");
		imageView.setImage(SwingFXUtils.toFXImage(main.getModele().getResult(), null));
		imageView.setFitHeight(main.getPrimaryScreenBounds().getHeight());
		imageView.setFitWidth(main.getPrimaryScreenBounds().getWidth());
		//imageView.setX((main.getPrimaryScreenBounds().getWidth()-imageView.getFitWidth())/2);
		
	}
	
	

}
