/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplacedim2;

/**
 *
 * @author DAGANG
 */
public class Fonction {

    /*classe contenant l'ensemble des fonctions à tester. Chaque fonction est 
    statique et a un deux paramètres qui sont double
     */

    //Fonctions

    public static double x(double x, double y) {
        return x;
    }

    public static double y(double x, double y) {
        return y;
    }

    public static double produit(double x, double y) {
        return x * y;
    }

    public static double nulle(double x, double y) {
        return 0.0;
    }

    public static double cte(double x, double y){
        return 1.0;
    }

    public static double somme(double x, double y){
        return x + y;
    }

    public static double puissance(double x, double y){
        return Math.pow(x, y);
    }

    public static double cosx(double x, double y){
        return Math.cos(x);
    }

    public static double sinx(double x, double y){
        return Math.sin(x);
    }

    public static double cosy(double x, double y){
        return Math.cos(y);
    }

    public static double siny(double x, double y){
        return Math.sin(y);
    }

    public static double cosSomme(double x, double y){
        return Math.cos(x + y);
    }

    public static double sinSomme(double x, double y){
        return Math.sin(x + y);
    }

    public static double cosProduit(double x, double y){
        return Math.cos(x * y);
    }

    public static double sinProduit(double x, double y){
        return Math.sin(x * y);
    }

    public static double expx(double x, double y){
        return Math.exp(x);
    }

    public static double expy(double x, double y){
        return Math.exp(y);
    }

    public static double expSomme(double x, double y){
        return Math.exp(x * y);
    }

    public static double expProduit(double x, double y){
        return Math.exp(x * y);
    }

    public static double lnx(double x, double y) {
        return Math.log(x);
    }

    public static double lny(double x, double y) {
        return Math.log(y);
    }

    public static double lnSomme(double x, double y) {
        return Math.log(x + y);
    }

    public static double lnProduit(double x, double y) {
        return Math.log(x * y);
    }



    //Derivees

    public static double DRx(double x, double y) {
        return 0.0;
    }

    public static double DRy(double x, double y) {
        return 0.0;
    }

    public static double DRproduit(double x, double y) {
        return 0.0;
    }

    public static double DRnulle(double x, double y) {
        return 0.0;
    }

    public static double DRcte(double x, double y){
        return 0.0;
    }

    public static double DRsomme(double x, double y){
        return 0.0;
    }

    public static double DRpuissance(double x, double y){
        return -( y * (y - 1) * Math.pow(x, y - 2) + Math.pow(Math.log(x), 2) * Math.pow(x, y));
    }

    public static double DRcosx(double x, double y){
        return -Math.cos(x);
    }

    public static double DRsinx(double x, double y){
        return -Math.sin(x);
    }

    public static double DRcosy(double x, double y){
        return -Math.cos(y);
    }

    public static double DRsiny(double x, double y){
        return -Math.sin(y);
    }

    public static double DRcosSomme(double x, double y){
        return 2.0 * Math.cos(x + y);
    }

    public static double DRsinSomme(double x, double y){
        return 2.0 * Math.sin(x + y);
    }

    public static double DRcosProduit(double x, double y){
        return (Math.pow(x, 2) + Math.pow(y, 2)) * Math.cos(x * y);
    }

    public static double sinProduit(double x, double y){
        return (Math.pow(x, 2) + Math.pow(y, 2)) * Math.sin(x * y);
    }

    public static double expx(double x, double y){
        return - Math.exp(x);
    }

    public static double expy(double x, double y){
        return - Math.exp(y);
    }

    public static double expSomme(double x, double y){
        return -2.0 * Math.exp(x * y);
    }

    public static double expProduit(double x, double y){
        return -((Math.pow(x, 2) + Math.pow(y, 2)) * Math.exp(x * y));
    }

    public static double lnx(double x, double y) {
        return 1.0 / Math.pow(x, 2);
    }

    public static double lny(double x, double y) {
        return 1.0 / Math.pow(y, 2);
    }

    public static double lnSomme(double x, double y) {
        return 2.0 / Math.pow(x + y, 2);
    }

    public static double lnProduit(double x, double y) {
        return ( 1.0 / Math.pow(x, 2) + 1.0 / Math.pow(y, 2) );
    }
}
