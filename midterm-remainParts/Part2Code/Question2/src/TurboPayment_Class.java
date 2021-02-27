/**
 * Concrete TurboPayment class that implements TurboPayment interface.
 */
public class TurboPayment_Class implements TurboPayment{
    /**
     *
     * @param turboCardNo is card no
     * @param turboAmount is amount
     * @param destinationTurboOfCourse is destination
     * @param installmentsButInTurbo is installments
     * @return zero if success.
     */
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        System.out.println("~~~~~~~~In concrete Turbo Payment class~~~~~~~~");
        System.out.println("Turbo Payment Operation doing with card no: " + turboCardNo + " amount: " + turboAmount +
                " destination: " + destinationTurboOfCourse + " installments: " + installmentsButInTurbo + "\n");
        return 0;
    }
}
