package laplacedim2;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class genData {
    public static ArrayList<String> readNom() throws IOException, BiffException {
        ArrayList<String> Nom = new ArrayList<>();

        Workbook workbook = Workbook.getWorkbook(new File("Excel/donnee.xls"));
        Sheet sheet = workbook.getSheet("noms");
        int nbre_col = sheet.getRows();
        System.out.println(nbre_col);
        for (int i =1; i< nbre_col; i++){
            Nom.add(sheet.getCell(1,i).getContents());
        }
        workbook.close();
        return Nom;
    }

    public static void  setData(ArrayList<String> noms) throws IOException, BiffException, WriteException {
        Workbook workbook = Workbook.getWorkbook(new File("Excel/donnee.xls"));
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("Excel/donnee.xls"),workbook);
        WritableSheet sheet = writableWorkbook.createSheet("test", 0);

        int i;
        int nbre_col = noms.size();
        int n= nbre_col - 1;
        System.out.println(noms);
        Random random = new Random();
        for(i = 1; i< nbre_col; i++){
            Label labelNom = new Label(0, i, noms.get(i - 1) );
            int rand = random.nextInt(100-1) + 1;
            Label labelValeur = new Label(5, i, String.valueOf(rand)+ ':' + noms.get(i - 1) );
            sheet.addCell(labelNom);
            sheet.addCell(labelValeur);
            for (int j = i; j< nbre_col; j++){
                n = n + 1;
                Label labelNom1 = new Label(0, n ,
                        noms.get(i-1) + '_'  + noms.get(j-1)  );

                Label labelValeur1 = new Label(5, n ,
                        String.valueOf(random.nextInt(100) + 1) + ':' + noms.get(i-1) + ';' +
                                (random.nextInt(100)+1) + ':' + noms.get(j-1)  );

                sheet.addCell(labelNom1);
                sheet.addCell(labelValeur1);
            }

        }


        writableWorkbook.write();
        writableWorkbook.close();
    }
    public static void main(String[] args){

        try {
            setData(readNom());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

}
