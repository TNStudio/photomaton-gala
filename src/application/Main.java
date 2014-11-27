package application;
	
import application.model.Modele;
import application.view.MainInterfaceController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Modele modele;
	
	private Rectangle2D primaryScreenBounds;

	
	public Main() {

		modele = new Modele();
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("view/MainInterface.fxml"));
			AnchorPane rootPane = fxmlLoader.load();
			MainInterfaceController interfaceController = fxmlLoader.getController();
			interfaceController.setMain(this);
			Scene scene = new Scene(rootPane);
			primaryStage.initStyle(StageStyle.UNDECORATED); //set it undecorated
			primaryScreenBounds = Screen.getPrimary().getVisualBounds(); //create a rectangle that fit the main screen
			//primaryStage.setX(primaryScreenBounds.getMinX());//put the fisrt window at the origin of the screen
			//primaryStage.setY(primaryScreenBounds.getMinY());//see above
			//primaryStage.setWidth(primaryScreenBounds.getWidth()); //fit the window to the size of the screen
			//primaryStage.setHeight(primaryScreenBounds.getHeight());//see above
			primaryStage.setFullScreen(true);
			primaryStage.setOnHiding(new EventHandler<WindowEvent>() { //set a always on top

				@Override
				public void handle(WindowEvent arg0) {
					primaryStage.show(); //show the window when is asked to hide

				}
			});
			primaryStage.setScene(scene);
			primaryStage.show();
			//modele = new Modele();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public Rectangle2D getPrimaryScreenBounds() {
		return primaryScreenBounds;
	}

	public void setPrimaryScreenBounds(Rectangle2D primaryScreenBounds) {
		this.primaryScreenBounds = primaryScreenBounds;
	}
	
	
}
