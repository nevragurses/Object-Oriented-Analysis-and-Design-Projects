/**
 * Concrete TwentyFour_Bit  class that implements Display interface.
 * Represents a TwentyFour_Bit type Display product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class TwentyFour_Bit implements Display{
    /**
     * Constructor
     */
    public TwentyFour_Bit() {
    }

    /**
     * Getting display type
     * @return display type as 24 bit.
     */
    @Override
    public String getDisplay() {
        return "24 bit";
    }
}
