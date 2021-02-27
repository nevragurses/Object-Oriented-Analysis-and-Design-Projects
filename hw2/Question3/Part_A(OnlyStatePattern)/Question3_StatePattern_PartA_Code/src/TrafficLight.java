/**
 * The Context class in State Design Pattern
 * that can have a number of internal states.
 */
public class TrafficLight {
    /**
     * Red light state.
     */
    State redLightState;
    /**
     * Green light state.
     */
    State greenLightState;
    /**
     * Yellow light state.
     */
    State yellowRightState;
    /**
     * Initial state.
     */
    State state;
    /**
     * Timeout.
     */
    double timeout;

    /**
     * Constructor.
     */
    public TrafficLight() {
        redLightState = new RedLightState(this);
        greenLightState = new GreenLightState(this);
        yellowRightState = new YellowLightState(this);
        state = redLightState;
        timeout=60;
    }
    /**
     * Calling transition red method of State class for switching red color.
     */
    public void transitionRed(){
        state.transitionRed();
    }
    /**
     * Calling transition green method of State class for switching green color.
     */
    public void transitionGreen(){
        state.transitionGreen();
    }
    /**
     * Calling transition yellow method of State class for switching yellow color.
     */
    public void transitionYellow(){
        state.transitionYellow(timeout);
    }

    /**
     * Setting state.
     * @param state is state.
     */
    void setState(State state) {
        this.state = state;
    }

    /**
     * Getting current state using displayCurrentState method of state class.
     */
    public void getCurrentState() {
        state.displayCurrentState();
    }

    /**
     * Getting red light state.
     * @return red light state.
     */
    public State getRedLightState() {
        return redLightState;
    }
    /**
     * Getting green light state.
     * @return green light state.
     */
    public State getGreenLightState() {
        return greenLightState;
    }
    /**
     * Getting yellow light state.
     * @return yellow light state.
     */
    public State getYellowRightState() {
        return yellowRightState;
    }
}
