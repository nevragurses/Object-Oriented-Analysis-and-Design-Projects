import java.util.ArrayList;

/**
 * Observer interface that has 2 methods.
 */
public interface Observer {
    /**
     * updating method for observers.
     * @param obs content type.
     * @param arg setting value of content.
     */
    public void update(Object obs, Object arg);

    /**
     * controlling observers whether updated type is desired type or not.
     * @param demand is content type.
     * @return whether updated type is desired type or not.
     */
    public boolean isContain(Demands demand);
}
