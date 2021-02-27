/**
 * ModernPayment interface
 */
public interface ModernPayment {
    /**
     * Pay method for card payments.
     * @param cardNo is card no
     * @param amount is amount
     * @param destination is description
     * @param installments is installments
     * @return zero if success.
     */
    int pay(String cardNo, float amount, String destination, String installments);

}
