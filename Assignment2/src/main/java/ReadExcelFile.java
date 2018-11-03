
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ReadExcelFile {

    public static ArrayList<dataChess> chess = new ArrayList<dataChess>();
    public static ArrayList<dataTitle> title = new ArrayList<dataTitle>();

    public static void readFile() {

        try {
            FileInputStream filepath = new FileInputStream(new File("C:\\Users\\Admin\\Documents\\Sem 5\\chessList.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(filepath);
            XSSFSheet sheet = workbook.getSheetAt(0);

            String cell1, cell2, cell3, cell4, cell5, cell6, r1, r2, r3, r4;

            XSSFRow a = sheet.getRow(0);
            XSSFRow b = sheet.getRow(1);
            XSSFRow c = sheet.getRow(2);
            XSSFRow d = sheet.getRow(3);

            r1 = a.getCell(0).getStringCellValue();
            r2 = b.getCell(0).getStringCellValue();
            r3 = c.getCell(0).getStringCellValue();
            r4 = d.getCell(0).getStringCellValue();

             title.add(new dataTitle(r1,r2,r3,r4));

            for (int i = 4; i < 158; i++) {

                XSSFRow row = sheet.getRow(i);

                cell1 = row.getCell(0).toString();
                cell2 = row.getCell(2).toString();
                cell3 = row.getCell(3).toString();
                cell4 = row.getCell(4).toString();
                cell5 = row.getCell(5).toString();
                cell6 = row.getCell(6).toString();

                chess.add(new dataChess(cell1,cell2,cell3,cell4,cell5,cell6));

            }
            workbook.close();
            filepath.close();

            System.out.println("" + title.get(0).getA());
            System.out.println("" + title.get(0).getB());
            System.out.println("" + title.get(0).getC());
            System.out.println("" + title.get(0).getD());

            for (int s = 0; s < chess.size(); s++) {

                System.out.printf("%-8s", chess.get(s).getNo());
                System.out.printf("%-40s", chess.get(s).getName());
                System.out.printf("%-8s", chess.get(s).getId());
                System.out.printf("%-6s", chess.get(s).getFed());
                System.out.printf("%-6s", chess.get(s).getRtg());
                System.out.printf("%-6s", chess.get(s).getClub());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}