package com.aldar.java.task.google;

import lombok.Data;

@Data
public class BooksParameters {
    private String q;
    private String printType;
    private Integer maxResults;

    public static BooksParameters builderParams(String query, Integer limit) {
        BooksParameters params = new BooksParameters();
        params.printType = "books";
        params.q = query;
        params.maxResults = limit;
        return params;
    }
}