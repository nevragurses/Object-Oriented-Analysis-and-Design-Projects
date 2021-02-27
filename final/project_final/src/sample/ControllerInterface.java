package sample;

/**
 * Controller interface.It contains all methods
 * that View can call on the controller.
 */
public interface ControllerInterface {
    /**
     * Creating individuals.
     * @param population is population number.
     */
    public void start(int population);

    /**
     * Operation for click continue button.
     */
    public void continueOperation();

    /**
     * Operation for click pause button.
     */
    public void pauseOperation();
}
