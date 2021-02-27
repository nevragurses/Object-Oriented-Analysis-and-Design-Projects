/**
 * Concrete Content Audio class that implements Contents interface
 */
public class Audio implements Contents {
    private String audio;

    /**
     * Setting updates.
     * @param object that is setting.
     */
    @Override
    public void set(Object object) {
        audio=(String)object;
        //System.out.println("IN SET FUNCTION OF AUDIO "+ audio);
    }

    /**
     * getting name that is Audio.
     * @return name of content.
     */
    @Override
    public Demands getName() {
         return Demands.Audio;
    }
}
