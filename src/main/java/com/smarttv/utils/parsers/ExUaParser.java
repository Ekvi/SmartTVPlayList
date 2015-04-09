package com.smarttv.utils.parsers;


import com.smarttv.models.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExUaParser extends DefaultParser {
    private List<String> categories;

    public ExUaParser() {
        categories = new ArrayList<String>();
        categories.add("Зарубежное");
        categories.add("Наше");
        categories.add("Зарубежные сериалы");
        categories.add("Наши сериалы");
        categories.add("Мультфильмы");
        categories.add("Аниме");
        categories.add("Документальное");
        categories.add("Клипы");
        categories.add("Концерты");
        categories.add("Шоу и Передачи");
        categories.add("Уроки и Тренинги");
        categories.add("Спорт");

    }

    @Override
    public List<String> getCategories(String url) throws IOException {
        Document doc = Jsoup.connect(url).userAgent(Constants.userAgent).timeout(30000).get();
        parse(doc, doc.body().html());
        return null;
    }

    private void parse(Document doc, String content) {

        //Elements elements = doc.getElementsByAttributeValueMatching("href", "\\/video\\/.*Зарубежное");
        Elements elements = doc.getElementsByAttributeValueMatching("href", "\\/video\\/");
        System.out.println(elements.size());

        for(Element element : elements) {
            System.out.println(element.attr("href"));
        }
    }
}
