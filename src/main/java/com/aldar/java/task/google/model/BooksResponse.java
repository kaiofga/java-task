package com.aldar.java.task.google.model;

import lombok.Data;

import java.util.List;

import static java.util.Collections.emptyList;

@Data
public class BooksResponse {
    private Integer totalItems;
    private List<Item> items;

    public static BooksResponse emptyResponse() {
        BooksResponse booksResponse = new BooksResponse();
        booksResponse.totalItems = 0;
        booksResponse.items = emptyList();
        return booksResponse;
    }
}