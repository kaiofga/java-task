package com.aldar.java.task.rest;

import com.aldar.java.task.rest.model.Response;
import com.aldar.java.task.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {

    private final SearchService searchService;

    @GetMapping("/all")
    public Response getItems(@RequestParam("term") String term) {
        return searchService.searchItems(term);
    }
}