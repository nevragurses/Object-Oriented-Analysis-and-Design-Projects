package sample;

/**
 * Matrix Inversion class for finding linear equation result by using Matrix inversion method.
 */
public class MatrixInversion  implements Method {
    private int n;
    private double [][] coeffMatrix; //coefficient matrix.
    private double [] resultMatrix; //result matrix
    private double [][]adj; //adjoint matrix.
    private double [][]inv; //inverse matrix.
    private boolean res;

    /**
     * Default constructor.
     */
    MatrixInversion(){

    }

    /**
     * Solves given linear equation.
     * @param coeffMatrix is coefficient matrix.
     * @param resultMatrix result matrix.
     * @return result of given linear equation.
     */
    @Override
    public double[] solve(double[][] coeffMatrix, double[] resultMatrix) {
        n = resultMatrix.length ; // number of unknowns
        res=true;
        adj= new double[n][n]; // to store adjoint  matrix of coeffMatrix[][]
        inv= new double[n][n]; // to store inverse matrix of coeffMatrix[][]
        this.coeffMatrix = coeffMatrix;
        this.resultMatrix=resultMatrix;
        adjoint(adj); //finding adjoint matrix method.
        res=inverse(); //finding inverse matrix method.
        return  result(); //solving linear equation.

    }

    /**
     * Results of linear equation is equal to: X = Inverse Matrix * result Matrix.
     * This method is providing this goal.
     * @return solution of linear equation.
     */
    public  double[] result() {
        double sol[] =new double[n];
        /*If equation has not a solution.*/
        if(!res){
            sol[0]=Double.MAX_VALUE;
        }
        else {
            //this loop for matrix multiplication.
            for (int i = 0; i < n; i++) {
                double temp = 0;
                for (int j = 0; j < resultMatrix.length; j++)
                    temp = temp + (inv[i][j] * resultMatrix[j]);
                sol[i] = temp;
            }
        }
        return sol; //solution of linear equation.

    }

    /**
     * Finding adjoint matrix method.
     * @param adj is adjoint matrix.
     */
    private void adjoint(double [][]adj)
    {
        if (n == 1) { //if unknown number is one, adjoint matrix is 1.
            adj[0][0] = 1;
            return;
        }
        double [][]minor = new double[n][n]; //for keeping minor matrix.
        int mark = 1;

        //this loop for finding adjoint matrix by using coefficient and determinant operation.
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                findingCofactor(coeffMatrix,minor, i, j); //calling  cofactor method.
                if((i+j)%2==0){
                    mark=1;
                }
                else{
                    mark=-1;
                }
                //adjoint matrix is equal to multiplication of mark and determinant of minor.
                adj[j][i] = (mark)*(findDeterminant(minor, n-1));
            }
        }
    }

    /**
     * Finding cofactor method.
     * @param matrix is coefficient matrix.
     * @param minor is minor.
     * @param currRow is current row.
     * @param currColumn is current column.
     */
    private void findingCofactor(double matrix[][], double minor[][], int currRow, int currColumn)
    {
        int i=0,j = 0;
        for (int row = 0; row < n; row++){  // Loop for each element of the matrix.
            for (int col = 0; col < n; col++) {
                if (row != currRow && col != currColumn) {
                    minor[i][j] = matrix[row][col]; //minor matrix is assigning.
                    j++;
                    if (j==n-1) {
                        i++;
                        j = 0;
                    }
                }
            }
        }
    }

    /**
     * Finding determinant method
     * @param matrix is coefficient matrix.
     * @param n is unknown size.
     * @return determinant.
     */
    private double findDeterminant(double matrix[][], int n)
    {
        double temp[][]=new double[n][n];
        int i,j,k;
        double determinant=0;
        if(n==1) { //n is equal to 1 condition.
            determinant=matrix[0][0];
        }
        else if(n==2) { //n is equal to 2 condition.
            determinant=( matrix[0][0]*matrix[1][1] ) - ( matrix[0][1]*matrix[1][0] );
        }
        //this loop for finding determinant by recursively.
        else
        {
            for(int p=0;p<n;p++) {
                int y=0;k=0;
                for(i=1;i<n;i++) {
                    for(j=0;j<n;j++) {
                        if(j==p)
                            continue;
                        temp[y][k]=matrix[i][j];
                        k++;
                        if(k==n-1) {
                            y++;
                            k=0;
                        }
                    }
                }
                determinant=determinant+(matrix[0][p]*Math.pow((-1),p)*findDeterminant(temp,n-1));
            }
        }
        return determinant;
    }

    /**
     *Returns whether matrix has a determinant or not.If not, this equation can not be solved.
     *  If det(A) != 0, Inverse Matrix = adj(A)/det(A)
     * @return whether there is a determinant or not.
     */
    private boolean inverse()
    {
        double det = findDeterminant(coeffMatrix, n);
        if (det == 0) {
            return false;
        }
        double [][]adj = new double[n][n];
        adjoint(adj);
        /*Inverse Matrix = adj(A)/det(A)*/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inv[i][j] = adj[i][j] / (double) det;
            }
        }
        return true;
    }

}
