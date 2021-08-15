package com.muhammedtopgul.ch06.jdbc.entity;

/*
 * created by Muhammed Topgul
 * on 15/08/2021
 * at 19:10
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Album implements Serializable {

    private Long id;
    private Long singerId;
    private String title;
    private Date releaseDate;

    @Override
    public String toString() {
        return "Album - Id: " + id + ", Singer id: " + singerId
                + ", Title: " + title + ", Release Date: " + releaseDate;
    }
}
