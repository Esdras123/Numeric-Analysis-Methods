/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deg1;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class GenerationDonnee {
    public static ArrayList<DonneeTest> getDonneesTest(int n) {
        ArrayList<DonneeTest> donneeEntree = new ArrayList<DonneeTest>();

        try {
            Workbook workbook = Workbook.getWorkbook(new File("Excel/donnee.xlsx"));
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            int columns = sheet.getColumns();
            for (int i=1; i < rows; i++){
                donneeEntree.add(
                        new DonneeTest(sheet.getCell(i,0).getContents(),
                                "solve",
                                sheet.getCell(i,3).getContents(),
                                Double.parseDouble(sheet.getCell(i,4).getContents()),
                                sheet.getCell(i,5).getContents(),
                                n
                                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return donneeEntree;

    }

}
