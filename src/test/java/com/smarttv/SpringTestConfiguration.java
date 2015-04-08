package com.smarttv;


import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.mock.web.MockServletContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.ServletContext;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.smarttv")
@ImportResource({
        "classpath:spring-basic.xml"
})
public class SpringTestConfiguration {

    @Bean
    public PropertySourcesPlaceholderConfigurer pspc(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ServletContext servletContext() {
        return new MockServletContext();
    }
}


