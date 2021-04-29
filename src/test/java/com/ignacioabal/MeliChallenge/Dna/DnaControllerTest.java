package com.ignacioabal.MeliChallenge.Dna;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class DnaControllerTest {

//    @Test
//    void isMutant() throws ClientProtocolException, IOException {
//
//        HttpUriRequest request = new RequestBuilder("POST").setEntity(new StringEntity("{}"));
//
//        HttpResponse httpResponse = (HttpResponse) HttpClientBuilder.create().build().execute( request );
//
//        assertEquals(HttpStatus.SC_OK, httpResponse.statusCode());
//    }
//
//    @Test
//    void getStatistics() {
//    }
}