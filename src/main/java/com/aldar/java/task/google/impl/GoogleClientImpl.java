package com.aldar.java.task.google.impl;

import com.aldar.java.task.google.BooksParameters;
import com.aldar.java.task.google.GoogleClient;
import com.aldar.java.task.google.model.BooksResponse;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.completedFuture;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

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

        return completedFuture(restTemplate.getForEntity(googleBooksURI, BooksResponse.class).getBody());
    }
}
