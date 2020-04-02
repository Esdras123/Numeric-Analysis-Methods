/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplacedim2;

import java.lang.reflect.InvocationTargetException;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

/**
 *
 * @author ESDRAS
 */
public class TestFuncs {
    public static int n1 = 10;
    public static int n2 = 200;
    public static int m1 = 10;
    public static int m2 = 200;
    
    public static boolean convMail(String fonction) throws InstantiationException, IllegalAccessException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
        double[] PN = TestFuncs.calcPN(fonction, n1, n2, m1, m2, false);
        
        if(PN[0]>=(2.0- 10E-10)){
            return true;
        }
        return false;
    }
    
    public static boolean erreurRel(String fonction, Matrix solObt, double tolerance, int n) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Matrix solReelle = DenseMatrix.Factory.zeros(n - 1, 1);
        double val;

        for (int i = 0; i < n - 1; i++) {
            solReelle.setAsDouble(Func.calcVal(((double) i + 1) / n, Func.calcFonction(fonction)), i, 0);
        }
        
        val = solReelle.normInf();
        Matrix diff = solReelle.minus(solObt);
        if (solReelle.normInf()!=0.0) {
            return diff.normInf()/val < tolerance;
        } else {
            return diff.normInf() == 0.0;
        }
    }
    
    public static double[] calcPN(String fonction, int n1, int n2, boolean methode) throws InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{
        //methode=true s i c'est la méthode directe et false sinon.
        
        double err1 = TestFuncs.calcErreur(fonction, n1, methode);
        double err2 = TestFuncs.calcErreur(fonction, n2, methode);
        
        double p = (Math.log(err2) - Math.log(err1))/(Math.log(n1) - Math.log(n2));
        double alpha = (Math.log(err1) + p* Math.log(n1));
        double[] resultat = {p,alpha};
        
        return resultat;
    }
    
    public static double calcErreur(String fonction, int n1, boolean methode) throws NoSuchMethodException, NoSuchMethodException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalArgumentException, IllegalArgumentException, InvocationTargetException, InvocationTargetException, ClassNotFoundException, InstantiationException{
        double a = Func.calcVal(0, Func.calcFonction(fonction));
        double b = Func.calcVal(1, Func.calcFonction(fonction));
        
        Class solverInterface = Class.forName("deg1.Solver");
        SolverInterface solv = (SolverInterface) solverInterface.newInstance();
        
        String fonctionDerivee = Func.calcDerivee(fonction);
        Matrix results1;
        if (methode){
            results1 = solv.resolveDirecte(fonctionDerivee, a, b, n1);
        }   
        else{
            results1 = solv.resolveIterative(fonctionDerivee, a, b, n1);
        }
        
        Matrix solReelle1 = DenseMatrix.Factory.zeros(n1 - 1, 1);

        for (int i = 0; i < n1 - 1; i++) {
            solReelle1.setAsDouble(Func.calcVal(((double) i + 1) / n1, Func.calcFonction(fonction)), i, 0);
        }
        
        double err1 = (solReelle1.minus(results1).normInf());
        //System.out.println("erreur " + err1);
        return err1;
    }
}
