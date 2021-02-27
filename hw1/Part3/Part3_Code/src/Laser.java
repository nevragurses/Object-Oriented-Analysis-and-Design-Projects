/**
 * Laser is a decorator, so this class extended from AccessoryDecorator.
 */
public class Laser extends AccessoryDecorator{
    Suits suit; //instance variable of suit for wrapping.

    /**
     * constructor for instantiating instance variable suit.
     * @param suit is object of Suits class.
     */
    public Laser(Suits suit){
        this.suit=suit;
    }

    /**
     * total cost calculation that includes wrapping cost of suit and Laser.
     * @return total cost.
     */
    @Override
    public double cost() {
        return (200*(Math.pow(10,3))) + suit.cost();
    }

    /**
     * Total weight calculation that includes  wrapping weight of suit and Laser.
     * @return total weight.
     */
    @Override
    public double weight() {
        return 5.5 + suit.weight();
    }

    /**
     * Getting description
     * @return description of Laser.
     */
    @Override
    public String getDescription() {
        return suit.getDescription() + ", Laser";
    }

}
