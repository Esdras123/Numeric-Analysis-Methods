/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplacedim2;

import org.ujmp.core.Matrix;

/**
 *
 * @author ESDRAS
 */
public interface SolverInterface {
    
    /*(n+1)*(m+1) représente le nombre de points, n etant dans le sens des abscisses et m des ordonnées
    tabX1 représente les valeurs d'initialisation de u aux points allant de (1, 0) à (n-1, 0)
    tabX2 représente les valeurs d'initialisation de u aux points allant de (1, m) à (n-1, m)
    tabY1 représente les valeurs d'initialisation de u aux points allant de (0, 0) à (0, m)
    tabY2 représente les valeurs d'initialisation de u aux points allant de (n, 0) à (n, m)
    
    La chaine de caracteres fonction est sous la forme
    "fonction" si l'on veut appeler f(x) et "a:fonction1;b:fonction2;...." 
    si l'on souhaite calculer a*f1(x)+b*f2(x)+....,
    l'ensemble des fonctions est dans Fonction. Chaque fonction est statique.*/
    Matrix resolveGauss(String fonction, double[] tabX1, double[] tabX2, double[] tabY1, double[] tabY2, int n, int m);
    Matrix resolveRelaxation (String fonction, double[] tabX1, double[] tabX2, double[] tabY1, double[] tabY2, int n, int m);
}
