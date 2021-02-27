/**
 * Concrete Green Light state class that implements State interface.
 */
public class GreenLightState implements State{
    /**
     * Instance variable of Traffic Light class.
     */
    TrafficLight trafficLight;
    /**
     * Constructor.
     * @param trafficLight is object of Traffic Light class.
     */
    public GreenLightState(TrafficLight trafficLight){
        this.trafficLight=trafficLight;
    }
    /**
     * Transition yellow light after green light.
     */
    @Override
    public void transitionYellow(double timeout) {
        System.out.println("Traffic light switched to YELLOW after "+ (int)timeout +" seconds.");
        trafficLight.setState(trafficLight.getYellowRightState());
    }
    /**
     * Prints error message.Transition red light after green light can not be done.
     */
    @Override
    public void transitionRed() {
        System.out.println("Error,You can't switch red light after green light.");
    }
    /**
     * Prints error message.Transition green light after green light can not be done.
     */
    @Override
    public void transitionGreen() {
        System.out.println("Error,You can't switch green light after green light.");
    }
    /**
     * Displaying current state.
     */
    @Override
    public void displayCurrentState() {
        System.out.println("Current state is GREEN.");
    }
}
