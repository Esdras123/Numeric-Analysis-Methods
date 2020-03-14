/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deg1;

import java.lang.reflect.InvocationTargetException;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

/**
 *
 * @author ESDRAS
 */
public class TestFuncs {

    public static boolean identite(String fonction, Matrix solObt, double tolerance, int n) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Matrix solReelle = DenseMatrix.Factory.zeros(n - 1, 1);

        for (int i = 0; i < n - 1; i++) {
            solReelle.setAsDouble(Func.calcVal(((double) i + 1) / n, Func.calcFonction(fonction)), i, 0);
        }

        Matrix diff = solReelle.minus(solObt);
        return diff.norm2() < tolerance;
    }

    public static boolean erreurRel(String fonction, Matrix solObt, double tolerance, int n) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Matrix solReelle = DenseMatrix.Factory.zeros(n - 1, 1);
        double val;

        for (int i = 0; i < n - 1; i++) {
            solReelle.setAsDouble(Func.calcVal(((double) i + 1) / n, Func.calcFonction(fonction)), i, 0);
        }
        
        val = solReelle.norm2();
        Matrix diff = solReelle.minus(solObt);
        if (solReelle.norm2()!=0.0) {
            return diff.norm2()/val < tolerance;
        } else {
            return diff.norm2() == 0.0;
        }

    }
}
