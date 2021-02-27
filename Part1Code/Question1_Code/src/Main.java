/**
 * Main class.
 */
public class Main {
    /**
     * Testing all models in all markets.
     * @param args arguments.
     */
    public static void main(String[] args) {
        SmartPhoneMarket smartPhoneMarket = new TurkeyMarket();
        smartPhoneMarket.attachComponents("MaximumEffort");
        smartPhoneMarket.attachComponents("IflaxDeluxe");
        smartPhoneMarket.attachComponents("I-I-Aman-Iflas");

        SmartPhoneMarket smartPhoneMarket2 = new GlobalMarket();
        smartPhoneMarket2.attachComponents("MaximumEffort");
        smartPhoneMarket2.attachComponents("IflaxDeluxe");
        smartPhoneMarket2.attachComponents("I-I-Aman-Iflas");

        SmartPhoneMarket smartPhoneMarket3 = new EU_Market();
        smartPhoneMarket3.attachComponents("MaximumEffort");
        smartPhoneMarket3.attachComponents("IflaxDeluxe");
        smartPhoneMarket3.attachComponents("I-I-Aman-Iflas");

    }
}
