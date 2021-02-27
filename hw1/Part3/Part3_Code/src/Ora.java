/**
 * Ora is a suit so this class extends Suit interface.
 */
public class Ora extends Suits {
    /**
     * Constructor.
     */
    public Ora() {
        description = "ora"; //description.
    }

    /**
     * Getting cost of ora.
     * @return cost of ora.
     */
    @Override
    public double cost() {
        return 1500*(Math.pow(10, 3));
    }

    /**
     * getting weight of ora.
     * @return weight of ora.
     */
    @Override
    public double weight() {
        return 30.0;
    }
}
