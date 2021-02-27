/**
 * Concrete smartphone factory is to produce smartphone components.
 * EUComponent Factory knows right objects for their region.
 */
public class EUComponentFactory implements SmartphoneComponentsFactory {
    /**
     * Creation of Display.
     * @return display as TwentyFour_Bit.
     */
    @Override
    public Display DisplayCreation() {
        return new TwentyFour_Bit();
    }
    /**
     * Creation of Battery.
     * @return display as Lithium_Ion.
     */
    @Override
    public Battery BatteryCreation() {
        return new Lithium_Ion();
    }
    /**
     * Creation of CPU_And_Ram_Creation.
     * @return CPU_And_Ram as Core4.
     */
    @Override
    public CPU_And_Ram CPU_And_Ram_Creation() {
        return new Core4();
    }
    /**
     * Creation of Storage.
     * @return storage as Max_64GB.
     */
    @Override
    public Storage StorageCreation() {
        return new Max_64GB();
    }
    /**
     * Creation of Camera.
     * @return storage as Opt_Zoom_X3.
     */
    @Override
    public Camera CameraCreation() {
        return new Opt_Zoom_X3();
    }
    /**
     * Creation of Case.
     * @return case as Waterproof_Up_to_1m.
     */
    @Override
    public Case CaseCreation() {
        return new Waterproof_Up_to_1m();
    }
}
