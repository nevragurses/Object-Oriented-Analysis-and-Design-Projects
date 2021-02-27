import javax.swing.*;
/**
 * @author  Nevra Gürses
 * @version 1.0
 * @since   2020-11-22
 */
import java.util.ArrayList;

/**
 * Main class for testing and starting project.
 */
public class Main {
    /**
     * Static main method.
     * @param args is arguments.
     */
    public static void main(String[] args) {
        Website website = new Website();

        Contents contents = new Text();
        Contents contents1=new Photographs();
        Contents contents2=new Audio();

        ArrayList<Demands> demands=new ArrayList<>();
        demands.add(Demands.Text);
        demands.add(Demands.Photographs);
        System.out.println("Desired Contents of Subscriber-1 is : " + demands);
        Subscriber subscriber = new Subscriber(website,demands);

        ArrayList<Demands> demand2=new ArrayList<>();
        demand2.add(Demands.Audio);
        demand2.add(Demands.Photographs);
        System.out.println("Desired Contents of Subscriber-2 is : " + demand2);
        Subscriber subscriber2 = new Subscriber(website,demand2);


        website.setUpdates(contents,"text");
        website.setUpdates(contents1,"photograph");
        website.setUpdates(contents2,"audio");
    }
}
