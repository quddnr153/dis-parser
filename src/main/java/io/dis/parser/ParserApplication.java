package io.dis.parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author Byungwook Lee on 10/1/2017
 * quddnr153@gmail.com
 * https://github.com/quddnr153
 */
@SpringBootApplication
public class ParserApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ParserApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ParserApplication.class);
    }
}
