package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    private static Stage stg;
    
    @Override
    public void start(Stage stage) throws Exception{
            stg = stage;
            // Starting Screen (Change fxml to start on any screen)
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml")); 
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.setTitle("Bookstore App");
            stage.setResizable(false);
            stage.show();
    }
    
    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene2 = new Scene(pane);
        stg.setScene(scene2);
        stg.setResizable(false);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
