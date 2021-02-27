import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Main class.
 */
public class Main {
    /**
     * Static void function for testing operations.
     * @param args is command line arguments.
     */
    public static void main(String[] args) {

        Integer data[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println("The given 2D data before traversing");
        SatelliteIterator satalliteIterator=new SatelliteIterator(data);
        print2D(data);
        Iterator iterator= satalliteIterator;
        System.out.println("\nTraversing data as spirally clockwise with iterator:");
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }

    }

    /**
     * For printing 2D array as matrix.
     * @param matrix is 2D array.
     */
    public static void print2D(Integer matrix[][])
    {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
