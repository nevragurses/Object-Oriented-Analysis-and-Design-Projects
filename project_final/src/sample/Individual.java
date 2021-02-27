package sample;
import javafx.application.Platform;
import javafx.scene.paint.Color;

/**
 * Individual Class that implements Runnable.
 */
public class  Individual implements Runnable {
    /**
     * Reference for model that is mediator class.
     */
    EpidemicModel epidemicModel;
    /**
     * Reference for color class.
     */
    private Colors color;
    /**
     * Belows are features of an individual.
     */
    private double maskCase;
    private double speed;
    private double socialDistance;
    private double waitingTime;
    private double spreadingFactor;
    private double mortalityRate;
    private double probability;
    private double coordinateX;
    private double coordinateY;
    private double lastX;
    private double lastY;
    private boolean isDead;
    private boolean isInfected;
    private boolean isHealthy;
    private boolean exit=false;
    private int index;

    /**
     * Constructor for individual.
     * @param index is index of individual
     * @param x is coordinate x
     * @param y is coordinate y
     * @param maskCase is mask case
     * @param speed is speed
     * @param socialDistance is social distance
     * @param waitingTime is waiting time when collision occur
     * @param spreadingFactor is spreading factor
     * @param mortalityRate is mortality rate
     * @param epidemicModel is model
     */
    public Individual(int index, double x, double y , double maskCase, double speed, double socialDistance, double waitingTime,
                      double spreadingFactor, double mortalityRate, EpidemicModel epidemicModel){

        this.coordinateX=x;
        this.coordinateY=y;
        this.epidemicModel = epidemicModel;
        this.maskCase=maskCase;
        this.speed=speed;
        this.socialDistance=socialDistance;
        this.waitingTime=waitingTime;
        this.spreadingFactor=spreadingFactor;
        this.mortalityRate=mortalityRate;
        this.index=index;
        this.isDead=false;
        this.color=new Colors();
    }

    /**
     * Printing person information.
     */
    public void getPersonInfo(){
        System.out.println("Position x: " + coordinateX);
        System.out.println("Position y: " + coordinateY);
        System.out.println("Mask case: " + maskCase);
        System.out.println("Speed: " + speed);
        System.out.println("Social Distance: " + socialDistance);
        System.out.println("Waiting time: " + waitingTime);
        System.out.println("Constant Spreading factor: " + spreadingFactor);
        System.out.println("Constant Mortality Rate: " + mortalityRate);
    }

    /**
     * Stopping thread.
     */
    public void stopThread()
    {
        this.exit = true;
    }

    /**
     * Moving an individual one position to new random position using model class method.
     * @param newPositionX is new x position.
     * @param newPositionY is new y position.
     */
    public void moving(double newPositionX, double newPositionY) {
        setLastX(this.getCoordinateX());
        setLastY(this.getCoordinateY());
        //using model method for notify observers about deleting previous position of person.
        epidemicModel.deletingPrevPos(this.getIndex(),this.getCoordinateX(),this.getCoordinateY(),color.getColor());
        this.setCoordinate(newPositionX, newPositionY);
    }

    /**
     * Finding sleep time by using way/time formula.
     * @return sleep time.
     */
    private long findTime(){
        long sleepTime = (long)(((Math.sqrt(Math.pow(getCoordinateY() - getLastY(), 2) + Math.pow(getCoordinateX() - getLastX(), 2))) / speed) * 1000);
        return sleepTime;
    }

