/**
 * Concrete smartphone factory is to produce smartphone components.
 * GlobalComponent Factory knows right objects for their region.
 */
public class GlobalComponentFactory implements SmartphoneComponentsFactory {
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
     * @return display as Lithium_Cobalt.
     */
    @Override
    public Battery BatteryCreation() {
        return new Lithium_Cobalt();
    }

    /**
     * Creation of CPU_And_Ram_Creation.
     * @return CPU_And_Ram as Core2.
     */
    @Override
    public CPU_And_Ram CPU_And_Ram_Creation() {
        return new Core2();
    }

    /**
     * Creation of Storage.
     * @return storage as Max_32GB.
     */
    @Override
    public Storage StorageCreation() {
        return new Max_32GB();
    }

    /**
     * Creation of Camera.
     * @return storage as Opt_Zoom_X2.
     */
    @Override
    public Camera CameraCreation() {
        return new Opt_Zoom_X2();
    }

    /**
     * Creation of Case.
     * @return case as Waterproof_Up_to_50cm.
     */
    @Override
    public Case CaseCreation() {
        return new Waterproof_Up_to_50cm();
    }
}
