package com.example.toJava11.java9;

import com.example.toJava11.java9.dto.Repository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class HttpRequestExample {
    private final Gson gson;

    public Repository getInfoGithubUser(String user, String repo) throws URISyntaxException, IOException, InterruptedException {

        var request = HttpRequest.newBuilder()
                .uri(new URI("https://api.github.com/repos/" + user + "/" + repo))
                .GET()
                .build();
        var detailRepoRequest = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        var set = Set.of("a", "b", "c");
        return gson.fromJson(detailRepoRequest.body() , Repository.class);
    }
}
