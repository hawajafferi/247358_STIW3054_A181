import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class Excel {

    public void writeExcel(){

        try{

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Wiki Malaysia Trivia");

            int rCount = 0;

            for (InfoData oneData : collectData.ListAll()){

                Row row = sheet.createRow(rCount++);

                Cell cel11 = row.createCell(0);
                cel11.setCellValue(oneData.getCol1());

                Cell cell2 = row.createCell(1);
                cell2.setCellValue(oneData.getCol2());

                sheet.autoSizeColumn(0);
                sheet.autoSizeColumn(1);

            }
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Admin\\Documents\\Sem 5\\wikiMalaysia.xlsx"));
            workbook.write(out);
            out.flush();
            out.close();
            workbook.close();
            System.out.println("\nwikiMalaysia.xlsx written successfully");

        } catch (Exception e){
            System.out.println("\nError detected");
        }
    }
}
