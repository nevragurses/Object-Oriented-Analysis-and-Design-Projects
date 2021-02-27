/**
 * Concrete Content Photographs class that implements Contents interface
 */
public class Photographs implements Contents{
    private String photographs;

    /**
     * setting updates.
     * @param object is setting value.
     */
    @Override
    public void set(Object object) {
        photographs=(String)object;
        //System.out.println("IN SET FUNCTION OF PHOTOGRAPH "+photographs);
    }

    /**
     * getting content name
     * @return content name that is Photographs.
     */
    //
    @Override
    public Demands getName() {
        return Demands.Photographs;
    }
}
