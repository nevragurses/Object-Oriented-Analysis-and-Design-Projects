/**
 * Concrete Core2 class that implements CPU_And_Ram interface.
 * Represents a Core2 type CPU_And_Ram product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Core2 implements CPU_And_Ram {
    /**
     * Constructor.
     */
    public Core2(){

    }
    /**
     * Getting CPU and Ram type.
     * @return CPU and Ram type as 2 cores.
     */
    @Override
    public String getCPUAndRam() {
        return "2 cores";
    }
}
