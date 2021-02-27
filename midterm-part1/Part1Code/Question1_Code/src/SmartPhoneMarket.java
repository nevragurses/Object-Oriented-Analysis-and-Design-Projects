/**
 *SmartPhoneMarket abstract class for creation of smartphone  and attaching components.
 */
public abstract class SmartPhoneMarket {
    /**
     * Creation of phone components by using createPhone method and attaching components with sequence.
     * @param model is phone model.
     * @return phone.
     */
    public SmartPhone attachComponents(String model) {
        SmartPhone phone;
        phone = createPhone(model);
        phone.create();
        phone.attach_cpu_and_ram();
        phone.attach_display();
        phone.attach_battery();
        phone.attach_storage();
        phone.attach_camera();
        phone.enclose_phone_case();
        //phone.toString();
        return phone;
    }

    /**
     * Abstract method for creating phone components with given model in given market.
     * @param model is phone model.
     * @return phone with given model in given market.
     */
    protected abstract SmartPhone createPhone(String model);
}
