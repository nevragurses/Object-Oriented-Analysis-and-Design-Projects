package sample;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

/**
 * View Class that is also concrete Observer Class.
 */
public class EpidemicView implements Observer {
    /**
     * Reference for Model.
     */
    ModelInterface model ;
    /**
     * Reference for controller.
     */
    ControllerInterface controller;

    /**
     * Belows are display components.
     */
    Stage primaryStage;
    GraphicsContext graphicsContext;
    Canvas canvas;
    Label textField;
    TextField numberOfPeople;
    Label group;
    Label only;
    Label information;
    Label informationResults;
    Button startButton;
    Button addOne;
    Button pauseButton;
    Button continueButton;
    /**
     * Constructor.
     * @param primaryStage is stage.
     */
    public EpidemicView(Stage primaryStage){
        this.primaryStage=primaryStage;
        initScreen();
    }
    /**
     * Constructor.
     * @param primaryStage is stage.
     * @param model is given model.
     * @param controller is given controller.
     */
    public EpidemicView(Stage primaryStage, ModelInterface model, ControllerInterface controller){
        this.primaryStage=primaryStage;
        this.controller=controller;
        this.model=model;
        this.model.registerObserver(this);
    }

    /**
     * Creating view.
     */
    public void initScreen(){
        primaryStage.setTitle("Visual simulation of an Epidemic within a Human Society");

        //Root pane.
        AnchorPane root = new AnchorPane();
        root.setLayoutX(0.0);
        root.setLayoutY(0.0);
        root.setMaxWidth(3000.0);
        root.setMaxHeight(1000);

        //pane for canvas.
        AnchorPane inner=new AnchorPane();
        inner.setLayoutX(0.0);
        inner.setLayoutY(0.0);
        canvas = new Canvas(1000.0, 600.0);
        inner.setStyle("-fx-background-color:BLACK");
        graphicsContext=canvas.getGraphicsContext2D();
        inner.getChildren().add(canvas);

        //pane for information and buttons section.
        AnchorPane inner2 = new AnchorPane();
        inner2.setLayoutX(1010.0);
        inner2.setLayoutY(100.0);
        inner2.setMaxHeight(200.0);


        group=new Label("Add Individual as Group");
        group.setLayoutX(50.0);
        group.setPrefWidth(150.0);

        textField=new Label("Population(Po) Number:");
        textField.setLayoutY(20);
        textField.setPrefWidth(130.0);


        numberOfPeople=new TextField();
        numberOfPeople.setLayoutX(140.0);
        numberOfPeople.setLayoutY(20);
        numberOfPeople.setPrefWidth(100.0);
        numberOfPeople.setEditable(true);

        only=new Label("Add One Individual");
        only.setLayoutX(50.0);
        only.setLayoutY(50.0);
        only.setPrefWidth(150.0);

        addOne=new Button("Adding One Person");
        addOne.setLayoutX(50.0);
        addOne.setLayoutY(70.0);
        addOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.start(1);
            }
        });
        startButton=new Button("Start");
        startButton.setLayoutY(110.0);
        startButton.setPrefWidth(60.0);
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!numberOfPeople.getText().equals("")) {
                    controller.start(Integer.parseInt(numberOfPeople.getText()));
                }
            }
        });
        pauseButton=new Button("Pause");
        pauseButton.setLayoutX(70.0);
        pauseButton.setPrefWidth(60.0);
        pauseButton.setLayoutY(110.0);
        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.pauseOperation();
            }
        });

        continueButton=new Button("Continue");
        continueButton.setLayoutX(140.0);
        continueButton.setLayoutY(110.0);
        continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.continueOperation();
            }
        });

        information=new Label("~~~~Informations ~~~~");
        information.setLayoutX(40.0);
        information.setLayoutY(160.0);

        informationResults=new Label();
        informationResults.setLayoutY(180.0);




        inner2.getChildren().addAll(startButton,textField,numberOfPeople,
                addOne,group,only,pauseButton,continueButton,information,informationResults);

        root.getChildren().addAll(inner,inner2);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    /**
     *The updateToPrint method called every second  via model.
     * The total count of infected, healthy, hospitalized and dead numbers are shown on canvas.
     * @param string is information.
     */
    public void updateToPrint(String string){
        informationResults.setText(string);
    }

    /**
     *The update method called when state change occur in model.
     * When position change occurred, person is drown with using drawPerson method on new position.
     * If previous location should be deleted,we delete previous location with removePerson method.
     * @param x is coordinate x.
     * @param y is coordinate y.
     * @param drawOrRemove is whether person will drawing or deleting.
     * @param color is color.
     */
    public void update(double x, double y,int drawOrRemove,Color color){
        if(drawOrRemove==1)
            drawPerson(x,y,color);
        else
            removePerson(x,y);
    }

    /**
     * Remove person that with given position on canvas.
     * @param x is coordinate x.
     * @param y is coordinate y.
     */
    public void removePerson(double x,double y){
        synchronized (this) {
            graphicsContext.clearRect(x, y, 5, 5);
            graphicsContext.stroke();
        }
    }

    /**
     * Drawing person with given position and given color.
     * @param posX is coordinate x.
     * @param posY is coordinate y.
     * @param color is color of person.
     */
    public void drawPerson(double posX, double posY, Color color) {
        synchronized (this) {
            graphicsContext.setFill(color);
            graphicsContext.fillRect(posX, posY, 5, 5);

        }
    }
}
