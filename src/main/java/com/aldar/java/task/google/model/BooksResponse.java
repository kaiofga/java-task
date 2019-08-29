package com.aldar.java.task.google.model;

import lombok.Data;

import java.util.List;

@Data
public class BooksResponse {
    public Integer totalItems;
    public List<Item> items;
}