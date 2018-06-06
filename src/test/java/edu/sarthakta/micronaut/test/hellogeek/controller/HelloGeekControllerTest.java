package edu.sarthakta.micronaut.test.hellogeek.controller;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by avyas on 6/5/2018.
 */
public class HelloGeekControllerTest {

    private static  EmbeddedServer embeddedServer;
    private static  HttpClient httpClient;

    @BeforeClass
    public  static void setUpServer(){

        embeddedServer = ApplicationContext.run(EmbeddedServer.class);
        httpClient = embeddedServer.getApplicationContext().createBean(HttpClient.class, embeddedServer.getURL());
    }

    @AfterClass
    public static void stopSever(){
        if(null != embeddedServer){
            embeddedServer.stop();
        }

        if(null != httpClient){
            httpClient.stop();

        }
    }

    @Test
    public void testEchoYourNameGeek(){
        HttpRequest httpRequest = HttpRequest.GET("/hellogeek/echo/TestGeek");
        String body = httpClient.toBlocking().retrieve(httpRequest);

        assertNotNull(body);
        assertEquals(body,"Hello Geek TestGeek");
    }
}
