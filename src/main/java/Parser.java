import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;

public class Parser {
    private static Document getPage() throws IOException {
        String url = "https://www.kinopoisk.ru/afisha/new/city/473/";
        return Jsoup.parse(new URL(url), 3000);
    }

    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Elements filmsListNew = page.select("div[class=filmsListNew js-rum-hero]");
        Elements items = filmsListNew.select("div[class=item]");
        for(Element i : items) {
            System.out.println(i.text());
        }
    }
}

