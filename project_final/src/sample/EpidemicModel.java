package sample;
import javafx.application.Platform;
import javafx.scene.paint.Color;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *Concrete Model class that is also Mediator Class for individuals
 * and also Subject Class for Observers.
 */
public class EpidemicModel implements ModelInterface{
    /**
     * List of observers.
     */
    ArrayList observers = new ArrayList();

    /**
     * List of all individuals.
     */
    private List<Individual> individuals= new ArrayList<>();

    /**
     * List of threads.
     */
    List<Thread> threads = new ArrayList<>();

    /**
     * infected person number
     */
    private AtomicInteger infectedNum = new AtomicInteger(0);
    /**
     * Healthy person number
     */
    private AtomicInteger  healthyNum = new AtomicInteger(0);
    /**
     * Dead person number
     */
    private AtomicInteger  deathNum = new  AtomicInteger(0);
    /**
     * Hospitalized person number
     */
    private AtomicInteger  hospitalizedNum = new  AtomicInteger(0);

    /**
     * Lock object
     */
    private static final Object lock = new Object();
    /**
     * Timer object.
     */
    Timer t = new Timer( );
    /**
     * Flag for first infected person.
     */
    int flag=0;

    /**
     * Counters for graphical plots.
     */
    private static int maskCounter=0;
    private static int noMask=0;
    private static double averageDistance=0;

    private AtomicInteger printFlag=new AtomicInteger(0);

    /**
     * Creating an individual with constant random spreading factor and mortality rate.
     * @param index is index of individual.
     * @param spreadingFactor is spreading factor of illness.
     * @param mortalityRate is mortality rate.
     * @return created individual.
     */
    public Individual createIndividual(int index,double spreadingFactor,double mortalityRate){
        Random random=new Random();
        double wear_mask=0.2;
        double not_wearMask=0.1;
        double mask_case = random.nextBoolean() ? wear_mask : not_wearMask;
        if(mask_case==0.2){
            maskCounter++;
        }
        else if(mask_case==0.1){
            noMask++;
        }
        double speed = 1.0 + (double) (Math.random() * (500.0 - 1.0));
        double social_distance= 0.0 + (double) (Math.random() * 9.0);

        averageDistance = averageDistance + social_distance;
        double waitingTime=1.0 + (double) (Math.random() * (5.0 - 1.0));


        double positionX = 0.0 + (double) (Math.random() * 995.0);
        double positionY= 0.0 + (double) (Math.random() * 595.0);

        Individual individual=new Individual(index,positionX,positionY,mask_case,speed,
                social_distance,waitingTime,spreadingFactor,mortalityRate,this);

        return individual;
    }

