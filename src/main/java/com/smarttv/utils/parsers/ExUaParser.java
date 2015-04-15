package com.smarttv.utils.parsers;


import com.smarttv.models.Constants;

import com.smarttv.models.Video;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExUaParser extends DefaultParser {
    private String category;
    private String siteName;

    @Override
    public Set<Video> getNewVideo(String url) {
        Set<Video> videos = new HashSet<Video>();
        Elements elements;
        Set<String> links;
        Document doc = getHTMLDocument(url);

        if(doc != null) {
            elements = getElements(doc);
            links = removeExtraLinks(elements);
            videos = createVideos(links);
        }

        return videos;
    }

    @Override
    public Set<Video> getAllVideo(String url, String category, String siteName) {
        this.category = category;
        this.siteName = siteName;

        Set<Video> videos = new HashSet<Video>();
        Elements elements;
        Set<String> links;
        Document doc;

        do {
            doc = getHTMLDocument(url);

            if(doc != null) {
                elements = getElements(doc);
                links = removeExtraLinks(elements);
                videos.addAll(createVideos(links));
                url = getNextPage(doc.body().html());
            }
        } while(!url.isEmpty());

        return videos;
    }

    private Document getHTMLDocument(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent(Constants.USER_AGENT).timeout(30000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    private Elements getElements(Document doc)  {
        Elements table = doc.getElementsByAttributeValue("class", "include_0");
        return table.get(0).getElementsByAttribute("href");
    }

    private Set<String> removeExtraLinks(Elements elements) {
        Set<String> videoLinks = new HashSet<String>();

        for(Element e : elements) {
            String link = regExp(e.attr("href"), "(^\\/\\d+.*)", 1, Constants.EX_UA);
            if(!link.isEmpty()) {
                videoLinks.add(link);
            }
        }
        return videoLinks;
     }

    private Set<Video> createVideos(Set<String> links) {
        Set<Video> videos = new HashSet<Video>();

        for(String url : links) {
            System.out.println("create video url " + url);
            videos.add(createVideo(url));
        }
        return videos;
    }

    Video createVideo(String url) {
        Document doc = getHTMLDocument(url);
        String content = doc.body().html();
        String title = extractTitle(doc);

        return new Video(title, extractImageLink(doc, title),
                extractVideoLinks(content), extractDescription(content), category, siteName);
    }

    private String extractTitle(Document doc) {
        return extractParameter(doc, "name", "content", "title");
    }

    private String extractImageLink(Document doc, String title) {
        return extractParameter(doc, "alt", "src", title);
    }

    private String extractParameter(Document doc, String attr1, String attr2, String value) {
        Elements elements = doc.getElementsByAttributeValue(attr1, value);
        return elements.size() == 0 ? "" : elements.get(0).attr(attr2);
    }

    private List<VideoInfo> extractVideoLinks(String content) {
        List<VideoInfo> videos = new ArrayList<VideoInfo>();
        Pattern pattern = Pattern.compile(".+(\\/get\\/\\d+).+>(.+\\.(avi|mkv|mp4|mpg|ts))", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            videos.add(new VideoInfo(matcher.group(2), Constants.EX_UA + matcher.group(1)));
        }
        return videos;
    }

    private String extractDescription(String content) {
        return regExp(content, "(<b>Страна.*Аудио.*<\\/b>)", 1, "");
    }

    String regExp(String content, String regexp, int group, String append) {
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(content);
        String result = "";
        if (matcher.find()) {
            result = append + matcher.group(group);
        }
        return result;
    }

    String getNextPage(String content) {
        return regExp(content, ".*(\\/ru\\/video.*p=\\d+).*перейти на следующую страницу", 1, Constants.EX_UA);
    }
}
