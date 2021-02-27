/**
 * Concrete Waterproof_Up_to_50cm  class that implements Case interface.
 * Represents a Waterproof_Up_to_50cm type Case product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Waterproof_Up_to_50cm implements Case{
    /**
     * Constructor
     */
    public Waterproof_Up_to_50cm() {
    }
    /**
     * Getting case type.
     * @return case type as Waterproof up to 50cm.
     */
    @Override
    public String getCase() {
        return "Waterproof up to 50cm";
    }
}
