/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplacedim2;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESDRAS
 */
public class DonneeTest {

    public String nomScenario; //nom du scénario
    public Params donneeEntree; //donnée d'entrée
    public String fonctionATester; //fonction à tester
    public String fonctionTest; //fonction de test
    public double tolerance; //tolerance
    public String resultatAttendu;

    public DonneeTest(String nomScenario, String fonctionATester, String fonctionTest, double tolerance, String resultatAttendu, int nb1, int nb2) {
        this.nomScenario = nomScenario;
        this.resultatAttendu = resultatAttendu;
        this.fonctionATester = fonctionATester;
        this.fonctionTest = fonctionTest;
        this.tolerance = tolerance;

        /*nb représente le nombre de points*/
        this.genererDonnee(nb1, nb2);

    }

    public void genererDonnee(int n, int m) {
        try {
            String func = Func.calcDerivee(this.resultatAttendu); 
            double [] tabX1 = new double[n-1], tabX2 = new double[n-1], tabY1 = new double[m+1], tabY2 = new double[m+1];
            
            for (int i = 0; i < n-1; i++){
                tabX1[i] = Func.calcVal(i + 1, 0, Func.calcFonction(resultatAttendu));
                tabX2[i] = Func.calcVal(i + 1, m, Func.calcFonction(resultatAttendu));
            }

            for (int i = 0; i < m + 1; i++){
                tabY1[i] = Func.calcVal(0, i, Func.calcFonction(resultatAttendu));
                tabY2[i] = Func.calcVal(n, i, Func.calcFonction(resultatAttendu));
            }
            
            this.donneeEntree = new Params(func, tabX1, tabX2, tabY1, tabY2, n, m);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(DonneeTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DonneeTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DonneeTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DonneeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        String chaine = donneeEntree.toString() + "   " + " RA: ";
        if (resultatAttendu == null) {
            return chaine + "null";
        }

        return chaine + resultatAttendu.toString();
    }
}
