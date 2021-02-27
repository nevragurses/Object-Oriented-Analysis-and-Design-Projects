/**
 * EU_Market class is client of the Abstract Factory.
 * This class extends SmartPhoneMarket class.
 */
public class EU_Market extends SmartPhoneMarket {
    /**
     * @param model is phone model.
     * @return phone with given model in EU Market.
     */
    @Override
    protected SmartPhone createPhone(String model) {
        SmartPhone phone = null;
        SmartphoneComponentsFactory componentsFactory= new EUComponentFactory();
        if(model.equals("MaximumEffort")){
            phone= new MaximumEffort(componentsFactory);
            phone.setName("EU Style MaximumEffort Model");
        }
        if(model.equals("IflaxDeluxe")){
            phone= new IflasDeluxe(componentsFactory);
            phone.setName("EU Style IflaxDeluxe Model");
        }
        if(model.equals("I-I-Aman-Iflas")){
            phone= new I_I_Aman_Iflas(componentsFactory);
            phone.setName("EU Style I-I-Aman-Iflas Model");
        }
        return phone;
    }
}
