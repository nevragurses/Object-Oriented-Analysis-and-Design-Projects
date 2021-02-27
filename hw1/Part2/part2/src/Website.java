import java.util.*;

/**
 * Concrete subject class that implements Subject interface
 */
public  class Website implements Subject {
    private Demands updatedDemand; //keeping updating demand name.
    private ArrayList observers; //keeping observers.
    ArrayList<Observer> changingObservers;//keeping observers that notifying will occur.
    Contents content; //keeping content that update will occur.

    /**
     * Constructor.
     */
    public Website() {
        observers = new ArrayList(); //allocating area for observers in arraylist.
    }

    /**
     * Register observers in website
     * @param observer is observer.
     */
    public void registerObserver(Observer observer) {
        if (observer == null)
            throw new NullPointerException();
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * Removing observers from website
     * @param observer is observer
     */
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * Notifies specific observers if updated type is desired type for observer.
     * @param arg is content type.
     * @param changing  setting value of content.
     */
    public void notifyObservers(Contents arg,Object changing) {
        for (int i = 0; i <= changingObservers.size()-1; i++) {
            (changingObservers.get(i)).update(arg, changing); //update method is calling for specific observers.
        }
    }

    /**
     * Determining observers that notification will go.
     */
    protected synchronized void setChanged() {
        changingObservers=new ArrayList<>();
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            if(observer.isContain(updatedDemand)) { //if updated content is desired type for current observer.
                changingObservers.add(observer); //keep that observer in arraylist.
            }
        }
    }

    /**
     * Controlling observers with setChanged method and calling notifyObservers method
     * @param object  is content types.
     * @param changing is setting value.
     */
    public void updateOccured(Contents object,Object changing) {
        setChanged();
        notifyObservers(object,changing);
    }

    /**
     * Setting content with dynamic binding when update occurred.
     * @param object is content type.
     * @param changing is setting value.
     */
    public void setUpdates(Contents object,Object changing) {
        content=object;
        updatedDemand=content.getName();
        System.out.println("Güncelleme gelen içerik: "+ updatedDemand);
        content.set(changing); //setting content.
        updateOccured(object,changing);
    }
}
