/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deg1;

import java.lang.reflect.Method;

/**
 *
 * @author ESDRAS
 */
public class Func {
    public double coef = 1.0;
    public Method method;

    public Func(Method method) {
        this.method = method;
    }
    
    public Func(double coef, Method method) {
        this.method = method;
        this.coef = coef;
    }
}
