/**
 * Concrete ThirtyTwo_Bit  class that implements Display interface.
 * Represents a ThirtyTwo_Bit type Display product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class ThirtyTwo_Bit implements Display{
    /**
     * Constructor
     */
    public ThirtyTwo_Bit() {
    }

    /**
     * Getting display type
     * @return display type as 32 bit.
     */
    @Override
    public String getDisplay() {
        return "32 bit";
    }
}
