import java.util.ArrayList;

/**
 * Concrete observer class that implements Observer and Display interfaces.
 */
public class Subscriber implements Observer,Display{
    private Subject observable; //association with Subject.
    private Contents content; //keeping content.
    protected ArrayList<Demands> demands; //keeping desired content names in arraylist.

    /**
     * Constructor that initializes instance variables.
     * @param observable is Subject.
     * @param demands list of desired contents.
     */
    public Subscriber(Subject observable, ArrayList<Demands> demands) {
        this.demands=demands;
        this.observable = observable;
        observable.registerObserver(this);
    }

    /**
     * Update method.
     * @param object is content type
     * @param arg setting value of content.
     */
    @Override
    public void update(Object object,Object arg) {
        if (object instanceof Contents ) {
            System.out.println("Update function is working Subscriber that has all desired contents: " + demands);
            content=(Contents)object;
            content.set(arg); //Setting content.
            display();
        }
    }

    /**
     * Controlling observer whether that observer is desiring given content or not.
     * @param demand is content type.
     * @return whether that observer is desiring given content or not
     */
    @Override
    public boolean isContain(Demands demand) {
        if(demands.contains(demand)){
            return true;
        }
        return false;
    }

    /**
     * Display method
     */
    @Override
    public void display() {
        System.out.println("Display function of subscriber.");
    }
}
