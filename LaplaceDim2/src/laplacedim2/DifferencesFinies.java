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
import java.util.logging.Level;
import java.util.logging.Logger;
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
        int answer = -1;

        while (answer != 0) {
            System.out.println("PARTIE 1: Test de plusieurs cas de test et détermination de l'Oracle");
            System.out.println("PARTIE 2: Calcul de la vitesse de convergence pour une fonction");
            System.out.println("PARTIE 3: Tracé de la courbe d'une fonction (différence entre la solObtenue et la vraie fonction");
            System.out.println("PARTIE 4: Présentation de l'évolution de la courbe d'erreur d'une fonction");

            System.out.println("Choisissez une partie et entrez le numéro correspondant (i pour PARTIE i) ou entrez 0 pour sortir");

            Scanner sc = new Scanner(System.in);
            answer = sc.nextInt();

            if (answer == 1) {
                testsCas();
            }
            if (answer == 2) {
                Func.calculPAlpha();
            }
            if (answer == 3) {
                System.out.println("Quelle methode voulez vous tester? (1 pour Gauss Seidel et 2 pour Relaxation)");
                int bool = sc.nextInt();
                if (bool == 1) {
                    Func.traceCourbe(true);
                }
                if (bool == 2) {
                    Func.traceCourbe(false);
                }
            }
            if (answer == 4) {
                System.out.println("De quelle methode voulez vous voir l'évolution des erreurs? (1 pour Gauss Seidel et 2 pour Relaxation)");
                int bool = sc.nextInt();
                if (bool == 1) {
                    Func.tracés(true);
                }
                if (bool == 2) {
                    Func.tracés(false);
                }
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        launch(args);

    }

    public static void testsCas() throws InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        try {
            System.out.println("Intialisation du maillage (n-1, m-1) pour les solutions exactes");
            System.out.println("Entrez n-1");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println("Entrez m-1");
            int m = sc.nextInt();
            System.out.println("Pour le cas de test des solutions approchés, vous entrerez les couplets (n1, m1) et (n2, m2) avec lesquels l'on calculera p et alpha");
            System.out.println("Entrez n1");
            TestFuncs.n1 = sc.nextInt();
            System.out.println("Entrez m1");
            TestFuncs.m1 = sc.nextInt();
            System.out.println("Entrez n2");
            TestFuncs.n2 = sc.nextInt();
            System.out.println("Entrez m2");
            TestFuncs.m2 = sc.nextInt();
            System.out.println(Afficharge.titre("Donnees de test pour la résolution de l'équation différentielle"));
            ArrayList<DonneeTest> donneesTest = GenerationDonnee.getDonneesTest(n, m);
            Class solverInterface = Class.forName("laplacedim2.Solver");
            SolverInterface solv = (SolverInterface) solverInterface.newInstance();
            int total = 0, totFalseGaussPar = 0, totFalseRelaxation = 0;
            System.out.println("OMG = Oracle Méthode Gauss Parallèle");
            System.out.println("OMR = Oracle Méthode Relaxation");
            System.out.println(Afficharge.separation());
            System.out.println(Afficharge.creerLigne("f", "n", "m", "Tolérance", "Résultat attendu", "Fonction de test", "O.M.G", "O.M.D"));
            for (DonneeTest dt : donneesTest) {

                Method method;
                boolean decisionRelaxation = false;
                boolean decisionGaussPar = false;

                if (dt.fonctionTest.equals("convMail")) {
                    method = TestFuncs.class.getMethod(dt.fonctionTest, String.class, boolean.class);
                    decisionGaussPar = (boolean) method.invoke(null, dt.resultatAttendu, true);
                    decisionRelaxation = (boolean) method.invoke(null, dt.resultatAttendu, false);
                } else {
                    Matrix resultsGaussPar = solv.resolveGauss(dt.donneeEntree.f, dt.donneeEntree.tabX1, dt.donneeEntree.tabX2, dt.donneeEntree.tabY1, dt.donneeEntree.tabY2, dt.donneeEntree.n, dt.donneeEntree.m);
                    Matrix resultsRelaxation = solv.resolveRelaxation(dt.donneeEntree.f, dt.donneeEntree.tabX1, dt.donneeEntree.tabX2, dt.donneeEntree.tabY1, dt.donneeEntree.tabY2, dt.donneeEntree.n, dt.donneeEntree.m);

                    method = TestFuncs.class.getMethod(dt.fonctionTest, String.class, Matrix.class, double.class, int.class);
                    decisionGaussPar = (boolean) method.invoke(null, dt.resultatAttendu, resultsGaussPar, dt.tolerance, dt.donneeEntree.n);
                    decisionRelaxation = (boolean) method.invoke(null, dt.resultatAttendu, resultsRelaxation, dt.tolerance, dt.donneeEntree.n);
                }

                String ra = "null", ro = "null";

                DecimalFormat df = new DecimalFormat("00.00E00");

                System.out.println(Afficharge.creerLigne(dt.donneeEntree.f, df.format(dt.donneeEntree.n), df.format(dt.donneeEntree.m), Double.toString(dt.tolerance), dt.resultatAttendu, dt.fonctionTest, Boolean.toString(decisionGaussPar), Boolean.toString(decisionRelaxation)));

                if (!decisionGaussPar) {
                    totFalseGaussPar += 1;
                }
                if (!decisionRelaxation) {
                    totFalseRelaxation += 1;
                }
                total += 1;
            }
            System.out.println("Total Tests Ratés Méthode Gauss Parallèle: " + totFalseGaussPar + "/" + " " + total + "Total Tests Ratés Méthode Relaxation: " + (totFalseRelaxation) + "/" + " " + total);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DifferencesFinies.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
