package com.aldar.java.task.google;

import com.aldar.java.task.google.model.BooksResponse;

import java.util.concurrent.CompletableFuture;

public interface GoogleClient {

    CompletableFuture<BooksResponse> getBooks(BooksParameters parameters);
}
