package com.erik.webscrapper.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "webpage")
public class Webpage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String domain;
    private String url;
    private String title;
    private String description;
    private String picture;
    @Column(name = "`rank`")
    private Integer rank;

}
