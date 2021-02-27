/**
 * Tor is a suit so this class extends Suits class.
 */
public class Tor extends Suits {
    /**
     * Constructor.
     */
    public Tor() {
        description = "tor";
    }

    /**
     * getting cost of tor.
     * @return cost of tor.
     */
    @Override
    public double cost() {
        return 5000*(Math.pow(10, 3));
    }

    /**
     *  getting weight of tor.
     * @return weight of tor.
     */
    @Override
    public double weight() {
        return 50.0;
    }
}
