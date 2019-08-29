package com.aldar.java.task.itunes;

import lombok.Data;

@Data
public class Result {
    private String artistName;
    private String collectionName;
    private String releaseDate;
    private Integer trackCount;
    private String country;
    private String primaryGenreName;
}