/**
 * Concrete Lithium_Boron class that implements Battery  interface.
 * Represents a Lithium_Boron type Battery product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Lithium_Boron implements Battery {
    /**
     * Constructor
     */
    public Lithium_Boron(){

    }

    /**
     * Getting battery type.
     * @return battery type as Lithium_Boron.
     */
    @Override
    public String getBattery() {
        return "Lithium_Boron";
    }
}
