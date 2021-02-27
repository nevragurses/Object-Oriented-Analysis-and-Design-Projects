/**
 * SmartphoneComponentsFactory is the interface
 * that defines how to make a family of related products
 * everything we need to produce smartphone.
 */
public interface SmartphoneComponentsFactory {
    /**
     * Creation Display for phone.
     * @return created display.
     */
    public Display DisplayCreation();
    /**
     * Creation Battery for phone.
     * @return created battery.
     */
    public Battery BatteryCreation();
    /**
     * Creation CPU_And_Ram for phone.
     * @return created CPU_And_Ram.
     */
    public CPU_And_Ram  CPU_And_Ram_Creation();
    /**
     * Creation Storage for phone.
     * @return created storage.
     */
    public Storage StorageCreation();
    /**
     * Creation Camera for phone.
     * @return created camera.
     */
    public Camera CameraCreation();
    /**
     * Creation Case for phone.
     * @return created case.
     */
    public Case CaseCreation();
}
