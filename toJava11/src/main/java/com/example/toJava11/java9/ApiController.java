package com.example.toJava11.java9;

import com.example.toJava11.java9.dto.Owner;
import com.example.toJava11.java9.dto.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v9")
public class ApiController {

    private final HttpRequestExample httpRequestExample;

    @PostMapping
    public Owner getDetailRepo(@RequestBody Request request) throws URISyntaxException, IOException, InterruptedException {
        var response = httpRequestExample.getInfoGithubUser(request.getUser(), request.getRepo());
        log.info("response: {}", response);
        return response.getOwner();
    }
}
