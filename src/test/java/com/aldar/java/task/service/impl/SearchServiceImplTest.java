package com.aldar.java.task.service.impl;

import com.aldar.java.task.google.GoogleClient;
import com.aldar.java.task.itunes.ITunesClient;
import com.aldar.java.task.service.SearchService;
import org.junit.Before;
import org.junit.Test;

import static com.aldar.java.task.DataBuilder.booksResponseData;
import static com.aldar.java.task.DataBuilder.iTunesResponseData;
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
        when(iTunesClientMock.search(any())).thenReturn(completedFuture(iTunesResponseData()));
        when(googleClientMock.getBooks(any())).thenReturn(completedFuture(booksResponseData()));

        this.searchService.searchItems("Elvis Presley");
    }
}