package com.aldar.java.task;

import com.aldar.java.task.google.model.BooksResponse;
import com.aldar.java.task.itunes.ITunesResponse;

import java.util.ArrayList;

public class DataBuilder {

    public static ITunesResponse iTunesResponseData(){
        ITunesResponse iTunesResponse = new ITunesResponse();
        iTunesResponse.setResultCount(1);
        iTunesResponse.setResults(new ArrayList<>());
        return iTunesResponse;
    }


    public static BooksResponse booksResponseData(){
        BooksResponse booksResponse = new BooksResponse();
        booksResponse.setTotalItems(1);
        booksResponse.setItems(new ArrayList<>());
        return booksResponse;
    }
}
