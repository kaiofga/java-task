package com.aldar.java.task.service.impl;

import com.aldar.java.task.google.BooksParameters;
import com.aldar.java.task.google.GoogleClient;
import com.aldar.java.task.google.model.BooksResponse;
import com.aldar.java.task.itunes.ITunesClient;
import com.aldar.java.task.itunes.ITunesParameters;
import com.aldar.java.task.itunes.ITunesResponse;
import com.aldar.java.task.rest.model.Response;
import com.aldar.java.task.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final ITunesClient iTunesClient;
    private final GoogleClient googleClient;

    @Value("${MAX_RESULTS:5}")
    private int maxResults;

    @Override
    @SneakyThrows
    public Response searchItems(String searchTerm) {

        CompletableFuture<ITunesResponse> iTunesResponse = iTunesClient.search(ITunesParameters.builderParams(searchTerm, this.maxResults));
        CompletableFuture<BooksResponse> booksResponse = googleClient.getBooks(BooksParameters.builderParams(searchTerm, this.maxResults));

        CompletableFuture.allOf(iTunesResponse, booksResponse).join();

        return Response.builderResponse(iTunesResponse.get().getResults(), booksResponse.get().getItems());
    }
}
