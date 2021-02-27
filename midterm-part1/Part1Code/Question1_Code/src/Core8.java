/**
 * Concrete Core8 class that implements CPU_And_Ram interface.
 * Represents a Core8 type CPU_And_Ram product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Core8 implements CPU_And_Ram {
    /**
     * Constructor
     */
    public Core8(){

    }
    /**
     * Getting CPU and Ram type.
     * @return CPU and Ram type as 8 cores.
     */
    @Override
    public String getCPUAndRam() {
        return "8 cores";
    }
}
