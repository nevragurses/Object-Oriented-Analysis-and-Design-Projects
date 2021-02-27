/**
 * GlobalMarket class is client of the Abstract Factory.
 * This class extends SmartPhoneMarket class.
 */
public class GlobalMarket extends SmartPhoneMarket {
    /**
     * @param model is phone model.
     * @return phone with given model in Global Market.
     */
    @Override
    protected SmartPhone createPhone(String model) {
        SmartPhone phone = null;
        SmartphoneComponentsFactory componentsFactory= new GlobalComponentFactory();
        if(model.equals("MaximumEffort")){
            phone= new MaximumEffort(componentsFactory);
            phone.setName("Global Style MaximumEffort Model");
        }
        if(model.equals("IflaxDeluxe")){
            phone= new IflasDeluxe(componentsFactory);
            phone.setName("Global Style IflaxDeluxe Model");
        }
        if(model.equals("I-I-Aman-Iflas")){
            phone= new I_I_Aman_Iflas(componentsFactory);
            phone.setName("Global Style I-I-Aman-Iflas Model");
        }
        return phone;
    }
}
