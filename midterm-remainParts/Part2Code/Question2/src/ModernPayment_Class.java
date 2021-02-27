/**
 * Concrete ModelPayment class that implements ModerPayment interface
 */
public class ModernPayment_Class implements ModernPayment{
    /**
     *
     * @param cardNo is card no
     * @param amount is amount
     * @param destination is description
     * @param installments is installments
     * @return zero if success.
     */
    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {
        System.out.println("~~~~~~~~In concrete Modern Payment Class~~~~~~~~");
        System.out.println("Modern Payment Operation is doing with card no: " + cardNo + " amount: " + amount +
                " destination: " + destination + " installments: " + installments + "\n");

        return 0;
    }
}
