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
            if(!decisionIter){
                totFalseIter += 1;
            }
            total += 1;

        }

        System.out.println("Total Tests Ratés Méthode Directe: " + totFalseDirec + "/" + " " + total + "             Total Tests Ratés Méthode Itérative: " + (totFalseIter) + "/" + " " + total);

    }

}