    /**
     * Run method for thread because every individual is a thread.
     */
    public void run() {

        //Sleeping before changing first position.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        while (true) {
            Platform.runLater(() -> {
                double newX = 0.0 + (double) (Math.random() * 995.0);
                double newY = 0.0 + (double) (Math.random() * 595.0);
                this.moving(newX, newY);
                //using model method for notify observers about position changed.
                epidemicModel.positionChanged(this.getIndex(), newX, newY,color.getColor());
            });
            try {

                Thread.sleep(findTime());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Setting coordinates.
     * @param x is x coordinate.
     * @param y is y coordinate.
     */
    public void setCoordinate(double x, double y) {
        coordinateX=x;
        coordinateY=y;
    }

    /**
     * Returns whether individual is healthy or not.
     * @return true if healthy, false if not healthy.
     */
    public boolean isHealthy() {
        return isHealthy;
    }

    /**
     * Setting healthy case of individual
     * @param healthy is healthy case.
     */
    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
        if(healthy)
            this.color.setColor(Color.GREEN);
    }
    /**
     * Returns whether individual is infected or not.
     * @return true if infected, false if not infected.
     */
    public boolean isInfected() {
        return isInfected;
    }
    /**
     * Setting infected case of individual
     * @param infected is infected case.
     */
    public void setInfected(boolean infected) {
        isInfected = infected;
        if(infected)
            this.color.setColor(Color.RED);
    }
    /**
     * Returns whether individual is dead or not.
     * @return true if dead, false if not dead.
     */
    public boolean isDead() {
        return isDead;
    }
    /**
     * Setting dead case of individual
     * @param dead is dead case.
     */
    public void setDead(boolean dead) {
        this.isDead = dead;

    }

    /**
     * Getting model class
     * @return model class.
     */
    public EpidemicModel getModel() {
        return epidemicModel;
    }

    /**
     * Setting model class.
     * @param epidemicModel is model class.
     */
    public void setModel(EpidemicModel epidemicModel) {
        this.epidemicModel = epidemicModel;
    }

    /**
     * Getting mask case.
     * @return mask case.
     */
    public double getMaskCase() {
        return maskCase;
    }

    /**
     * Setting mask case
     * @param maskCase is mask case.
     */
    public void setMaskCase(double maskCase) {
        this.maskCase = maskCase;
    }

    /**
     * Getting speed.
     * @return speed.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Setting speed.
     * @param speed is speed.
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }


    /**
     * Getting last position x.
     * @return last position x.
     */
    public double getLastX() {
        return lastX;
    }

    /**
     * Setting last position x.
     * @param lastX is last position x.
     */
    public void setLastX(double lastX) {
        this.lastX = lastX;
    }
    /**
     * Getting last position y.
     * @return last position y.
     */
    public double getLastY() {
        return lastY;
    }
    /**
     * Setting last position y.
     * @param lastY is last position y.
     */
    public void setLastY(double lastY) {
        this.lastY = lastY;
    }
    /**
     * Getting social distance.
     * @return social distance.
     */
    public double getSocialDistance() {
        return socialDistance;
    }

    /**
     * Setting social distance.
     * @param socialDistance is social distance.
     */
    public void setSocialDistance(double socialDistance) {
        this.socialDistance = socialDistance;
    }

    /**
     * Getting waiting time when collision occurs.
     * @return waiting time.
     */
    public double getWaitingTime() {
        return waitingTime;
    }

    /**
     * Setting waiting time when collision occurs.
     * @param waitingTime is waiting time.
     */
    public void setWaitingTime(double waitingTime) {
        this.waitingTime = waitingTime;
    }

    /**
     * Getting probability of infecting.
     * @return probability of infecting.
     */
    public double getProbability() {
        return probability;
    }

    /**
     * Setting probability of infecting.
     * @param probability is probability of infecting.
     */
    public void setProbability(double probability) {
        this.probability = probability;
    }

    /**
     * Getting spreading factor of illness.
     * @return spreading factor.
     */
    public double getSpreadingFactor() {
        return spreadingFactor;
    }

    /**
     * Setting spreading factor.
     * @param spreadingFactor is spreading factor.
     */
    public void setSpreadingFactor(double spreadingFactor) {
        this.spreadingFactor = spreadingFactor;
    }

    /**
     * Getting mortality rate.
     * @return mortality rate.
     */
    public double getMortalityRate() {
        return mortalityRate;
    }

    /**
     * Setting mortality rate.
     * @param mortalityRate is mortality rate.
     */
    public void setMortalityRate(double mortalityRate) {
        this.mortalityRate = mortalityRate;
    }

    /**
     * Getting coordinate x.
     * @return coordinate x.
     */
    public double getCoordinateX() {
        return  coordinateX;
    }
    /**
     * Setting Coordinate x.
     * @param coordinateX  is coordinate y.
     */
    public void setCoordinateX(double coordinateX){
        this.coordinateX=coordinateX;
    }
    /**
     * Getting Coordinate y.
     * @return coordinate y
     */
    public double getCoordinateY() {
        return coordinateY;
    }

    /**
     * Setting Coordinate y.
     * @param coordinateY  is coordinate y.
     */
    public void setCoordinateY(double coordinateY){
        this.coordinateY=coordinateY;
    }
    /**
     * Getting index of individual
     * @return index of individual
     */
    public int getIndex() {
        return  index;
    }

    /**
     * Getting color.
     * @return color.
     */
    public Colors getColor() {
        return color;
    }

    /**
     * Setting color.
     * @param color is color.
     */
    public void setColor(Colors color) {
        this.color = color;
    }


}