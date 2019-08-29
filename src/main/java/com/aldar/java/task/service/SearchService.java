package com.aldar.java.task.service;

import com.aldar.java.task.rest.model.Response;

public interface SearchService {

    Response searchItems(String searchTerm);
}
