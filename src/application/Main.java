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

	
	public Main() {

		modele = new Modele();
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("view/SettingsInterface.fxml"));
			AnchorPane rootPane = fxmlLoader.load();
			MainInterfaceController interfaceController = fxmlLoader.getController();
			interfaceController.setMain(this);
			Scene scene = new Scene(rootPane);
			primaryStage.initStyle(StageStyle.UNDECORATED); //set it undecorated
			Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds(); //create a rectangle that fit the main screen
			primaryStage.setX(primaryScreenBounds.getMinX());//put the fisrt window at the origin of the screen
			primaryStage.setY(primaryScreenBounds.getMinY());//see above
			primaryStage.setWidth(primaryScreenBounds.getWidth()); //fit the window to the size of the screen
			primaryStage.setHeight(primaryScreenBounds.getHeight());//see above
			primaryStage.setOnHiding(new EventHandler<WindowEvent>() { //set a always on top

				@Override
				public void handle(WindowEvent arg0) {
					primaryStage.show(); //show the window when is asked to hide

				}
			});
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
