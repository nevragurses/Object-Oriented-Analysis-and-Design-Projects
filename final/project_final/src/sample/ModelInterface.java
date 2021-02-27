package sample;

import javafx.scene.paint.Color;
/**
 *Model Interface that is also Mediator Interface for individuals
 * and also Subject Interface for Observers.
 */
public interface ModelInterface {

    /**
     * Starting individuals.
     * @param population is population number Po
     */
    public void startIndividuals(int population);
    /**
     * When continue button clicked,all threads are resumed.
     */
    public void continueOperation();
    /**
     * When pause button clicked,all threads are suspended.
     */
    public void pauseOperation();
    /**
     * Register observer.
     * @param o is view object that is observer.
     */
    public void registerObserver(Observer o);

    /**
     * Removing observer.
     * @param o is view object that is observer.
     */
    public void removeObserver(Observer o);
    /**
     * Notifying observers for up to date information.
     */
    public void notifyForPrintInfos();

    /**
     * Notifying observers for drawing individual with new positions or removing individual previous position.
     * @param index is index of individual
     * @param x is coordinate x
     * @param y is coordinate y
     * @param drawOrRemove whether drawing or removing individual
     * @param color is color.
     */
    public void notifyObservers(int index, double x, double y, int drawOrRemove, Color color);


}
