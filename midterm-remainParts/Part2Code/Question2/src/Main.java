/**
 * Main class.
 */
public class Main {

    /**
     * Testing operations.
     * @param args arguments.
     */
    public static void main(String[] args) {
        ModernPayment_Class modernPayment = new ModernPayment_Class();
        TurboPayment_Class turboPayment = new TurboPayment_Class();
        TurboPayment modernPaymentAdapter = new ModernPaymentAdapter(modernPayment);


        System.out.println("The Actual Modern Payment Class payments: ");
        modernPayment.pay("1999" , 200 , "Bahar" , "1224");
        System.out.println("The Actual Turbo Payment Class payments: ");
        turboPayment.payInTurbo("1998" , 100 , "Mehmet" , "1293");


        System.out.println("\nThe Modern Payment Adapter Class payments:");
        modernPaymentAdapter.payInTurbo("1997" , 300 , "Aysun" , "1223");
    }


}
