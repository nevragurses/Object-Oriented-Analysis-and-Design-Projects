/**
 * Concrete Max_64GB  class that implements Storage interface.
 * Represents a Max_64GB type Storage product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Max_64GB implements Storage {
    /**
     * Constructor
     */
    public Max_64GB() {
    }
    /**
     * Getting storage type.
     * @return storage type as Max 64 GB.
     */
    @Override
    public String getStorage() {
        return "Max 64 GB";
    }
}
