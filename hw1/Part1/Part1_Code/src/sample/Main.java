/**
 * @author  Nevra Gürses
 * @version 1.0
 * @since   2020-11-22
 */


package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for starting and testing project.
 */
public class Main extends Application {
    /**
     * Method for starting interface.
     * @param primaryStage for starting interface.
     * @throws Exception for throwing exception.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 500, 375)); //Setting interface.
        primaryStage.show(); //show function.
    }

    /**
     * main method.
     * @param args is arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
