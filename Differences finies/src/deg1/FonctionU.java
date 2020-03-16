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
public class FonctionU {
    /*dans cette classe, l'on rentre toutes les fonctions U que nous allons tester.
     A partir de ces fonctions, l'on fera correspondre les f que l'on attend (pour les
     différents tests. Par exemple si u est la fonction u(x)=x^2, le f correspondant sera la fonction f(x)=2.
    Chaque fonction f associée à une fonction u commence par une constante fixée dans la classe Func
    Ces fonctions sont statiques.*/

    public static double nulle(double x) { return 0;}

    public static double cte(double x){
        return 1.0;
    }
    
    public static double simplex(double x){
        return x;
    }
    
    public static double carrex(double x){
        return Math.pow(x, 2);
    }
    
    public static double cubex(double x){
        return Math.pow(x, 3);
    }
    
    public static double p5x(double x) {return Math.pow(x,5);}

    public static double cosx(double x){
        return Math.cos(x);
    }
    
    public static double sinx(double x){
        return Math.sin(x);
    }
    
    public static double exp(double x){
        return Math.exp(x);
    }

    public static double ln(double x) { return Math.log(x); }

}
