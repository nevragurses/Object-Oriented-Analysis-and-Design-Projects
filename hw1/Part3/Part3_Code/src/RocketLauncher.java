/**
 * RocketLauncher is a decorator, so this class extended from AccessoryDecorator.
 */
public class RocketLauncher extends AccessoryDecorator{
    Suits suit; //instance variable of suit for wrapping.

    /**
     * Constructor for instantiating instance variable suit.
     * @param suit is object of Suits class.
     */
    public RocketLauncher(Suits suit){
        this.suit=suit;
    }

    /**
     * Total cost calculation that includes wrapping cost of suit and RocketLauncher.
     * @return  total cost.
     */
    @Override
    public double cost() {
        return (150*(Math.pow(10,3))) + suit.cost();
    }

    /**
     * Total weight calculation that includes  wrapping weight of suit and RocketLauncher.
     * @return total weight.
     */
    @Override
    public double weight() {
        return 7.5 + suit.weight();
    }

    /**
     * Getting description.
     * @return description.
     */
    @Override
    public String getDescription() {
        return suit.getDescription() + ", RocketLauncher";
    }


}
