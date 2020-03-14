/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deg1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * @author ESDRAS
 */
public class Func {

    public double coef = 1.0;
    public Method method;
    public static String PREFIXE = "DR";
    public Func(Method method) {
        this.method = method;
    }

    public Func(double coef, Method method) {
        this.method = method;
        this.coef = coef;
    }

    public static ArrayList<Func> calcFonction(String fonction) throws NoSuchMethodException {
        String[] fonctions = fonction.split(";");
        double res = 0;
        ArrayList<Func> listeFunc = new ArrayList<>();

        for (int i = 0; i < fonctions.length; i++) {
            String[] singularFunc = fonctions[i].split(":");
            if (singularFunc == null || singularFunc.length == 0 || singularFunc.length > 2) {
                System.err.println("Syntaxe incorrecte des fonctions");
                return null;
            }
            if (singularFunc.length == 1) {
                Method method = Fonction.class.getMethod(singularFunc[0], double.class);
                listeFunc.add(new Func(method));
            }
            if (singularFunc.length == 2) {
                Method method = Fonction.class.getMethod(singularFunc[1], double.class);
                double coef = Double.parseDouble(singularFunc[0]);
                listeFunc.add(new Func(coef, method));
            }
        }

        return listeFunc;
    }

    public static String calcDerivee(String fonction) {
        /*creer la chaine dérivée de la fonction*/
        String[] fonctions = fonction.split(";");
        String res = "";

        for (int i = 0; i < fonctions.length; i++) {
            String[] singularFunc = fonctions[i].split(":");
            if (singularFunc == null || singularFunc.length == 0 || singularFunc.length > 2) {
                System.err.println("Syntaxe incorrecte des fonctions");
                return null;
            }
            if (singularFunc.length == 1) {
                res += Func.PREFIXE + singularFunc[0] + ";";
            }
            if (singularFunc.length == 2) {
                res += singularFunc[0] + ":" + Func.PREFIXE + singularFunc[1] + ";";
            }
        }
        
        return res;
    }

    public static double calcVal(double val, ArrayList<Func> listeFunc) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        double res = 0.0;

        for (Func fn : listeFunc) {
            res += fn.coef * ((Double) fn.method.invoke(null, val));
        }

        return res;
    }
}
