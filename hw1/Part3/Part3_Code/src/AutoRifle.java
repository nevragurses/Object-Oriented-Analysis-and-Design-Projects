/**
 * AutoRifle is a decorator, so this class extended from AccessoryDecorator.
 */
public class AutoRifle extends AccessoryDecorator{
    Suits suit; //instance variable of suit for wrapping.

    /**
     * constructor for instantiating instance variable suit.
     * @param suit is object of Suits class.
     */
    public AutoRifle(Suits suit){
        this.suit=suit;
    }

    /**
     * total cost calculation that includes wrapping cost of suit and AutoRifle.
     * @return total cost.
     */
    @Override
    public double cost() {
        return (30*(Math.pow(10,3))) + suit.cost();
    }

    /**
     * total weight calculation that includes  wrapping weight of suit and AutoRifle.
     * @return total weight.
     */
    /**/
    @Override
    public double weight() {
        return 1.5 + suit.weight();
    }

    /**
     * Getting Description.
     * @return description of AutoRifle.
     */
    @Override
    public String getDescription() {
        return suit.getDescription() + ", AutoRifle";
    }


}
