/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deg1;

import org.ujmp.core.Matrix;

/**
 *
 * @author ESDRAS
 */
public interface SolverInterface {
    
    /*n+1 représente le nombre de points, a et b représentent u(0) et 
    u(1), fonction représente le nom de la fonction (statique) qu'on veut appeler,
    l'ensemble des fonctions : Fonction*/
    Matrix resolve(String fonction, int n, double a, double b);
}
