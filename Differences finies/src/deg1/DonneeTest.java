/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deg1;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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

    public DonneeTest(String nomScenario, Params donneeEntree, String fonctionATester, String fonctionTest, double tolerance, String resultatAttendu) {
        this.nomScenario = nomScenario;
        this.donneeEntree = donneeEntree;
        this.fonctionATester = fonctionATester;
        this.fonctionTest = fonctionTest;
        this.tolerance = tolerance;
        this.resultatAttendu = resultatAttendu;
    }

    public DonneeTest(String nomScenario, String fonctionATester, String fonctionTest, double tolerance, String resultatAttendu, int nb) {
        this.nomScenario = nomScenario;
        this.resultatAttendu = resultatAttendu;
        this.fonctionATester = fonctionATester;
        this.fonctionTest = fonctionTest;
        this.tolerance = tolerance;

        /*nb représente le nombre de points*/
        this.genererDonnee(nb);

    }

    public void genererDonnee(int n) {
        try {
            String func = Func.calcDerivee(this.resultatAttendu);
            double a = Func.calcVal(0, Func.calcFonction(resultatAttendu));
            double b = Func.calcVal(1, Func.calcFonction(resultatAttendu));
            this.donneeEntree = new Params(func, a, b, n);
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

    private ArrayList<Double> generer(double a, double b, double c) {
        ArrayList<Double> liste = new ArrayList();

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    liste = null;
                }
                if (c!=0) {
                    liste.add(-c);
                }
            }
            else{
                if (c==0){
                    liste.add(0.0);
                }
                else{
                    liste.add(-c);
                }
            }
        } else {
            if (b == 0) {
                if (c == 0) {
                    liste.add(0.0);
                }
                else{
                    liste.add(-c);
                }
            } else {
                if (c == 0) {
                    liste.add(0.0);
                    liste.add(((-1) * b));
                }
                else{
                    liste.add(((-1) * c));
                }
            }
        }
        return liste;
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
