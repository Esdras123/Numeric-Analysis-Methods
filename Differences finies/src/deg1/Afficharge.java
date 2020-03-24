package deg1;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

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

    public static String creerLigne(String a, String b, String c, String tol, String ra, String ft, String oracleIter) {
        String affiche = "";
        StringBuilder sb = new StringBuilder();
        sb.append("| ");
        sb.append(a);
        sb.append(espaces(29 - a.length()));

        sb.append("| ");
        sb.append(b);
        sb.append(espaces(17 - b.length()));

        sb.append("| ");
        sb.append(c);
        sb.append(espaces(16 - c.length()));

        sb.append("| ");
        sb.append(tol);
        sb.append(espaces(18 - tol.length()));

        sb.append("| ");
        sb.append(ra);
        sb.append(espaces(28 - ra.length()));

        sb.append("| ");
        sb.append(ft);
        sb.append(espaces(27 - ft.length()));

        /*
        sb.append("| ");
        sb.append(oracleDirecte);
        sb.append(espaces(8 - oracleDirecte.length()));
        */
        
        sb.append("| ");
        sb.append(oracleIter);
        sb.append(espaces(8 - oracleIter.length()));

        affiche += sb.toString() + "|\n";
        affiche += separation();
        return affiche;
    }

    public static String separation() {

        String a = "+";
        for (int i = 1; i < 157; i++) {
            switch (i) {
                case 31:
                    a += "+";
                    break;
                case 50:
                    a += "+";
                    break;
                case 68:
                    a += "+";
                    break;
                case 88:
                    a += "+";
                    break;
                case 118:
                    a += "+";
                    break;
                case 147:
                    a += "+";
                    break;
                default:
                    a += "-";

            }
        }

        return a + "+\n";
    }

}
