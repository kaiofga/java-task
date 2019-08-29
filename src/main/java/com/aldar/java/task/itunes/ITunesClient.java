package com.aldar.java.task.itunes;

import java.util.concurrent.CompletableFuture;

public interface ITunesClient {
    CompletableFuture<ITunesResponse> search(ITunesParameters ITunesParameters);
}
