/**
 * Main Class
 */
public class Main {
    /**
     * Static main method for testing.
     * @param args is arguments.
     */
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();


        trafficLight.getCurrentState();
        trafficLight.transitionGreen();

        trafficLight.getCurrentState();
        trafficLight.transitionYellow();

        trafficLight.getCurrentState();
        trafficLight.transitionRed();


        trafficLight.getCurrentState();
        trafficLight.transitionGreen();

        trafficLight.getCurrentState();
        trafficLight.transitionYellow();

        trafficLight.getCurrentState();
        trafficLight.transitionRed();
    }
}
