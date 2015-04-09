package com.smarttv.utils;


import com.smarttv.SpringTestConfiguration;
import com.smarttv.utils.parsers.FactoryParsers;
import com.smarttv.utils.parsers.Parser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestConfiguration.class)
public class ExUaParserIntegrationTest {
    @Autowired
    private FactoryParsers factory;

    private Parser parser;

    @Test
    public void test() throws IOException {
        String siteName = "http://www.ex.ua/ru/video";
        parser = factory.createParser("exua");

        parser.getCategories(siteName);
    }
}
