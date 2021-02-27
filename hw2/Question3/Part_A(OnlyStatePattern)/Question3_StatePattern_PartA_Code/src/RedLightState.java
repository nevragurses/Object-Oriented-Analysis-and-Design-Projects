/**
 * Concrete Red Light state class that implements State interface.
 */
public class RedLightState implements  State {
    /**
     * Instance variable of Traffic Light class.
     */
    TrafficLight trafficLight;
    /**
     * Constructor.
     * @param trafficLight is object of Traffic Light class.
     */
    public RedLightState(TrafficLight trafficLight){
        this.trafficLight=trafficLight;
    }
    /**
     * Transition green light after red light.
     */
    @Override
    public void transitionGreen() {
        System.out.println("Traffic light switched to GREEN after 15 seconds.");
        trafficLight.setState(trafficLight.getGreenLightState());
    }
    /**
     * Prints error message.Transition red light after red light can not be done.
     */
    @Override
    public void transitionRed() {
        System.out.println("Error,You can't switch red light after red light.");
    }
    /**
     * Prints error message.Transition yellow light after red light can not be done.
     */
    @Override
    public void transitionYellow(double timeout) {
        System.out.println("Error,You can't switch yellow light after red light.");
    }

    /**
     * Displaying current state.
     */
    @Override
    public void displayCurrentState() {
        System.out.println("Current state is RED.");
    }
}
