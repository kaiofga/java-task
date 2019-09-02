package com.aldar.java.task.rest.model;

import com.aldar.java.task.google.model.Item;
import com.aldar.java.task.itunes.model.Result;
import lombok.Data;

import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Data
public class Response {
    private List<Book> books;
    private List<Album> albums;

    public static Response builderResponse(List<Result> resultAlbums, List<Item> itemBooks) {
        Response response = new Response();

        response.albums = resultAlbums.stream()
                .map(Album::builder)
                .sorted(comparing(Album::getCollectionName))
                .collect(toList());

        response.books = itemBooks.stream()
                .map(Item::getVolumeInfo)
                .filter(Objects::nonNull)
                .map(Book::builder)
                .sorted(comparing(Book::getTitle))
                .collect(toList());

        return response;
    }
}
