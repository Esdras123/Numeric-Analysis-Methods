/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deg1;

import java.lang.reflect.Method;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

/**
 *
 * @author ESDRAS
 */
public class Solver implements SolverInterface{

    @Override
    public Matrix resolve(String fonction, double a, double b, int n) {
        Matrix dense = DenseMatrix.Factory.zeros(n-1,1);
        Method method = Fonction.class.getMethod(fonction, double.class);
        for (int i = 0; i <n-1; i++){
            
        }
        return null;
    }

    
}
