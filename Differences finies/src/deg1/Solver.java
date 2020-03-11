/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deg1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

/**
 *
 * @author ESDRAS
 */
public class Solver implements SolverInterface{

    @Override
    public Matrix resolveLU(String fonction, double a, double b, int n) {
        try {
            Matrix f = DenseMatrix.Factory.zeros(n-1,1);
            
            //remplissage de f
            Method method = Fonction.class.getMethod(fonction, double.class);
            for (int i = 0; i <n-1; i++){
                f.setAsDouble((Double) method.invoke(null, ((double) i)/n), i, 0);
            }
            return null;
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
    public Matrix resolveIT(String fonction, double a, double b, int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
