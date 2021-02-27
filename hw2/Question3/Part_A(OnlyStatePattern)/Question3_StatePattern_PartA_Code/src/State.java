/**
 * The State interface defines a common interface for all concrete states.
 */
public interface State {
    /**
     * Method for switching red light after yellow light.
     */
    public void transitionRed();

    /**
     * Method for switching yellow light after green light.
     * @param timeout is timeout.
     */
    public void transitionYellow(double timeout);
    /**
     * Method for switching green light after red light.
     */
    public void transitionGreen();

    /**
     * Displaying current traffic light color.
     */
    public void displayCurrentState();
}
