/**
 * I_I_Aman_Iflas class that extends Smartphone class.
 * It is a smartphone model.
 */
public class I_I_Aman_Iflas extends SmartPhone {
    /**
     * SmartphoneComponentsFactory type an instance variable.
     */
    SmartphoneComponentsFactory componentsFactory;
    /**
     * For producing phone, there must be a factory that is provide the components.
     * So each Smartphone Model class gets factory in constructor and store it instance variable.
     * And also definite components for I_I_Aman_Iflas model are recorded.
     */
    public I_I_Aman_Iflas(SmartphoneComponentsFactory componentsFactory){
        this.componentsFactory=componentsFactory;
        /*Definite components*/
        definedCamera = "8Mp front, 5Mp rear ";
        definedBattery= "16h, 2000mAh ";
        definedCPU = "2.2GHz, 4GB ";
        definedStorage = "MicroSD support, 16GB ";
        definedDisplay = "4.5 inches ";
        definedCase = "143x69x7.3 mm, waterproof, plastic" ;
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
