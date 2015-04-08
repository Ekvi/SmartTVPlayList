package com.smarttv.utils.parsers;

import org.springframework.stereotype.Component;

@Component
public class FactoryParsers {

    public Parser createParser(String name) {
        if(name.equalsIgnoreCase("exua")) {
            return new ExUaParser();
        }
        return null;
    }
}
