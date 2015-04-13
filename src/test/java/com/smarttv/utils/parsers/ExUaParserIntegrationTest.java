package com.smarttv.utils.parsers;


import com.smarttv.SpringTestConfiguration;
import com.smarttv.models.Video;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestConfiguration.class)
public class ExUaParserIntegrationTest {
    private ExUaParser exUaParser = new ExUaParser();

    @Test
    public void testGetAllVideo() {
        //String url = "http://www.ex.ua/ru/video/foreign?r=23775";
        String url = "http://www.ex.ua/ru/video/our?r=23775";
        //String url = "http://www.ex.ua/ru/video/foreign?r=23775&p=3733";

        exUaParser.getAllVideo(url);
    }

    @Test
    public void testGetNewVideo() {
        String url = "http://www.ex.ua/ru/video/foreign?r=23775";

        Set<Video> videos = exUaParser.getNewVideo(url);

        assertEquals(20, videos.size());

    }

    @Test
    public void testCreateVideo() throws IOException {
        String description = "<b>Страна</b>: США<br><b>Производство</b>:RCR Media Group, Trilogy Entertainment " +
                "Group, Solar Filmworks<br><b>Жанр</b>: триллер, драма<br><b>Год выпуска</b>: 2013<br><b>" +
                "Продолжительность</b>: 01:38:28<br><b>Перевод </b>:<font color=\"#DA1220\"><b> Одноголосый " +
                "закадровый (KEWE),Любительский (многоголосый закадровый) Green Tea,Авторский (одноголосый " +
                "закадровый) А. Дольский</b></font><br><b>Cубтитры</b>: русские (KEWE)(<u><b>ВНИМАНИЕ</b>: " +
                "</u>местами, возможно, присутствие ненормативной лексики); английские<br><b>Оригинальная " +
                "аудиодорожка</b>: английский</p><p><b>Режиссер</b>:<u><b> Тодд Робинсон / Todd Robinson</b>" +
                "<br></u><br><b>В ролях</b><b>: <font color=\"#0DA100\">Эд Харрис, Дэвид Духовны, Уильям Фихтнер" +
                "</font></b>, Лэнс Хенриксен, Джонатон Шек, Джейсон Бех, Дагмара Доминчук, Дерек Магияр, Шон " +
                "Патрик, Флэнери Джейсон, Грей-Стенфорд</p><p><b>Описание</b>: <font color=\"#1C0DB4\"><i><b>В " +
                "период обострения Карибского Кризиса, в Тихий Океан, для наблюдения за действиями Американского " +
                "Флота, напрявляется Советская подводная лодка с баллистической ракетой на борту. Ее экипажу " +
                "поручено провести испытание нового секретного оборудования, имеющего кодовое название \"Фантом\"." +
                " Командиром на лодку назначен человек с неординарной судьбой, которому предстоит, сделать нелегкий" +
                " выбор между Миром и Атомным Апокалипсисом.</b></i></font></p><p><b>Релиз от</b>:<font " +
                "color=\"#079D9D\"><u><b>HDTRACKER </b></u></font></p><p><b>Качество видео</b>: BDRemux<br><b>" +
                "Формат видео</b>: MKV<br><b>Видео</b>: MPEG4 Video AVC (H264)<font color=\"#BA0BB6\"> " +
                "<b>1920x1080 23.976fps </b></font>/ Overall bit rate: 25.0 Mbps<br><b>Аудио 1</b>: Russian: DTS " +
                "48000Hz / 6ch / 1510 Kbps / (KEWE)<br><b>Аудио 2</b>: Russian: 48 kHz, AC3 Dolby Digital, 3/2 " +
                "(L,C,R,l,r) + LFE ch, 448.00 kbps| (Green Tea)<br><b>Аудио 3</b>: Russian: 48 kHz, AC3 Dolby " +
                "Digital, 3/2 (L,C,R,l,r) + LFE ch, 448.00 kbps| (А. Дольский)<br><b>Аудио 4</b>: English: " +
                "DTS-HD Master Audio / 6ch / 48 kHz / 3221 kbps / 24 bits (DTS Core: 5.1 / 48 kHz / 1509 kbps / " +
                "24 bits)|(original)<br><b>Доп. информация о субтитрах</b>: S_TEXT/UTF8<br><b>Доп. информация</b>";

        Video video = exUaParser.createVideo("http://www.ex.ua/89122804?r=2,23775");

        assertEquals(1, video.getVideos().size());
        assertEquals("Фантом / Phantom (2013) BDRemux 1080p", video.getTitle());
        assertEquals("http://ex.ua/get/159538680", video.getVideos().get(0).getLink());
        assertEquals("Фантом - Phantom (2013) BDRemux 1080p.mkv", video.getVideos().get(0).getName());
        assertEquals("http://fs177.www.ex.ua/show/159521076/159521076.jpg?1600", video.getImageUrl());
        assertEquals(description, video.getDescription());
    }

    @Test
    public void testCreateVideoForTrainings() {
        String expectedTitle = "Steve Uria - Weider Ruthless Workout Program [2013, фитнес, Видеоурок, DVDRip, ENG]";
        Video video = exUaParser.createVideo("http://www.ex.ua/89255223?r=28714,23775");

        assertEquals(21, video.getVideos().size());
        assertEquals(expectedTitle, video.getTitle());
        assertEquals("http://ex.ua/get/159985480", video.getVideos().get(5).getLink());
        assertEquals("08 - Core &amp; Flex.avi", video.getVideos().get(8).getName());
        assertEquals("http://fs195.www.ex.ua/show/159985267/159985267.png?1600", video.getImageUrl());
    }

    @Test
    public void testCreateVideoForSerials() {
        Video video = exUaParser.createVideo("http://www.ex.ua/85614430?r=1988,23775");

        assertEquals(13, video.getVideos().size());
        assertTrue(!video.getTitle().isEmpty());
        assertEquals("Helix.S02E01.1080p.rus.LostFilm.TV.mkv", video.getVideos().get(0).getName());
        assertEquals("Helix.S02E13.1080p.rus.LostFilm.TV.mkv", video.getVideos().get(12).getName());
    }
}
