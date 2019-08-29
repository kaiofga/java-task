package com.aldar.java.task.itunes.impl;

import com.aldar.java.task.itunes.ITunesClient;
import com.aldar.java.task.itunes.ITunesParameters;
import com.aldar.java.task.itunes.ITunesResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;

public class ITunesClientImplTest {

    private ITunesClient iTunesClient;

    private RestTemplate restTemplateMock;

    @Before
    public void before() {
        this.restTemplateMock = mock(RestTemplate.class);

        this.iTunesClient = new ITunesClientImpl(restTemplateMock);
    }

    @Test
    public void shouldReturnAlbums() {
        when(this.restTemplateMock.getForEntity(any(URI.class), eq(ITunesResponse.class))).thenReturn(new ResponseEntity<>(new ITunesResponse(), OK));

        this.iTunesClient.search(ITunesParameters.builderParams("Elton John", 3));

        ArgumentCaptor<URI> uriArgumentCaptor = ArgumentCaptor.forClass(URI.class);
        verify(this.restTemplateMock, times(1)).getForEntity(uriArgumentCaptor.capture(), eq(ITunesResponse.class));

        assertEquals("https://itunes.apple.com/search?term=Elton+John&media=music&entity=album&limit=3", uriArgumentCaptor.getValue().toString());
    }
}