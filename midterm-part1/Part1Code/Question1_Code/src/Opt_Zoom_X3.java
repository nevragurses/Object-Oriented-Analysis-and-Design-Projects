/**
 * Concrete Opt_Zoom_X3  class that implements Camera interface.
 * Represents a Opt_Zoom_X3 type Camera product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Opt_Zoom_X3 implements Camera{
    /**
     * Constructor
     */
    public Opt_Zoom_X3() {
    }

    /**
     * Getting camera type.
     * @return camera type as Opt. Zoom x3.
     */
    @Override
    public String getCamera() {
        return "Opt. Zoom x3";
    }
}
