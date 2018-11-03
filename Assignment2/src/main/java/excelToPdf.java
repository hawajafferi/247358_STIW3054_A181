import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class excelToPdf {

    public static void excel2pdf() {

        try {

            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\Admin\\Documents\\Sem 5\\chessList.pdf"));

            document.open();

             document.add(new Paragraph("" + ReadExcelFile.title.get(0).getA()));
             document.add(new Paragraph("" + ReadExcelFile.title.get(0).getB()));
             document.add(new Paragraph("" + ReadExcelFile.title.get(0).getC()));
             document.add(new Paragraph("" + ReadExcelFile.title.get(0).getD()));
             document.add(new Paragraph("    "));


            PdfPTable table = new PdfPTable(new float[]{3f, 18f, 3f, 3f, 2f, 10f});

            for (int i = 0; i < ReadExcelFile.chess.size(); i++) {

                table.addCell(ReadExcelFile.chess.get(i).getNo());
                table.addCell(ReadExcelFile.chess.get(i).getName());
                table.addCell(ReadExcelFile.chess.get(i).getId());
                table.addCell(ReadExcelFile.chess.get(i).getFed());
                table.addCell(ReadExcelFile.chess.get(i).getRtg());
                table.addCell(ReadExcelFile.chess.get(i).getClub());

            }

             document.add(table);
             document.close();


        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
