/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplacedim2;

/**
 *
 * @author ESDRAS
 */
public class Params {
    public String f;
    public double[] tabX1;
    public double[] tabX2;
    public double[] tabY1;
    public double[] tabY2;
    public int n,m;
    
    @Override
    public String toString(){
        return "f: "+f+ "n :"+ n+" m: "+m;
    }

    public Params(String f, double[] tabX1, double[] tabX2, double[] tabY1, double[] tabY2, int n, int m) {
        this.f = f;
        this.tabX1 = tabX1;
        this.tabX2 = tabX2;
        this.tabY1 = tabY1;
        this.tabY2 = tabY2;
        this.n = n;
        this.m = m;
    }


    
}
