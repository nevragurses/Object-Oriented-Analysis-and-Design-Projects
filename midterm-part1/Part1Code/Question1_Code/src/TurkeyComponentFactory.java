/**
 *  Concrete smartphone factory is to produce smartphone components.
 * TurkeyComponent Factory knows right objects for their region.
 */
public class TurkeyComponentFactory implements SmartphoneComponentsFactory {
    /**
     * Creation of Display.
     * @return display as ThirtyTwo_Bit.
     */
    @Override
    public Display DisplayCreation() {
        return new ThirtyTwo_Bit();
    }
    /**
     * Creation of Battery.
     * @return display as Lithium_Boron.
     */
    @Override
    public Battery BatteryCreation() {
        return new Lithium_Boron();
    }

    /**
     * Creation of CPU_And_Ram_Creation.
     * @return CPU_And_Ram as Core8.
     */
    @Override
    public CPU_And_Ram CPU_And_Ram_Creation() {
        return new Core8();
    }
    /**
     * Creation of Storage.
     * @return storage as Max_128GB.
     */
    @Override
    public Storage StorageCreation() {
        return new Max_128GB();
    }
    /**
     * Creation of Camera.
     * @return storage as Opt_Zoom_X4.
     */
    @Override
    public Camera CameraCreation() {
        return new Opt_Zoom_X4();
    }

    /**
     * Creation of Case.
     * @return case as Waterproof_Up_to_2m.
     */
    @Override
    public Case CaseCreation() {
        return new Waterproof_Up_to_2m();
    }
}
