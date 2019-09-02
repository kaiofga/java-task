package com.aldar.java.task.itunes;

import com.aldar.java.task.itunes.model.ITunesResponse;

import java.util.concurrent.CompletableFuture;

public interface ITunesClient {
    CompletableFuture<ITunesResponse> search(ITunesParameters ITunesParameters);
}
