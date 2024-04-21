package br.com.viniciusdiefenbach.alura.screenmatch.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsume {

    public String getData(String address) {
        var httpClient = HttpClient.newHttpClient();
        var httpRequest = HttpRequest.newBuilder().uri(URI.create(address)).build();
        try {
            var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
