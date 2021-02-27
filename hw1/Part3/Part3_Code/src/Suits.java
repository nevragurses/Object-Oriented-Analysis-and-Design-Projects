/**
 * Abstract Suit Class that includes 2 abstract method.
 */
public abstract class Suits {
    String description="Unknown suit";

    /**
     * getting cost of suits.
     * @return cost of suits.
     */
    public abstract double cost();

    /**
     * getting weight of suits.
     * @return weight of suits.
     */
    public abstract double weight();

    /**
     * Getting description.
     * @return description.
     */
    public String getDescription(){
        return description;
    }

}
