/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplacedim2;

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
        //System.out.println(solv.resolveIterative("doublex", 0, 1, 10));
    }

    public Matrix[] initMatrix(String fonction, double[] tabX1, double[] tabX2, double[] tabY1, double[] tabY2, int n, int m) {
        try {
            //cette méthode a pour but d'initialiser les matrices A et b permettant de résoudre Ax = b dans 
            //le cadre de l'équation de Laplace
            //il faut donc remplir A comme demandé dans le cours
            //ainsi que b

            //initialisation des matrices A et b
            //il faut mettre les valeurs correctes des dimensions dans les parenthèses
            Matrix b = DenseMatrix.Factory.zeros(n - 1, 1);
            SparseMatrix A = SparseMatrix.Factory.zeros(n - 1, n - 1);

            //creation dynamique de la fonction f (de l'équation Delta U = f). Cette fonction permettra de calculer des valeurs du style f(x,y)
            ArrayList<Func> listeFunc = Func.calcFonction(fonction);

            //la section qui suit est pour aider a aller vite, je met en commentaire, avec ca vous verrez comment initialiser un element de la matrice

            /*
            for (int i = 0; i < n - 1; i++) {
                val = Func.calcVal(((double) i), ((double) j)), listeFunc); // lorsqu'on veut calculer val = f(i,j), c'est juste a titre d'exemple
                A.setAsDouble(val, i, j); //ceci permet de mettre val a la position i,j de la matrice, a noter que le premier element de la matrice est (0,0) et non (1,1)
            }
            //cette boucle n'a pas de sens réel et est juste là pour faire découvrir les fonctions calcVal et setAsDouble
            //naturellement apres faut tester
             */
            //l'initialisation de A et b commencent ici
            //le travail s'achève ici, ne rien modifier en dessous
            Matrix[] retour = {A, b};
            return retour;

        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Matrix resolveGauss(String fonction, double[] tabX1, double[] tabX2, double[] tabY1, double[] tabY2, int n, int m) {
        Matrix[] matrix = this.initMatrix(fonction, tabX1, tabX2, tabY1, tabY2, n, m);

        if (matrix != null) {
            Matrix A = matrix[0], b = matrix[1];

            //la méthode peut être écrite ici
            
            return null;
        }
        else{
            throw new UnsupportedOperationException("A et b non créés correctement");
        }
    }

    @Override
    public Matrix resolveRelaxation(String fonction, double[] tabX1, double[] tabX2, double[] tabY1, double[] tabY2, int n, int m) {
        Matrix[] matrix = this.initMatrix(fonction, tabX1, tabX2, tabY1, tabY2, n, m);

        if (matrix != null) {
            Matrix A = matrix[0], b = matrix[1];

            //la méthode peut être écrite ici
            
            return null;
        }
        else{
            throw new UnsupportedOperationException("A et b non créés correctement");
        }
    }

}
