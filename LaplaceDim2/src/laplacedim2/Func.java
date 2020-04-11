/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplacedim2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ujmp.core.Matrix;

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
                Method method = Fonction.class.getMethod(singularFunc[0], double.class, double.class);
                listeFunc.add(new Func(method));
            }
            if (singularFunc.length == 2) {
                Method method = Fonction.class.getMethod(singularFunc[1], double.class, double.class);
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

    public static double calcVal(double x, double y, ArrayList<Func> listeFunc) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        double res = 0.0;

        for (Func fn : listeFunc) {
            res += fn.coef * ((Double) fn.method.invoke(null, x, y));
        }

        return res;
    }
    /*
    public static void traceCourbe() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException{
        Scanner sc = new Scanner(System.in);

        System.out.println(Afficharge.titre("Comparaison de la solution exacte et de la solution approchée pour une fonction"));

        System.out.println("Entrez la fonction resultatAttendu (en suivant la convention)");
        String func = sc.next();

        System.out.println("Entrez n");
        int n = sc.nextInt();
        
        double a = Func.calcVal(0, Func.calcFonction(func));
        double b = Func.calcVal(1, Func.calcFonction(func));
        
        Class solverInterface = Class.forName("laplacedim2.Solver");
        SolverInterface solv = (SolverInterface) solverInterface.newInstance();
        
        String fonctionDerivee = Func.calcDerivee(func);
        Matrix results1;
        results1 = solv.resolveIterative(fonctionDerivee, a, b, n);

        Graphe.traceMatrice(func, results1, n);
        //Graphe.traceErreurs(func, n1, n2, nb, false);
    }

    public static void tracés() {
        Scanner sc = new Scanner(System.in);

        System.out.println(Afficharge.titre("Tracé de l'évolution des erreurs pour une fonction"));

        System.out.println("Entrez la fonction resultatAttendu (en suivant la convention)");
        String func = sc.next();

        System.out.println("Entrez n1");
        int n1 = sc.nextInt();

        System.out.println("Entrez n2");
        int n2 = sc.nextInt();

        System.out.println("Entrez l'intervalle d'écart");
        int nb = sc.nextInt();

        Graphe.traceErreurs(func, n1, n2, nb, false, "Tracé des erreurs en fonction de h");
        //Graphe.traceErreurs(func, n1, n2, nb, false);
    }
    
    public static void calculPAlpha() {
        try {
            System.out.println(Afficharge.titre("Détermination de la vitesse de convergence"));
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Entrez la fonction resultatAttendu (en suivant la convention)");
            String func = sc.next();
            
            System.out.println("Entrez n1");
            int n1 = sc.nextInt();
            
            System.out.println("Entrez n2");
            int n2 = sc.nextInt();
            
            //double[] valsDir = TestFuncs.calcPN(func, n1, n2, true);
            double[] valsIter = TestFuncs.calcPN(func, n1, n2, false);
            System.out.println("Fonction U réelle: " + func + " ; Methode Iterative: " + "p = " + valsIter[0] + " Log alpha = " + valsIter[1]);
        } catch (InstantiationException ex) {
            Logger.getLogger(DifferencesFinies.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DifferencesFinies.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(DifferencesFinies.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DifferencesFinies.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DifferencesFinies.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DifferencesFinies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
}
