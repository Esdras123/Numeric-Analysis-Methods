/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplacedim2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import org.ujmp.core.Matrix;

/**
 *
 * @author ESDRAS
 */
public class DifferencesFinies extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
        System.out.println("Entrez la taille du maillage pour le cas de test des solutions exactes (nbPts-1)");
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Pour le cas de test des solutions approchés, vous entrerez les entiers n1, n2 avec lesquels l'on calculera p et alpha");
        
        System.out.println("Entrez n1");
        TestFuncs.n1 = sc.nextInt();
        
        System.out.println("Entrez n2");
        TestFuncs.n2 = sc.nextInt();

        System.out.println(Afficharge.titre("Donnees de test pour la résolution de l'équation différentielle -u''=f"));

        ArrayList<DonneeTest> donneesTest = GenerationDonnee.getDonneesTest(n);

        Class solverInterface = Class.forName("deg1.Solver");
        SolverInterface solv = (SolverInterface) solverInterface.newInstance();
         */
        //int total = 0 /*,totFalseDirec = 0*/, totFalseIter = 0;

        //System.out.println("OMD = Oracle Méthode Directe");
        /*
        System.out.println("OMD = Oracle Méthode Itérative");
        System.out.println(Afficharge.separation());
         */
        //System.out.println(Afficharge.creerLigne("f", "a", "b", "Tolérance", "Résultat attendu", "Fonction de test", /*"O.M.D",*/ "O.M.I"));

        /*
        for (DonneeTest dt : donneesTest) {
            //Matrix resultsDirecte = solv.resolveDirecte(dt.donneeEntree.f, dt.donneeEntree.a, dt.donneeEntree.b, dt.donneeEntree.n);
            Matrix resultsIter = solv.resolveIterative(dt.donneeEntree.f, dt.donneeEntree.a, dt.donneeEntree.b, dt.donneeEntree.n);

            Method method;
            boolean decisionIter;
            if (dt.fonctionTest.equals("convMail")) {
                method = TestFuncs.class.getMethod(dt.fonctionTest, String.class);
                decisionIter = (boolean) method.invoke(null, dt.resultatAttendu);
            } else {
                method = TestFuncs.class.getMethod(dt.fonctionTest, String.class, Matrix.class, double.class, int.class);
                decisionIter = (boolean) method.invoke(null, dt.resultatAttendu, resultsIter, dt.tolerance, dt.donneeEntree.n);
            }
            //boolean decisionDirecte = (boolean) method.invoke(null, dt.resultatAttendu, resultsDirecte, dt.tolerance, dt.donneeEntree.n);

            //boolean decisionIter = false;
            String ra = "null", ro = "null";

            DecimalFormat df = new DecimalFormat("00.00E00");
         */
        //System.out.println(Afficharge.creerLigne(dt.donneeEntree.f, df.format(dt.donneeEntree.a), df.format(dt.donneeEntree.b), Double.toString(dt.tolerance), dt.resultatAttendu, dt.fonctionTest,/* Boolean.toString(decisionDirecte),*/ Boolean.toString(decisionIter)));
        /*
            if (!decisionDirecte) {
                totFalseDirec += 1;
            }
         */
 /*1
            if (!decisionIter) {
                totFalseIter += 1;
            }
            total += 1;

        }
         */
        //System.out.println(/*"Total Tests Ratés Méthode Directe: " + totFalseDirec + "/" + " " + total + */"Total Tests Ratés Méthode Itérative: " + (totFalseIter) + "/" + " " + total);

        /*
        Func.calculPAlpha();
        Func.traceCourbe();
        Func.tracés();
         */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        launch(args);

    }
}
