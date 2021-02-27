/**
 * Smartphone abstract class.
 */
public abstract class SmartPhone {
    /**
     * Each SmartPhone holds a set of components
     * that are used in its production.
     */
    String name;
    Battery battery;
    Camera camera;
    Case caseOfPhone;
    CPU_And_Ram cpu_and_ram;
    Display display;
    Storage storage;

    /**
     * Defined components for model that are used in its production.
     */
    String definedBattery;
    String definedCamera;
    String definedCase;
    String definedCPU;
    String definedStorage;
    String definedDisplay;

    /**
     * Abstract smartphone component create method.
     */
    abstract void create();


    /**
     * Attach cpu_and_ram for smartPhone.
     */
    public void attach_cpu_and_ram() {
        System.out.println("Attached Cpu & Ram that is " +  definedCPU +"," + cpu_and_ram.getCPUAndRam() +" to the board.");
    }
    /**
     * Attach Display for smartPhone.
     */
    public void attach_display() {
        System.out.println("Attached display that is " +definedDisplay + ", "+ display.getDisplay());
    }
    /**
     * Attach Battery for smartPhone.
     */
    public void attach_battery() {
        System.out.println("Attached battery that is " + definedBattery+ ", " + battery.getBattery());
    }
    /**
     * Attach Storage for smartPhone.
     */
    public void attach_storage() {
        System.out.println("Attached storage that is " + definedStorage + ", " + storage.getStorage());
    }
    /**
     * Attach Camera smartPhone.
     */
    public void attach_camera() {
        System.out.println("Attached camera that is "+ definedCamera + ", " + camera.getCamera());
    }
    /**
     * Attach Enclose phone case for smartPhone.
     */
    public void enclose_phone_case() {
        System.out.println("Enclosed the phone case that is " + definedCase + ", " + caseOfPhone.getCase());
    }

    /**
     * Set model and market name.
     * @param name model and market name.
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Get name.
     * @return name.
     */
    String getName() {
        return name;
    }

    /**
     * For getting phone features.
     * @return phone features.
     */
    public String toString() {
        String str = "~~~~~~~~~Features~~~~~~~~~\n"
                + "Display: " + definedDisplay + ", "+ display.getDisplay() + "\n"
                + "Battery: " + definedBattery + ", " + battery.getBattery() + "\n"
                + "CPU & Ram: " + definedCPU + ", " + cpu_and_ram.getCPUAndRam() + "\n"
                + "Storage: " + definedStorage + ", " + storage.getStorage() + "\n"
                + "Camera: " + definedCamera + ", " + camera.getCamera() + "\n"
                + "Case: " + definedCase + ", " + caseOfPhone.getCase()
                + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        System.out.println(str);
        return str;
    }
}
