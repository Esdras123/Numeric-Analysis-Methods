package deg1;

import java.io.IOException;
import java.util.ArrayList;

public class Afficharge {

    public static String titre(String titre) {
        //	System.out.println(titre.length());
        String affiche = "";
        String debut = "*************************************************************************************************************************************************************************************************************************\n";

        StringBuilder sb = new StringBuilder();
        sb.append(debut);
        sb.append("*");
        sb.append(espaces(debut.length() - 3));
        sb.append("*\n");
        sb.append("*");
        if (titre.length() % 2 == 0) {
            sb.append(espaces(debut.length() / 2 - titre.length() / 2 - 1));
        } else {
            sb.append(espaces(debut.length() / 2 - titre.length() / 2 - 2));
        }
        sb.append(titre);
        sb.append(espaces(debut.length() / 2 - titre.length() / 2 - 2));
        sb.append("*\n");
        sb.append("*");
        sb.append(espaces(debut.length() - 3));
        sb.append("*\n");
        sb.append(debut);
        affiche += sb.toString() + "\n";
        return affiche;

    }

    public static String espaces(int nombre) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombre; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String creerLigne(String a, String b, String c, String tol, String ra, String ft, String oracleDirecte, String oracleIter) {
        String affiche = "";
        StringBuilder sb = new StringBuilder();
        sb.append("| ");
        sb.append(a);
        sb.append(espaces(26 - a.length()));

        sb.append("| ");
        sb.append(b);
        sb.append(espaces(26 - b.length()));

        sb.append("| ");
        sb.append(c);
        sb.append(espaces(26 - c.length()));

        sb.append("| ");
        sb.append(tol);
        sb.append(espaces(20 - tol.length()));

        sb.append("| ");
        sb.append(ra);
        sb.append(espaces(50 - ra.length()));

        sb.append("| ");
        sb.append(ft);
        sb.append(espaces(50 - ft.length()));

        sb.append("| ");
        sb.append(oracleDirecte);
        sb.append(espaces(8 - oracleDirecte.length()));

        sb.append("| ");
        sb.append(oracleIter);
        sb.append(espaces(8 - oracleIter.length()));

        affiche += sb.toString() + "|\n";
        affiche += separation();
        return affiche;
    }

    public static String separation() {

        String a = "+";
        for (int i = 1; i < 220; i++) {
            switch (i) {
                case 28:
                    a += "+";
                    break;
                case 56:
                    a += "+";
                    break;
                case 84:
                    a += "+";
                    break;
                case 106:
                    a += "+";
                    break;
                case 158:
                    a += "+";
                    break;
                case 210:
                    a += "+";
                    break;
                default:
                    a += "-";

            }
        }

        return a + "+\n";
    }

}
