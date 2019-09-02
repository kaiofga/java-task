package com.aldar.java.task.itunes.model;

import lombok.Data;

import java.util.List;

import static java.util.Collections.emptyList;

@Data
public class ITunesResponse {
    public Integer resultCount;
    public List<Result> results;

    public static ITunesResponse emptyResponse() {
        ITunesResponse iTunesResponse = new ITunesResponse();
        iTunesResponse.results = emptyList();
        iTunesResponse.resultCount = 0;
        return iTunesResponse;
    }
}