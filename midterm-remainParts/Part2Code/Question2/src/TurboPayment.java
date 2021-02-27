/**
 * TurboPayment Interface that  cannot be modified.
 */
public interface TurboPayment {
    /**
     * Pay method for card payments.
     * @param turboCardNo is card no
     * @param turboAmount is amount
     * @param destinationTurboOfCourse is destination
     * @param installmentsButInTurbo is installments
     * @return zero if success.
     */
    int payInTurbo(String turboCardNo, float turboAmount,
                   String destinationTurboOfCourse, String installmentsButInTurbo);
}
