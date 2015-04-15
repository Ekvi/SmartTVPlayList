package com.smarttv.utils.parsers;

import org.springframework.stereotype.Component;

@Component
public class FactoryParsers {

    public Parser createParser(String name) {
        if(name.equalsIgnoreCase("ex.ua")) {
            return new ExUaParser();
        }
        return null;
    }
}
