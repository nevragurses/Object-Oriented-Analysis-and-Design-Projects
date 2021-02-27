/**
 * Concrete Lithium_Ion class that implements Battery  interface.
 * Represents a Lithium_Ion type Battery product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Lithium_Ion implements Battery{
    /**
     * Constructor
     */
    public Lithium_Ion(){

    }
    /**
     * Getting battery type.
     * @return battery type as Lithium-Ion.
     */
    @Override
    public String getBattery() {
        return "Lithium-Ion";
    }
}
