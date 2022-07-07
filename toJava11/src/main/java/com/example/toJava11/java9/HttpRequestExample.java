package com.example.toJava11.java9;

import com.example.toJava11.java9.dto.Repository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class HttpRequestExample {

    public Repository getInfoGithubUser(String user, String repo) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.github.com/repos/" + user + "/" + repo))
                .GET()
                .build();
        HttpResponse<String> detailRepoRequest = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        return gson.fromJson(detailRepoRequest.body() , Repository.class);
    }
}
