package sample;

/**
 * Solver class that keeps Method interface in
 * and with dynamic binding linear equation solve method is working.
 */
public class Solver {
    /**
     * instance variable that is type Method interface.
     */
    private Method method;

    /**
     * Default constructor.
     */
    public Solver(){
    }

    /**
     *Setting linear equation solving method.
     * @param method is linear equation solving method.
     */
    public void setSolver(Method method) {
        this.method = method;
    }

    /**
     * In this method,Solve method of Method interface is calling.
     * @param arrA is coefficient matrix.
     * @param arrB is constants array.
     * @return linear equation result.
     */
    public double[] solveEquation(double[][] arrA,double[] arrB){
        return method.solve(arrA,arrB);
    }


}
