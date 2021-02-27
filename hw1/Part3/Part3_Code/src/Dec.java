/**
 * Dec is a suit so this class extends Suits class.
 */
public class Dec extends Suits {
    /**
     * Constructor.
     */
    public Dec() {
        description = "dec";
    }

    /**
     * getting cost of dec.
     * @return cost of dec.
     */
    @Override
    public double cost() {
        return 500*(Math.pow(10, 3));
    }

    /**
     * getting weight of dec.
     * @return weight of dec.
     */
    @Override
    public double weight() {
        return 25.0;
    }
}
