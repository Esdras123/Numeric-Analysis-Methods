/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deg1;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.SparseMatrix;

/**
 *
 * @author ESDRAS
 */
public class Solver implements SolverInterface {

    public static void main(String[] args) {
        Solver solv = new Solver();
        System.out.println(solv.resolveIterative("doublex", 0, 1, 10));
    }

    @Override
    public Matrix resolveDirecte(String fonction, double a, double b, int n) {
        try {
            Matrix f = DenseMatrix.Factory.zeros(n - 1, 1);
            SparseMatrix matrix = SparseMatrix.Factory.zeros(n - 1, n - 1);

            //remplissage de f et de la matrice creuse
            ArrayList<Func> listeFunc = Func.calcFonction(fonction);

            //boolean polDegInf2 = true;
            double cte = Func.calcVal(((double) 1) / n, listeFunc), val;

            for (int i = 0; i < n - 1; i++) {
                val = Func.calcVal(((double) i + 1) / n, listeFunc);
                if (i == 0) {
                    f.setAsDouble(val / Math.pow(n, 2) + a, i, 0);
                } else if (i == n - 2) {
                    f.setAsDouble(val / Math.pow(n, 2) + b, i, 0);
                } else {
                    f.setAsDouble(val / Math.pow(n, 2), i, 0);
                }

                matrix.setAsDouble(2, i, i);
                if (i < n - 2) {
                    matrix.setAsDouble(-1, i + 1, i);
                    matrix.setAsDouble(-1, i, i + 1);
                }
            }

            //System.out.println(matrix);
            //System.out.println(f);
            /*
            //resolution matrix= lu x = u^-1 (l^-1 f)
            Matrix[] luDecomp = matrix.lu();
            //System.out.println(luDecomp[1]);
            Matrix sol = luDecomp[1].inv().mtimes((luDecomp[0].inv().mtimes(f)));*/
            Matrix sol = DenseMatrix.Factory.zeros(n - 1, 1);

            /*
            if (polDegInf2) {
                double val1 = b + 0.5 * cte - a;
                for (int i = 0; i < n - 1; i++) {
                    double x = ((double) (i + 1)) / n;
                    System.out.println("cte= " + cte + "a= " + a + " b= " + b + " x= " + x + " val1= " + val1);
                    sol.setAsDouble(-0.5 * cte * Math.pow(x, 2) + val1 * x + a, i, 0);
                }
                System.out.println("VAL 1: " + (0.5 * cte * Math.pow(1, 2) + val1 * 1 + a));
            } else {
                sol = matrix.solve(f);
            }
             */
            sol = matrix.solve(f);
            return sol;
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Matrix resolveIterative(String fonction, double a, double b, int n) {
        try {
            Matrix f = DenseMatrix.Factory.zeros(n - 1, 1);
            SparseMatrix matrix = SparseMatrix.Factory.zeros(n - 1, n - 1);

            //remplissage de f et de la matrice creuse
            ArrayList<Func> listeFunc = Func.calcFonction(fonction);

            //boolean polDegInf2 = true;
            double cte = Func.calcVal(((double) 1) / n, listeFunc), val;

            for (int i = 0; i < n - 1; i++) {
                val = Func.calcVal(((double) i + 1) / n, listeFunc);
                /*
                if (val != cte) {
                    polDegInf2 = false;
                }
                 */

                if (i == 0) {
                    f.setAsDouble(val / Math.pow(n, 2) + a, i, 0);
                } else if (i == n - 2) {
                    f.setAsDouble(val / Math.pow(n, 2) + b, i, 0);
                } else {
                    f.setAsDouble(val / Math.pow(n, 2), i, 0);
                }

                matrix.setAsDouble(2, i, i);
                if (i < n - 2) {
                    matrix.setAsDouble(-1, i + 1, i);
                    matrix.setAsDouble(-1, i, i + 1);
                }
            }

            //System.out.println(matrix);
            //System.out.println(f);
            /*
            //resolution matrix= lu x = u^-1 (l^-1 f)
            Matrix[] luDecomp = matrix.lu();
            //System.out.println(luDecomp[1]);
            Matrix sol = luDecomp[1].inv().mtimes((luDecomp[0].inv().mtimes(f)));*/
            Matrix sol = DenseMatrix.Factory.zeros(n - 1, 1);

            /*
            if (polDegInf2) {
                double val1 = b - cte / 2.0 - a;
                for (int i = 0; i < n - 1; i++) {
                    double x = ((double) (i + 1)) / n;
                    sol.setAsDouble(0.5 * cte * Math.pow(x, 2) + val1 * x + a, i, 0);
                }
            } else {
                GaussSeidel solver = new GaussSeidel(matrix, f);
                sol = solver.solveSystem(1000);
            }
             */
            GaussSeidel solver = new GaussSeidel(matrix, f);
            sol = solver.solveSystem(1000);
            return sol;

        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
