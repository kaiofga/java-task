package com.aldar.java.task.itunes;

import lombok.Data;

import java.util.List;

@Data
public class ITunesResponse {
    public Integer resultCount;
    public List<Result> results;
}