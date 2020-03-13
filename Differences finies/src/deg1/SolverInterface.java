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
    u(1),  La chaine de caracteres fonction est sous la forme
    "fonction" si l'on veut appeler f(x) et "a:fonction1;b:fonction2;...." 
    si l'on souhaite calculer a*f1(x)+b*f2(x)+....,
    l'ensemble des fonctions est dans Fonction. Chaque fonction est statique.*/
    Matrix resolveDirecte(String fonction, double a, double b, int n);
    Matrix resolveIterative(String fonction, double a, double b, int n);
}
