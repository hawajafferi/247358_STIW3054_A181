public class mainClass {

    public static void main(String[]args){

        try {
            ReadExcelFile.readFile();
            System.out.println("\nsuccessfully get the data from excel file");
            Thread.sleep(2000);

            excelToPdf.excel2pdf();
            System.out.println("successfully convert excel to PDF");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
