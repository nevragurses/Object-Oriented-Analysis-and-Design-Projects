/**
 * Concrete Core4 class that implements CPU_And_Ram interface.
 * Represents a Core4 type CPU_And_Ram product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Core4 implements CPU_And_Ram {
    /**
     * Constructor.
     */
    public Core4(){

    }
    /**
     * Getting CPU and Ram type.
     * @return CPU and Ram type as 4 cores.
     */
    @Override
    public String getCPUAndRam() {
        return "4 cores";
    }
}
