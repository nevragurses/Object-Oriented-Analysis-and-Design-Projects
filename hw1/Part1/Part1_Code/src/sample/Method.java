package sample;

/**
 * Linear equation solving method interface.
 */
public interface Method {
    /**
     * This method solves given Linear equation.
     * @param coefficientMatrix is coefficient matrix.
     * @param constantsArray is constants array.
     * @return result of linear equation.
     */
    public double[] solve(double[][] coefficientMatrix, double[] constantsArray); //linear equation solving function.

}
