package com.aldar.java.task.itunes.impl;

import com.aldar.java.task.itunes.ITunesClient;
import com.aldar.java.task.itunes.ITunesParameters;
import com.aldar.java.task.itunes.model.ITunesResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.completedFuture;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Slf4j
@Service
@AllArgsConstructor
public class ITunesClientImpl implements ITunesClient {

    private final RestTemplate restTemplate;

    @Async
    @Override
    public CompletableFuture<ITunesResponse> search(ITunesParameters ITunesParameters) {
        URI iTunesURI = fromHttpUrl("https://itunes.apple.com")
                .pathSegment("search")
                .queryParam("term", ITunesParameters.getTerm())
                .queryParam("media", ITunesParameters.getMedia())
                .queryParam("entity", ITunesParameters.getEntity())
                .queryParam("limit", ITunesParameters.getLimit())
                .build().toUri();
        try {
            ResponseEntity<ITunesResponse> response = restTemplate.getForEntity(iTunesURI, ITunesResponse.class);
            return completedFuture(response.getBody());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("An http error was occurred on get Albums from ITunes");
            log.debug("Http Status: {} Body: {}", e.getStatusCode(), e.getResponseBodyAsString());
            return completedFuture(ITunesResponse.emptyResponse());
        } catch (Exception e) {
            log.error("An error was occurred on get Albums from ITunes: {}", e.getMessage());
            return completedFuture(ITunesResponse.emptyResponse());
        }
    }
}
