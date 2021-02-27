/**
 * This class is adapter class that implements TurboPayment interface.
 *
 */
public class ModernPaymentAdapter implements TurboPayment{
    /**
     * Instance variable that is ModernPayment type.
     */
    ModernPayment modernPayment;

    /**
     * Getting a reference to the object that we are adapting that is ModernPayment in constructor.
     * @param modernPayment
     */
    public ModernPaymentAdapter(ModernPayment modernPayment){
        this.modernPayment=modernPayment;
    }

    /**
     * In that method, pay method of ModernPayment class is using.
     * @param turboCardNo is card no
     * @param turboAmount is amount
     * @param destinationTurboOfCourse is destination
     * @param installmentsButInTurbo is installments
     * @return
     */
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        modernPayment.pay(turboCardNo,turboAmount,destinationTurboOfCourse,installmentsButInTurbo);
        return 0;
    }
}
