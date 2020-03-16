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
public class Fonction {

    /*classe contenant l'ensemble des fonctions à tester. Chaque fonction est 
    statique et a un seul paramètre qui est un double
     */

    public static double carre(double x) {
        return x * x;
    }

    public static double constante(double x) {
        return 0;
    }

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

    public static double doublex(double x) {
        return 2 * x;
    }

    public static double DRnulle(double x) {return 0.0;}

    public static double DRcte(double x) {
        return 0.0;
    }

    public static double DRsimplex(double x) {
        return 0.0;
    }

    public static double DRcarrex(double x) {
        return -2;
    }

    public static double DRcubex(double x) {
        return -6*x;
    }

    public static double DRp5x(double x) {
        return -20*Math.pow(x,3);
    }

    public static double DRcosx(double x) {
        return Math.cos(x);
    }

    public static double DRsinx(double x) {
        return Math.sin(x);
    }

    public static double DRexp(double x) {
        return - Math.exp(x);
    }

    public static double DRln(double x) {
        return -(1/Math.pow(x,2));
    }
}
