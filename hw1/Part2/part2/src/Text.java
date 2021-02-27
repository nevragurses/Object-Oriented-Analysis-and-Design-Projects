/**
 * Concrete Content Text class that implements Contents interface
 */
public class Text implements Contents {
    private String text;

    /**
     * Setting updates.
     * @param object is setting value.
     */
    @Override
    public void set(Object object) {
        text=(String)object;
        //System.out.println("IN SET FUNCTION OF TEXT "+ text);
    }

    /**
     * Getting content name.
     * @return content name.
     */
    @Override
    public Demands getName() {
        return Demands.Text;
    }
}
