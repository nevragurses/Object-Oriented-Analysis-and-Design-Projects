/**
 * TurkeyMarket class is client of the Abstract Factory.
 * This class extends SmartPhoneMarket class.
 */
public class TurkeyMarket extends SmartPhoneMarket {
    /**
     * @param model is phone model.
     * @return phone with given model in Turkey Market.
     */
    @Override
    protected SmartPhone createPhone(String model) {
        SmartPhone phone = null;
        SmartphoneComponentsFactory componentsFactory= new TurkeyComponentFactory();
        if(model.equals("MaximumEffort")){
            phone= new MaximumEffort(componentsFactory);
            phone.setName("Turkey Style MaximumEffort Model");
        }
        if(model.equals("IflaxDeluxe")){
            phone= new IflasDeluxe(componentsFactory);
            phone.setName("Turkey Style IflaxDeluxe Model");
        }
        if(model.equals("I-I-Aman-Iflas")){
            phone= new I_I_Aman_Iflas(componentsFactory);
            phone.setName("Turkey Style I-I-Aman-Iflas Model");
        }
        return phone;
    }
}
