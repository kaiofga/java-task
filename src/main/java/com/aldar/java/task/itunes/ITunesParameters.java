package com.aldar.java.task.itunes;

import lombok.Data;

@Data
public class ITunesParameters {
    private String term;
    private String media;
    private String entity;
    private Integer limit;

    public static ITunesParameters builderParams(String term, Integer limit) {
        ITunesParameters params = new ITunesParameters();
        params.term = term.trim().replaceAll("\\W", "+");
        params.media = "music";
        params.entity = "album";
        params.limit = limit;
        return params;
    }
}
