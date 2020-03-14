/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deg1;

/**
 *
 * @author ESDRAS
 */
public class Params {
    public String f;
    public double a, b;
    public int n;
    
    @Override
    public String toString(){
        return "f: "+f+ "a :"+ a+" b: "+b+" n: "+n+" ";
    }

    public Params(String f, double a, double b, int n) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.n = n;
    }
    
    
}
