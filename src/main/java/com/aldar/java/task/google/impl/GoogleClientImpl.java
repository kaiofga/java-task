package com.aldar.java.task.google.impl;

import com.aldar.java.task.google.BooksParameters;
import com.aldar.java.task.google.GoogleClient;
import com.aldar.java.task.google.model.BooksResponse;
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
public class GoogleClientImpl implements GoogleClient {

    private final RestTemplate restTemplate;

    @Async
    @Override
    public CompletableFuture<BooksResponse> getBooks(BooksParameters parameters) {
        URI googleBooksURI = fromHttpUrl("https://www.googleapis.com")
                .pathSegment("books", "v1", "volumes")
                .queryParam("q", parameters.getQ())
                .queryParam("printType", parameters.getPrintType())
                .queryParam("maxResults", parameters.getMaxResults())
                .build().toUri();

        try {
            ResponseEntity<BooksResponse> response = restTemplate.getForEntity(googleBooksURI, BooksResponse.class);
            return completedFuture(response.getBody());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("An http error was occurred on get Books from Google Books");
            log.debug("Http Status: {} Body: {}", e.getStatusCode(), e.getResponseBodyAsString());
            return completedFuture(BooksResponse.emptyResponse());
        } catch (Exception e) {
            log.error("An error was occurred on get Books from Google Books", e);
            return completedFuture(BooksResponse.emptyResponse());
        }
    }
}
