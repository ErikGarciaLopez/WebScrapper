package com.erik.webscrapper.controller;

import com.erik.webscrapper.model.Webpage;
import com.erik.webscrapper.repository.WebpageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebPageController {

    @Autowired
    WebpageRepository repository;

    //Example: http://localhost:8080/api/search?query=chocolate
    @GetMapping("/api/search")
    public List<Webpage> search(@RequestParam("query") String query) {

        List<Webpage> list = new ArrayList<>();
        Iterable<Webpage> result = repository.findByText(query);

        for(Webpage webpage : result) {
            list.add(webpage);
        }

        return list;
    }

}
