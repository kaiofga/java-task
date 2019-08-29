package com.aldar.java.task.rest.model;

import com.aldar.java.task.google.model.VolumeInfo;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;
import java.util.Objects;

@Data
public class Book {
    private String title;
    private String subtitle;
    private List<String> authors;
    private String publisher;
    private String publishedDate;
    private String description;
    private Integer pageCount;
    private List<String> categories;
    private String language;

    @SneakyThrows
    static Book builder(VolumeInfo volumeInfo) {
        Book album = new Book();
        BeanUtils.copyProperties(album, volumeInfo);
        return album;
    }

    public String getTitle() {
        return Objects.nonNull(title) ? title : "";
    }
}