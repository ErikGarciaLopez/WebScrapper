package com.erik.webscrapper.service;

import com.erik.webscrapper.model.Webpage;
import com.erik.webscrapper.repository.WebpageRepository;
import org.jsoup.*;
import org.jsoup.nodes.Document;  // Escríbela manualmente
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class WebscrapperService {

    @Autowired
    private WebpageRepository repository;

    public void scrapeAndSave(String url) {

        try {
            Document document = Jsoup.connect(url).get();

            String domain = getDomainFromUrl(url);
            String title = document.title();
            String description = document.select("meta[name=description]")
                    .attr("content");
            String picture = document.select("meta[property=og:image]")
                    .attr("content");

            Webpage webpage = new Webpage();
            webpage.setDomain(domain);
            webpage.setTitle(title);
            webpage.setDescription(description);
            webpage.setPicture(picture);
            webpage.setUrl(url);

            repository.save(webpage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private String getDomainFromUrl(String url) {
        String domain = url.replaceFirst("^(https?://)?(www\\.)?", "");
        int index = domain.indexOf('/');
        if (index != -1) {
            domain = domain.substring(0, index);
        }
        return domain;
    }

}


