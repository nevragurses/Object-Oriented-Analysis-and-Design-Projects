/**
 * Concrete Max_32GB  class that implements Storage interface.
 * Represents a Max_32GB type Storage product that is produced by a Factory Method
 * in the Abstract Factory.
 */
public class Max_32GB implements Storage {
    /**
     * Constructor
     */
    public Max_32GB() {
    }

    /**
     * Getting storage type.
     * @return storage type as Max 32 GB.
     */
    @Override
    public String getStorage() {
        return "Max 32 GB";
    }
}
