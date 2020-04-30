/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplacedim2;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.ujmp.core.Matrix;

/**
 *
 * @author ESDRAS
 */
public class Graphe {

    public static void traceMatrice(String fonction, Matrix solObt, int n, int m) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        double[][] matrix = new double[m + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                matrix[i][j] = solObt.getAsDouble(i, j) - Func.calcVal(((double) i) / n, ((double) j) / m, Func.calcFonction(fonction));
            }
        }

        //Syef met les paramètres qui vont entrer dans ton way de graphe la ici
        //tous les elements sont dans la matrice, fait une fonction qui va permettre de trouver le min et le max
        //et tu passes ca en paramètre, bref trouve un moyen d'integrer en passant par la méthode ci dessous que tu peux modifier a ta guise
        Graphe.traceGraphes(matrix, valeursObtenues, valeursReelle, "obtenu", "attendu", "x", "y");
    }

    public static void traceGraphes(double[] abscisse, double[] valCourbe1, double[] valCourbe2, String titre1, String titre2, String titreX, String titreY) {
        //les titres correspondent respectivement aux courbes
        //tiens en compte pour les titres des méthodes

        Stage primaryStage = new Stage();

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel(titreX);
        yAxis.setLabel(titreY);
        //xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number, Number> lineChart
                = new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Courbes réelle/obtenue");

        //defining a series
        XYChart.Series series1 = new XYChart.Series();
        series1.setName(titre1);

        XYChart.Series series2 = new XYChart.Series();
        series2.setName(titre2);
        //populating the series with data
        for (int i = 0; i < abscisse.length; i++) {
            series1.getData().add(new XYChart.Data((Number) abscisse[i], (Number) (valCourbe1[i])));
            series2.getData().add(new XYChart.Data((Number) abscisse[i], (Number) (valCourbe2[i])));
        }
        //defining a series
        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
        Scene scene = new Scene(lineChart, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void traceGraphe(double[] abscisse, double[] ordonnees, String titre, String titreX, String titreY, String titreFig) {
        //trace la courbe. le titre de la courbe est passé en paramètre.

        Stage primaryStage = new Stage();
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel(titreX);
        yAxis.setLabel(titreY);
        //xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number, Number> lineChart
                = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle(titreFig);
        //defining a series
        XYChart.Series series = new XYChart.Series();
        //series.setName("My portfolio");
        //populating the series with data
        series.setName(titre);
        double min = ordonnees[0];
        for (int i = 0; i < abscisse.length; i++) {
            if (ordonnees[i] < min) {
                min = ordonnees[i];
            }
            series.getData().add(new XYChart.Data(1.0 / abscisse[i], (ordonnees[i])));
        }

        //xAxis.setLowerBound(abscisse[0]);
        //yAxis.setLowerBound(min);
        lineChart.getData().add(series);
        Scene scene = new Scene(lineChart, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void traceErreurs(String fonction, int n1, int m1, int n2, int m2, int nbX, int nbY, boolean methode, String titreFig) {
        //methode=true si cest la méthode directe et methode= false sinon
        //génère la courbe de l'erreur pour un nombre de points quittant de n1 a n2 par pas de nb

        try {
            int p = ((n2 - n1) / nbX);
            int q = ((m2 - m1) / nbY);

            double[] valAbs = new double[p + 1], valOrd = new double[q + 1], erreurs[] = new double[p + 1][q + 1];

            int indexX = 0;
            int indexY = 0;

            for (int i = n1; i <= n2; i += nbX) {
                valAbs[indexX] = i;
                indexX++;
            }
            for (int j = m1; j <= m2; j += nbY) {
                valOrd[indexY] = j;
                indexY++;
            }

            indexX = 0;
            indexY = 0;

            for (int i = n1; i <= n2; i += nbX) {
                for (int j = m1; i <= m2; i += nbY) {

                    erreurs[indexX][indexY] = Math.log(TestFuncs.calcErreur(fonction, i, j, methode));
                    indexY++;
                }
                indexY = 0;
                indexX++;
            }
            String titre = "Methode directe";
            if (!methode) {
                titre = "Methode itérative";
            }

            //Syef tu dois faire une courbe 3D ici, abscisse valAbs, ordonneé valOrd, fonction: erreurs
            //donc modifie la ligne qui suit là tu crées ta méthode, je vais t'envoyer les ressources pour le faire
            //Graphe.traceGraphe(valAbs, erreurs, fonction, "h", "log erreurs", titreFig);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Graphe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Graphe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Graphe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Graphe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Graphe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Graphe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
