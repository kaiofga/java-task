package com.aldar.java.task.rest.model;

import com.aldar.java.task.itunes.Result;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import static java.util.Objects.nonNull;

@Data
public class Album {
    private String artistName;
    private String collectionName;
    private String releaseDate;
    private Integer trackCount;
    private String country;
    private String primaryGenreName;

    @SneakyThrows
    static Album builder(Result result) {
        Album album = new Album();
        BeanUtils.copyProperties(album, result);
        return album;
    }

    public String getCollectionName() {
        return nonNull(collectionName) ? collectionName : "";
    }
}