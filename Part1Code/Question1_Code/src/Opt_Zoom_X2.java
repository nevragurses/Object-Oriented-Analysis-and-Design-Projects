/**
 * Concrete Opt_Zoom_X2  class that implements Camera interface.
 * Represents a Opt_Zoom_X2 type Camera product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Opt_Zoom_X2 implements Camera {
    /**
     * Constructor
     */
    public Opt_Zoom_X2() {
    }

    /**
     * Getting camera type.
     * @return camera type as Opt. Zoom x2.
     */
    @Override
    public String getCamera() {
        return "Opt. Zoom x2";
    }
}
