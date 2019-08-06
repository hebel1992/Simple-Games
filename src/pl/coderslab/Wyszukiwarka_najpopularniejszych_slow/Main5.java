package pl.coderslab.Wyszukiwarka_najpopularniejszych_slow;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main5 {
    public static void main(String[] args) {

        popularWords("https://www.interia.pl/", "a.news-one-a");
        popularWords("https://www.interia.pl/", "a.news-a");
        popularWords("https://www.interia.pl/", "a.tiles-a");
        popularWords("https://www.interia.pl/", "a.news-gallery-a");
        popularWords("https://www.interia.pl/", "a.articles-a");
        popularWords("https://www.interia.pl/", "a.lifestyle-a");
        popularWords("https://www.interia.pl/", "a.sport-a");

        popularWords("https://www.onet.pl/", "span.title");

        popularWords("https://www.gazeta.pl/0,0.html", "span");

        filterPopularWords("popular_words.txt");
    }

    //Metoda zapisująca słowa z podanej strony www z określonych tagów do pliku popular_words.txt
    public static void popularWords(String url, String cssQuery) {

        org.jsoup.Connection connection = Jsoup.connect(url);
        try {
            Document document = connection.get();
            Elements links = document.select(cssQuery);
            String fileName = "popular_words.txt";
            FileWriter words = new FileWriter(fileName, true);
            for (Element elem : links) {
                String[] arr = elem.text().split("[.:,!\"? ]");
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].length() > 2) {
                        words.append(arr[i] + "\n");
                    }
                }
            }
            words.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metoda filtrująca słowa z podanego w parametrze pliku i zapisujaca je do nowego pliku filtered_popular_words.txt
    public static void filterPopularWords(String fileName) {
        Path path = Paths.get(fileName);
        String[] excludedWords = {"oraz", "ponieważ", "przez", "ponad", "nie", "jest", "już", "dla", "czy", "tak", "kto", "jak", "się", "REKLAMA"};
        int checkIfExcluded = 0;
        String newFileName = "filtered_popular_words.txt";

        try {
            FileWriter text = new FileWriter(newFileName, false);

            //Pętla sprawdzająca wszystkie wyrazy z pliku z tablicą słów wykluczonych
            for (String line : Files.readAllLines(path)) {
                for (int i = 0; i < excludedWords.length; i++) {
                    if (line.equalsIgnoreCase(excludedWords[i])) {
                        checkIfExcluded++;
                    }
                }
                if (checkIfExcluded == 0) {
                    text.append(line + "\n");
                }
                checkIfExcluded = 0;
            }
            text.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}