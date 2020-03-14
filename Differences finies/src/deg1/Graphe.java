/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deg1;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

/**
 *
 * @author ESDRAS
 */
public class Graphe {

    public static void traceMatrice(String fonction, Matrix solObt, int n) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        double[] valeursReelle = new double[n + 1], valeursObtenues = new double[n + 1], valAbscisse = new double[n + 1];

        valeursObtenues[0] = solObt.getAsDouble(0, 0);
        for (int i = 0; i < n - 1; i++) {
            valAbscisse[i] = (double) i / n;
            valeursReelle[i + 1] = Func.calcVal(((double) i + 1) / n, Func.calcFonction(fonction));
            valeursObtenues[i + 1] = solObt.getAsDouble(i, 0);
        }
        valeursReelle[0] = Func.calcVal(0, Func.calcFonction(fonction));
        valeursReelle[n] = Func.calcVal(1, Func.calcFonction(fonction));
        valeursObtenues[0] = valeursReelle[0];
        valeursObtenues[n] = valeursReelle[n];

        //tracé des deux fonctions sur un meme graphique
        Graphe.traceGraphes(valAbscisse, valeursObtenues, valeursReelle, "obtenu", "attendu");
    }

    public static void traceGraphes(double[] valAbs, double[] valCourbe1, double[] valCourbe2, String titre1, String titre2) {
        //les titres correspondent respectivement aux courbes
        //tiens en compte pour les titres des méthodes

    }

    public static void traceGraphe(double[] valAbs, double[] valCourbe, String titre) {
        //trace la courbe. le titre de la courbe est passé en paramètre.
    }

    public static void traceErreurs(String fonction, int n1, int n2, int nb, boolean methode) {
        //methode=true si cest la méthode directe et methode= false sinon
        //génère la courbe de l'erreur pour un nombre de points quittant de n1 a n2 par pas de nb

        try {
            int p = ((n2 - n1) / nb);
            double[] valAbs = new double[p + 1], erreurs = new double[p + 1];

            int index = 0;
            for (int i = n1; i <= n2; i += nb) {

                valAbs[index] = i;
                erreurs[index] = TestFuncs.calcErreur(fonction, i, methode);
            }
            String titre = "Methode directe";
            if (!methode) {
                titre = "Methode itérative";
            }
            Graphe.traceGraphe(valAbs, erreurs, fonction);
        
        
        
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
