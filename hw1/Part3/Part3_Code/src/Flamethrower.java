/**
 * Flamethrower is a decorator, so this class extended from AccessoryDecorator.
 */
public class Flamethrower extends AccessoryDecorator{
    Suits suit; //instance variable of suit for wrapping.

    /**
     * constructor for instantiating instance variable suit.
     * @param suit is object of Suits class.
     */
    public Flamethrower(Suits suit){
        this.suit=suit;
    }

    /**
     * Total cost calculation that includes wrapping cost of suit and Flamethrower.
     * @return total cost.
     */
    @Override
    public double cost() {
        return (50*(Math.pow(10,3))) + suit.cost();
    }

    /**
     * total weight calculation that includes  wrapping weight of suit and Flamethrower.
     * @return total weight.
     */
    @Override
    public double weight() {
        return 2.0 + suit.weight();
    }

    /**
     * Getting description.
     * @return description of flamethrower.
     */
    @Override
    public String getDescription() {
        return suit.getDescription() + ", Flamethrower";
    }


}
