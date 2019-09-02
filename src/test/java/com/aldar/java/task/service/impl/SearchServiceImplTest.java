package com.aldar.java.task.service.impl;

import com.aldar.java.task.google.GoogleClient;
import com.aldar.java.task.google.model.BooksResponse;
import com.aldar.java.task.itunes.ITunesClient;
import com.aldar.java.task.itunes.model.ITunesResponse;
import com.aldar.java.task.service.SearchService;
import org.junit.Before;
import org.junit.Test;

import static java.util.concurrent.CompletableFuture.completedFuture;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchServiceImplTest {

    private SearchService searchService;

    private ITunesClient iTunesClientMock;
    private GoogleClient googleClientMock;

    @Before
    public void before() {
        this.iTunesClientMock = mock(ITunesClient.class);
        this.googleClientMock = mock(GoogleClient.class);

        this.searchService = new SearchServiceImpl(iTunesClientMock, googleClientMock);
    }

    @Test
    public void shouldSearchItems() {
        when(iTunesClientMock.search(any())).thenReturn(completedFuture(ITunesResponse.emptyResponse()));
        when(googleClientMock.getBooks(any())).thenReturn(completedFuture(BooksResponse.emptyResponse()));

        this.searchService.searchItems("Elvis Presley");
    }
}