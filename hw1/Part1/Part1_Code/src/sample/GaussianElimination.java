package sample;

/**
 * Gaussian Elimination class for finding linear equation result
 * by using Gaussian elimination method.
 */
public class GaussianElimination implements Method {
    private int n;
    private double[][] coefficientMatrix;
    private double[] resultMatrix;
    private static final double EpsilonVal = 1e-10;
    private boolean res;

    /**
     * Default constructor.
     */
    public  GaussianElimination(){

    }
    /**
     * Solves given linear equation.
     * @param coefficientMatrix is coefficient matrix.
     * @param resultMatrix result matrix.
     * @return result of given linear equation.
     */
    @Override
    public double[] solve(double[][] coefficientMatrix, double[] resultMatrix) {
        n = resultMatrix.length;
        res=true;
        this.coefficientMatrix=coefficientMatrix;
        this.resultMatrix=resultMatrix;
        for (int z = 0; z < n; z++) {
            // find pivot row.
            int max = z;
            for (int i= z+1; i < n; i++) {
                /*Finding bigger amplitude for pivot*/
                if (Math.abs(coefficientMatrix[i][z]) > Math.abs(coefficientMatrix[max][z])) {
                    max = i;
                }
            }
            swap_row(z,max); //swapping rows.
            swap_resultsMatrix(z,max); //swapping constants array.

            // Singular or nearly singular,so there is no solution for equation.
            if (Math.abs(coefficientMatrix[z][z]) <= EpsilonVal) {
                res=false;

            }
            // pivot within coefficientMatrix and resultMatrix.
            for (int i = z + 1; i < n; i++) {
                double value = coefficientMatrix[i][z] / coefficientMatrix[z][z];
                resultMatrix[i] = resultMatrix[i]- (value * resultMatrix[z]);
                for (int j = z; j < n; j++) {
                    coefficientMatrix[i][j] = coefficientMatrix[i][j] - (value * coefficientMatrix[z][j]);
                }
            }
        }
        return result();
    }

    /**
     * For calculating the values of the unknowns
     * @return result of linear equation in double array.
     */
    private double[] result(){
        double[] x = new double[n];
        if(!res){ //if there is no solution for matrix.
            x[0]=Double.MAX_VALUE;
        }
        else {
            for (int i = n-1; i >= 0;i--) {
                double sum = 0.0;
                for (int j = i + 1; j < n; j++) {
                    sum = sum+(coefficientMatrix[i][j] * x[j]);
                }
                x[i]=(resultMatrix[i] - sum)/coefficientMatrix[i][i];
            }
        }
        return x;
    }

    /**
     * method for swapping two rows in matrix.
     * @param k is index of first row.
     * @param max index of other row.
     */
    private void swap_row(int k, int max)
    {
        /*Swapping row in coefficient matrix*/
        double[] temp = coefficientMatrix[k];
        coefficientMatrix[k] = coefficientMatrix[max];
        coefficientMatrix[max] = temp;

    }

    /**
     * method for swapping constants array.
     * @param k is index of first row.
     * @param max is index of second row.
     */
    private void swap_resultsMatrix( int k, int max)
    {
        double temp    = resultMatrix[k];
        resultMatrix[k] = resultMatrix[max];
        resultMatrix[max] = temp;

    }

}
