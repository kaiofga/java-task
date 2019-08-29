package com.aldar.java.task.itunes.impl;

import com.aldar.java.task.itunes.ITunesClient;
import com.aldar.java.task.itunes.ITunesParameters;
import com.aldar.java.task.itunes.ITunesResponse;
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

        return completedFuture(restTemplate.getForEntity(iTunesURI, ITunesResponse.class).getBody());
    }
}
