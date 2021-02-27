/**
 * Subject interface.
 */
public interface Subject {
    /**
     *Registering an observer.
     * @param observer is observer.
     */
    public void registerObserver(Observer observer);

    /**
     *Removing observer.
     * @param observer is observer
     */
    public void removeObserver(Observer observer);

    /**
     *notifying observers.
     * @param arg is content type.
     * @param changing  setting value of content.
     */
    public void notifyObservers(Contents arg, Object changing);
}
