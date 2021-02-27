package sample;
import javafx.stage.Stage;

/**
 * Concrete Controller Class.
 */
public class EpidemicController implements ControllerInterface {
    /**
     * Reference for model.
     */
    ModelInterface model;
    /**
     * Reference for view.
     */
    EpidemicView view;

    /**
     * Constructor of controller.
     * @param model is given model.
     * @param primaryStage is stage.
     */
    public EpidemicController(ModelInterface model, Stage primaryStage){
        this.model=model;
        this.view=new EpidemicView(primaryStage,model,this);
        this.view.initScreen();

    }

    /**
     * Calling method of model for creating people with given population.
     * @param population is population number.
     */
    public void start(int population) {
        model.startIndividuals(population);
    }

    /**
     * Calling method of model for continue operation.
     */
    public void continueOperation(){
        model.continueOperation();
    }

    /**
     * Calling method of model for pause operation.
     */
    public void pauseOperation(){
        model.pauseOperation();
    }

}

