package sample;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main Class.
 */
public class Main  extends Application {
    public Stage primaryStage;

    /**
     * Starting method.
     * @param primaryStage is primary stage.
     * @throws Exception is exception.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("");
        EpidemicModel epidemicModel = new EpidemicModel();
        EpidemicController epidemicController =new EpidemicController(epidemicModel,primaryStage);

    }

    /**
     * Static main method.
     * @param args is arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
