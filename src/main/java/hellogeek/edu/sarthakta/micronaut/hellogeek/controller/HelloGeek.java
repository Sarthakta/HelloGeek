package hellogeek.edu.sarthakta.micronaut.hellogeek.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * Created by avyas on 6/5/2018.
 */

@Controller(value = "/hellogeek")
public class HelloGeek {


    @Get("/echo/{name}")
    public String echoYourNameGeek(String name){
        return "Hello Geek "+name;

    }
}
