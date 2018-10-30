import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class collectData {

    public static List <InfoData> ListAll() {

        try{
            Document document = Jsoup.connect("https://ms.wikipedia.org/wiki/Malaysia").get();

            Elements table = document.getElementsByClass("wikitable");

            Elements m = table.get(1).getElementsByClass("wikitable");

            Elements column1 = m.select("th");
            Elements column2 = m.select("td");

            List<InfoData> data = new ArrayList<InfoData>();

            for (int i=0; i<column1.size(); i++){
                data.add(new InfoData("" + column1.get(i).text(), "" + column2.get(i).text()));

            }

            System.out.println("import data...");
            Thread.sleep(3000);

            for (InfoData infoData : data){
                System.out.println(infoData.getCol1() + "  :  " +infoData.getCol2());
            }
            return data;
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("data successfully import from the website..");
        return null;
    }

}
