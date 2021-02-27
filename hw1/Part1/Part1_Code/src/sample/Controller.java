package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.*;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is controller class for interface controlling.
 */
public class Controller implements Initializable {
    /*Interface variables.*/
    @FXML
    private TextField txt;
    @FXML
    private TextField unknownSize;
    @FXML
    private TextField result;

    double[][] coefficientMatrix;
    double[]   constantsMatrix, x;
    String[] arrOfStr;
    String  res;
    int        n;   // Number of variables


    /**
     * If gauss elimination method was selected in interface
     * @param event for getting an action from button.
     */
    @FXML
    void gauss_elimination(ActionEvent event) {
        String message=txt.getText(); //get equation in text file.
        arrOfStr = message.split("[ ,|]+"); //split equation.

        JOptionPane.showMessageDialog(null, "GAUSS");
        /*If number of unknowns was not writed, print error message.*/
        if(unknownSize.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Error! Please write unknown size in interface!");

        n = Integer.parseInt(unknownSize.getText().trim()); //getting number of unknowns.

        init(); //creating  coefficients matrix and constants array from interface.

        /*Select method with dynamic binding.*/
        Solver solver=new Solver();
        solver.setSolver(new GaussianElimination());
        x=solver.solveEquation(coefficientMatrix,constantsMatrix);

        if(x[0]==Double.MAX_VALUE) { //if lineear equation has not a solution.
            result.setText("Error! The linear equation does not have a solution.");
        }
        else {
            String resultTxt="";
            for (int i = 0; i < n; i++) {
                if(i==(n-1))
                    resultTxt= resultTxt.concat("x" + String.valueOf(i + 1) + " = " + String.valueOf(x[i]));
                else
                    resultTxt= resultTxt.concat("x" + String.valueOf(i + 1) + " = " + String.valueOf(x[i]) +" , ");
            }
            result.setText(resultTxt);
        }
    }

    /**
     * If  matrix inversion method is selected in interface
     * @param event for getting an action from button.
     */
    @FXML
    void matrix_inversion(ActionEvent event) {
        String message=txt.getText();
        arrOfStr = message.split("[ ,|]+");

        JOptionPane.showMessageDialog(null, "MATRIX INVERSION");

        /*If number of unknowns was not writed, print error message.*/
        if(unknownSize.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Error! Please write unknown size in interface!");

        n = Integer.parseInt(unknownSize.getText().trim()); //getting number of unknowns.
        init();//creating  coefficients matrix and constants array from interface.

        /*Select method with dynamic binding.*/
        Solver solver=new Solver();
        solver.setSolver(new MatrixInversion());
        x=solver.solveEquation(coefficientMatrix,constantsMatrix);

        System.out.println();
        if(x[0]==Double.MAX_VALUE) { //if lineear equation has not a solution.
            result.setText("Error! The linear equation does not have a solution.");
        }
        else {
            String resultTxt="";
            for (int i = 0; i < n; i++) {
                if(i==(n-1))
                    resultTxt= resultTxt.concat("x" + String.valueOf(i + 1) + " = " + String.valueOf(x[i]));
                else
                    resultTxt= resultTxt.concat("x" + String.valueOf(i + 1) + " = " + String.valueOf(x[i]) +" , ");
            }
            System.out.println(resultTxt);
            result.setText(resultTxt);
        }
    }

    /**
     * This function parsing linear equation text field
     * for getting coefficients and constants in matrix.
     */
    public void init(){

        coefficientMatrix = new double[n][n];
        constantsMatrix = new double[n];
        int z=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                coefficientMatrix[i][j] = Double.parseDouble(arrOfStr[z].trim()); //coefficient matrix is created.
                z++;
            }
            constantsMatrix[i] = Double.parseDouble(arrOfStr[z].trim()); //constants array is created.
            z=z+1;

        }
    }

    /**
     * for controller method must be written for implementing Initializable interface.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