    /**
     * Setting timer for sending information in every second.
     */
    public void setTimer(){
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    notifyForPrintInfos();
                });
            }
        }, 0,1000);
    }

    /**
     * Starting individuals.
     * @param population is population number Po.
     */
    public void startIndividuals(int population) {
        double spreadingFactor= 0.5 + (double) (Math.random() * (1.0 - 0.5) );
        double mortalityRate= 0.1 + (double) (Math.random() * (0.9 - 0.1) );

        int infectedPerson=-1;
        setTimer();
        if(flag==0) {
            Random r = new Random();
            infectedPerson = r.nextInt(population);
        }
        for(int i=0;i<population;i++) {
            Individual person=null;
            if(flag==0) {
                person = createIndividual(i, spreadingFactor, mortalityRate);
                person.setInfected(true);
                infectedNum.getAndIncrement();
                flag=1;
                individuals.add(person);
                positionChanged(i,person.getCoordinateX(),person.getCoordinateY(),Color.RED);
            }
            else {
                person = createIndividual(i, spreadingFactor, mortalityRate);
                person.setHealthy(true);
                healthyNum.getAndIncrement();
                individuals.add(person);
                positionChanged(i,person.getCoordinateX(),person.getCoordinateY(),Color.GREEN);

            }
            //starting threads.
            Thread thread = new Thread(person);
            threads.add(thread);
            thread.start();
        }
        /*System.out.println("P,Z,R,D,Total_MaskUse,Total_NoMaskUse");
        System.out.println(population + ","+ mortalityRate+ ","+ spreadingFactor +"," + (double)averageDistance/population + "," +
                maskCounter +"," + noMask);
        System.out.println("Healthy,Infected");*/
    }

    /**
     * When continue button clicked,all threads are resumed.
     */
    public void continueOperation(){
        synchronized (this) {
            System.out.println("CONTINUE:");
            for (int i = 0; i < threads.size(); i++) {
                threads.get(i).resume();
            }
        }
    }
    /**
     * When pause button clicked,all threads are suspended.
     */
    public void pauseOperation(){
        synchronized (this) {
            System.out.println("PAUSE OPERATION:");
            for (int i = 0; i < threads.size(); i++) {
                threads.get(i).suspend();
            }
        }
    }

    /**
     * This method for controlling collision occurring.
     * @param index is index of individual.
     * @param coordinateX is position x of individual.
     * @param coordinateY is position y of individual.
     * @return collision result.
     */
    public boolean controlCollision(int index,double coordinateX,double coordinateY){
            synchronized (lock) {
                Iterator<Individual> iterator = individuals.iterator();
                while (iterator.hasNext()) {
                    Individual curr = iterator.next();
                    if (curr.getIndex() != index) {
                        double x1 = curr.getCoordinateX();
                        double y1 = curr.getCoordinateY();
                        if ((coordinateX < (x1 + 5) )&& ((coordinateX + 5) > x1) &&
                                (coordinateY < (y1 + 5) )&&( (coordinateY + 5) > y1)) {
                            if (individuals.get(index).isInfected() && !curr.isInfected())
                                probabilityInfecting(individuals.get(index), curr);
                            else if (curr.isInfected() && !individuals.get(index).isInfected())
                                probabilityInfecting(curr, individuals.get(index));
                            return true;
                        }
                    }
                }
                return false;
            }
    }

    /**
     * Register observer.
     * @param o is view object that is observer.
     */
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Removing observer.
     * @param o is view object that is observer.
     */
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * Calculating probability of infecting.
     * @param a is first individual
     * @param b is second individual
     */
    public void probabilityInfecting(Individual a,Individual b){
            double C_max = Math.max(a.getSpeed(), b.getSpeed());
            double D_min = Math.min(a.getSocialDistance(), b.getSocialDistance());
            double prob = Math.min((a.getSpreadingFactor() * (1 + (C_max / 10)) * a.getMaskCase() * b.getMaskCase() * (1 - (D_min / 10))), 1);
            if (prob >= 0.5) {
                b.setInfected(true);
                b.setHealthy(false);
                b.setDead(false);
                infectedNum.getAndIncrement();
                healthyNum.getAndDecrement();
                b.setProbability(prob);
            }
          /*  try {
                Thread.sleep((long) C_max);
            } catch (InterruptedException e) {
                System.out.println(e);
            }*/
    }

    /**
     * Notifying observers for up to date information.
     */
    public void notifyForPrintInfos(){
        for (int i = 0; i < observers.size(); i++) {
            EpidemicView observer = (EpidemicView) observers.get(i);
            String string="Healthy Number: " + getNum(1)  + " \nInfected Number: " + getNum(0)
                    + " \nDead Number: " + getNum(2) + " \nHospitalized Number: " + hospitalizedNum.get();
            //System.out.println(string);
            observer.updateToPrint(string);
        }
    }

    /**
     * Notifying observers for drawing individual with new positions
     * or removing individual in previous position.
     * @param index is index of individual
     * @param x is coordinate x
     * @param y is coordinate y
     * @param drawOrRemove whether drawing or removing individual
     * @param color is color.
     */
    public void notifyObservers(int index, double x, double y, int drawOrRemove, Color color) {
        for (int i = 0; i < observers.size(); i++) {
            EpidemicView observer = (EpidemicView) observers.get(i);
            observer.update(x,y,drawOrRemove,color);
        }
        if(drawOrRemove==1) {
            boolean collisionRes=controlCollision(index, x, y);
        }
    }

    /**
     * Deleting person in previous position with notifying observers.
     * @param index is individual index.
     * @param x is coordinate x.
     * @param y is coordinate y.
     * @param color is color.
     */
    public void deletingPrevPos(int index,double x,double y,Color color) {
        notifyObservers(index,x,y,0,color);
    }

    /**
     *Drawing person in new position with notifying observers.
     * @param index is individual index.
     * @param x is coordinate x.
     * @param y is coordinate y.
     * @param color is color.
     */
    public void positionChanged(int index,double x,double y,Color color) {
        notifyObservers(index,x,y,1,color);
    }

    /**
     * Getting number of given state individuals.
     * @param state is state.
     * @return number of person with given state.
     */
    private int getNum(int state){
        int infected=0;
        int healthy=0;
        int dead=0;
        for(int i=0;i<individuals.size();i++){
            if(state==0 && individuals.get(i).isInfected()){
                infected++;
            }
            else if(state==1 && individuals.get(i).isHealthy()){
                healthy++;
            }
            else if(state==2 && individuals.get(i).isDead()){
                dead++;
            }
        }
        switch (state){
            case 0:
                return infected;
            case 1:
                return healthy;
            case 2 :
                return dead;
            default:
                return 0;
        }
    }

    /**
     * Getting individual list.
     * @return list of individuals.
     */
    public List<Individual> individuals(){
        return individuals;
    }


}