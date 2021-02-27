/**
 * Concrete Max_128GB  class that implements Storage interface.
 * Represents a Max_128GB type Storage product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Max_128GB implements Storage{
    /**
     * Constructor
     */
    public Max_128GB() {
    }
    /**
     * Getting storage type.
     * @return storage type as Max 128 GB.
     */
    @Override
    public String getStorage() {
        return "Max 128 GB";
    }
}
