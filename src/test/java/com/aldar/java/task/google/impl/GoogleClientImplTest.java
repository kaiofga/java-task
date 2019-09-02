package com.aldar.java.task.google.impl;

import com.aldar.java.task.google.BooksParameters;
import com.aldar.java.task.google.GoogleClient;
import com.aldar.java.task.google.model.BooksResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.GATEWAY_TIMEOUT;
import static org.springframework.http.HttpStatus.OK;

public class GoogleClientImplTest {

    private GoogleClient googleClient;
    private RestTemplate restTemplateMock;

    @Before
    public void before() {
        this.restTemplateMock = mock(RestTemplate.class);

        this.googleClient = new GoogleClientImpl(restTemplateMock);
    }

    @Test
    public void shouldReturnBooks() {
        when(this.restTemplateMock.getForEntity(any(URI.class), eq(BooksResponse.class))).thenReturn(new ResponseEntity<>(new BooksResponse(), OK));

        googleClient.getBooks(BooksParameters.builderParams("Any Book", 10));

        ArgumentCaptor<URI> uriArgumentCaptor = ArgumentCaptor.forClass(URI.class);
        verify(this.restTemplateMock, times(1)).getForEntity(uriArgumentCaptor.capture(), eq(BooksResponse.class));

        assertEquals("https://www.googleapis.com/books/v1/volumes?q=Any%20Book&printType=books&maxResults=10", uriArgumentCaptor.getValue().toString());
    }

    @Test
    public void shouldThrowHttpExceptionReturnBooks() throws Exception {
        when(this.restTemplateMock.getForEntity(any(URI.class), eq(BooksResponse.class))).thenThrow(new HttpServerErrorException(GATEWAY_TIMEOUT));

        CompletableFuture<BooksResponse> getBooks = googleClient.getBooks(BooksParameters.builderParams("Any Book", 10));

        BooksResponse booksResponse = getBooks.get();
        assertEquals(0, booksResponse.getTotalItems().intValue());
        assertTrue(booksResponse.getItems().isEmpty());
    }
}