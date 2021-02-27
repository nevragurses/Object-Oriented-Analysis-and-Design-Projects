/**
 * MaximumEffort class that extends Smartphone class.
 * It is a smartphone model.
 */
public class MaximumEffort extends SmartPhone {
    /**
     * SmartphoneComponentsFactory type an instance variable.
     */
    SmartphoneComponentsFactory componentsFactory;
    /**
     * For producing phone, there must be a factory that is provide the components.
     * So each Smartphone Model class gets factory in constructor and store it instance variable.
     * And also definite components for MaximumEffort model are recorded.
     */
    public MaximumEffort(SmartphoneComponentsFactory componentsFactory){
        this.componentsFactory=componentsFactory;
        /*Definite components*/
        definedCamera = "12Mp front, 8Mp rear ";
        definedBattery= "27h, 3600mAh ";
        definedCPU = "2.8GHz, 8GB ";
        definedStorage = "MicroSD support, 64GB ";
        definedDisplay = "5.5 inches ";
        definedCase = "151x73x7.7 mm, dustproof, waterproof, aluminum " ;
    }
    /**
     * Implementing abstract method in Smartphone class for producing phone components.
     *  Each time it needs an component, it use the factory to produce it.
     */
    @Override
    void create() {
        System.out.println("\nProducing " + name);
        battery = componentsFactory.BatteryCreation();
        camera = componentsFactory.CameraCreation();
        caseOfPhone = componentsFactory.CaseCreation();
        cpu_and_ram = componentsFactory.CPU_And_Ram_Creation();
        display = componentsFactory.DisplayCreation();
        storage = componentsFactory.StorageCreation();
    }
}
