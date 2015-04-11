package com.smarttv.utils.parsers;


import com.smarttv.models.Constants;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ExUaParserUnitTest {

    @Test
    public void testGetNextPage() throws IOException {
        ExUaParser parser = new ExUaParser();
        String page1 = IOUtils.toString(this.getClass().getResourceAsStream("ExUaPage1.txt"));
        String page15 = IOUtils.toString(this.getClass().getResourceAsStream("ExUaPage15.txt"));
        String fake = IOUtils.toString(this.getClass().getResourceAsStream("fakePage.txt"));

        assertEquals("http://ex.ua/ru/video/foreign?r=23775&p=1", parser.getNextPage(page1));
        assertEquals("http://ex.ua/ru/video/foreign?r=23775&p=15", parser.getNextPage(page15));
        assertTrue(parser.getNextPage(fake).isEmpty());
    }

    @Test
    public void testGetNextPageForLastPage() throws IOException {
        ExUaParser parser = new ExUaParser();
        String page = IOUtils.toString(this.getClass().getResourceAsStream("FakeNextPage.txt"));

        assertTrue(parser.getNextPage(page).isEmpty());
    }

    @Test
    public void testRegExp() throws IOException {
        ExUaParser parser = new ExUaParser();
        String content = IOUtils.toString(this.getClass().getResourceAsStream("videoPage.txt"));
        String videoLinkRegExp = ".+(\\/get\\/\\d+).+\\.(mkv|avi)";
        String descriptionRegExp = "(<b>Страна.*Аудио.*<\\/b>)";
        String expectedDescription = "<b>Страна</b>: США<br><b>Производство</b>:RCR Media Group, Trilogy Entertainment";

        assertEquals("http://ex.ua/get/159538680", parser.regExp(content, videoLinkRegExp, 1, Constants.EX_UA));
        assertEquals(expectedDescription, parser.regExp(content, descriptionRegExp, 1, "").substring(0, 80));
    }
}

