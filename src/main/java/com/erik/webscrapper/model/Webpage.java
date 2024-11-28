package com.erik.webscrapper.model;

import jakarta.persistence.Entity;

@Entity
public class Webpage {

    private Integer id;
    private String domain;
    private String url;
    private String tittle;
    private String description;
    private String picture;
    private Integer rank;

}
