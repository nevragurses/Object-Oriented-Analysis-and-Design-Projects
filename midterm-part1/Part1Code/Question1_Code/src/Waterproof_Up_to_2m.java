/**
 * Concrete Waterproof_Up_to_2m  class that implements Case interface.
 * Represents a Waterproof_Up_to_2m type Case product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Waterproof_Up_to_2m implements Case{
    /**
     * Constructor
     */
    public Waterproof_Up_to_2m() {
    }
    /**
     * Getting case type.
     * @return case type as Waterproof up to 2m.
     */
    @Override
    public String getCase() {
        return "Waterproof up to 2m";
    }
}
