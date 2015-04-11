package com.smarttv.utils.parsers;


import com.smarttv.models.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Experiments {
    public static void main(String[] args) {
        Document doc = null;

        try {
            doc = Jsoup.connect("http://www.ex.ua/85748431?r=2,23775").userAgent(Constants.USER_AGENT).timeout(30000).get();
            Elements titles = doc.getElementsByAttributeValue("name", "title");
            /*for(Element e : titles) {
                System.out.println("title " + e);
            }*/
            String title = titles.get(0).attr("content");
            System.out.println("title " + title);

            Elements images = doc.getElementsByAttributeValue("alt", title);
            String image = "";
            if(images.size() > 0) {
                image = images.get(0).attr("src");
            }
            System.out.println("image " + image);
            //Elements elements = doc.getElementsByAttributeValue("alt", value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
