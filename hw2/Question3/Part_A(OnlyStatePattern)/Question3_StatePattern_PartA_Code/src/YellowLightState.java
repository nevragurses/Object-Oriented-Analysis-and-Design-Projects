/**
 * Concrete Yellow Light state class that implements State interface.
 */
public class YellowLightState implements State{
    /**
     * Instance variable of Traffic Light class.
     */
    TrafficLight trafficLight;

    /**
     * Constructor.
     * @param trafficLight is object of Traffic Light class.
     */
    public YellowLightState(TrafficLight trafficLight){
        this.trafficLight=trafficLight;
    }

    /**
     * Transition red light after yellow light.
     */
    @Override
    public void transitionRed() {
        System.out.println("Traffic light switched to RED after 3 seconds.");
        trafficLight.setState(trafficLight.getRedLightState());
    }
    /**
     * Prints error message.Transition yellow light after yellow light can not be done.
     */
    @Override
    public void transitionYellow(double timeout) {
        System.out.println("Error,You can't switch yellow light after yellow light.");
    }
    /**
     * Prints error message.Transition green light after yellow light can not be done.
     */
    @Override
    public void transitionGreen() {
        System.out.println("Error,You can't switch green light after yellow light.");
    }

    /**
     * Displaying current state.
     */
    @Override
    public void displayCurrentState() {
        System.out.println("Current state is YELLOW.");
    }
}
