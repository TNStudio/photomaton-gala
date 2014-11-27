package application.view;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class MainInterfaceController {
	
	private Main main;
	
	@FXML
	private ImageView imageView;
	
	@FXML
	private void initialize(){
		
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	

}
