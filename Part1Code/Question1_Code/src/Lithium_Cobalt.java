/**
 * Concrete Lithium_Cobalt class that implements Battery  interface.
 * Represents a Lithium_Cobalt type Battery product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Lithium_Cobalt implements Battery {
    /**
     * Constructor
     */
    public Lithium_Cobalt(){

    }

    /**
     * Getting battery type.
     * @return battery type as Lithium-Cobalt.
     */
    @Override
    public String getBattery() {
        return "Lithium-Cobalt";
    }
}
