/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deg1;

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
public class DifferencesFinies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        System.out.println("Entrez le nombre n correspondant au nombre de points du maillage - 1");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(Afficharge.titre("Donnees de test pour la résolution de l'équation différentielle -u''=f"));

        ArrayList<DonneeTest> donneesTest = GenerationDonnee.getDonneesTest(n);

        Class solverInterface = Class.forName("deg1.Solver");
        SolverInterface solv = (SolverInterface) solverInterface.newInstance();
        int total = 0, totFalseDirec = 0, totFalseIter = 0;

        System.out.println(Afficharge.separation());
        System.out.println(Afficharge.creerLigne("f", "a", "b", "Tolérance", "Résultat attendu", "Fonction de test", "Oracle Methode Directe", "Oracle Methode itérative"));
        for (DonneeTest dt : donneesTest) {
            Matrix resultsDirecte = solv.resolveDirecte(dt.donneeEntree.f, dt.donneeEntree.a, dt.donneeEntree.b, dt.donneeEntree.n);
            Matrix resultsIter = solv.resolveIterative(dt.donneeEntree.f, dt.donneeEntree.a, dt.donneeEntree.b, dt.donneeEntree.n);

            Method method = TestFuncs.class.getMethod(dt.fonctionTest, String.class, Matrix.class, double.class, int.class);

            boolean decisionDirecte = (boolean) method.invoke(null, dt.resultatAttendu, resultsDirecte, dt.tolerance, dt.donneeEntree.n);
            boolean decisionIter = (boolean) method.invoke(null, dt.resultatAttendu, resultsIter, dt.tolerance, dt.donneeEntree.n);
            String ra = "null", ro = "null";

            System.out.println(Afficharge.creerLigne(dt.donneeEntree.f, Double.toString(dt.donneeEntree.a), Double.toString(dt.donneeEntree.b), Double.toString(dt.tolerance), dt.resultatAttendu, dt.fonctionTest, Boolean.toString(decisionDirecte), Boolean.toString(decisionIter)));
            if (!decisionDirecte) {
                totFalseDirec += 1;
            }
            if (!decisionIter) {
                totFalseIter += 1;
            }
            total += 1;

        }

        System.out.println("Total Tests Ratés Méthode Directe: " + totFalseDirec + "/" + " " + total + "             Total Tests Ratés Méthode Itérative: " + (totFalseIter) + "/" + " " + total);

        DifferencesFinies.calculPAlpha();
        DifferencesFinies.tracés();

    }

    public static void tracés() {
        Scanner sc = new Scanner(System.in);

        System.out.println(Afficharge.titre("Tracé des courbes pour une fonction"));

        System.out.println("Entrez la fonction resultatAttendu (en suivant la convention)");
        String func = sc.next();

        System.out.println("Entrez n1");
        int n1 = sc.nextInt();

        System.out.println("Entrez n2");
        int n2 = sc.nextInt();

        System.out.println("Entrez l'intervalle d'écart");
        int nb = sc.nextInt();

        Graphe.traceErreurs(func, n1, n2, nb, true);
        Graphe.traceErreurs(func, n1, n2, nb, false);
    }

    private static void calculPAlpha() {
        try {
            System.out.println(Afficharge.titre("Détermination de la vitesse de convergence"));
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Entrez la fonction resultatAttendu (en suivant la convention)");
            String func = sc.next();
            
            System.out.println("Entrez n1");
            int n1 = sc.nextInt();
            
            System.out.println("Entrez n2");
            int n2 = sc.nextInt();
            
            double[] valsDir = TestFuncs.calcPN(func, n1, n2, true);
            double[] valsIter = TestFuncs.calcPN(func, n1, n2, false);
            
            System.out.println("Fonction U réelle: " + func + "; Methode Directe: "
                    + "p = " + valsDir[0] + " alpha = " + valsDir[1] + " ; Methode Iterative: " + "p = " + valsIter[0] + " alpha = " + valsIter[1]);
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
}
