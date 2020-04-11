/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplacedim2;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenerationDonnee {

    public static ArrayList<DonneeTest> getDonneesTest(int n, int m) {
        try {
            ArrayList<DonneeTest> donneeEntree = new ArrayList<DonneeTest>();
            
            Workbook workbook = Workbook.getWorkbook(new File("Excel/donnee.xls"));
            Sheet sheet = workbook.getSheet(0);
            //int rows = 17;
            int columns = sheet.getColumns();
            int i = 1;
            do {
                donneeEntree.add(
                        new DonneeTest(sheet.getCell(0, i).getContents(),
                                "solve",
                                sheet.getCell(3, i).getContents(),
                                Double.parseDouble(sheet.getCell(4, i).getContents()),
                                sheet.getCell(5, i).getContents(),
                                n,m
                        ));
                i++;
            } while (!sheet.getCell(0, i).getContents().equals("END"));
            /*
            for (int i=1; i < rows; i++){
            donneeEntree.add(
            
            new DonneeTest(sheet.getCell(0,i).getContents(),
            "solve",
            sheet.getCell(3,i).getContents(),
            Double.parseDouble(sheet.getCell(4,i).getContents()),
            sheet.getCell(5,i).getContents(),
            n
            ));
            }
            */
            
            return donneeEntree;
        } catch (IOException ex) {
            Logger.getLogger(GenerationDonnee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(GenerationDonnee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
