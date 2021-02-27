/**
 * @author  Nevra Gürses
 * @version 1.0
 * @since   2020-11-22
 */

/**
 * Main class for testing project
 */
public class Main {
    /**
     * Static main method for starting and testing project.
     * @param args is arguments.
     */
    public static void main(String[] args) {
        Suits suit = new Dec();
        //suit = new Flamethrower(suit);
        suit = new AutoRifle(suit);
        suit = new Laser(suit);
        //suit= new RocketLauncher(suit);
        System.out.println("Total cost and weight of an equipped suit that includes: "+ suit.getDescription()+ " = "
                + (int)suit.cost()/(int)Math.pow(10, 3) + "k TL, " + suit.weight() + " kg");
        Suits suit2 = new Ora();
        suit2 = new Flamethrower(suit2);
       // suit2 = new AutoRifle(suit2);
        suit2 = new Laser(suit2);
        suit2= new RocketLauncher(suit2);
        System.out.println("Total cost and weight of an equipped suit that includes: "+ suit2.getDescription()+ " = "
                + (int)suit2.cost()/(int)Math.pow(10, 3) + "k TL, " + suit2.weight() + " kg");
        Suits suit3 = new Tor();
        suit3 = new Flamethrower(suit3);
        suit3 = new AutoRifle(suit3);
        suit3 = new Laser(suit3);
        suit3= new RocketLauncher(suit3);
        System.out.println("Total cost and weight of an equipped suit that includes: "+ suit3.getDescription()+ " = "
                + (int)suit3.cost()/(int)Math.pow(10, 3) + "k TL, " + suit3.weight() + " kg");
    }
}
