package com.muhammedtopgul.ch07.hibernate.entity;

/*
 * created by Muhammed Topgul
 * on 17/08/2021
 * at 17:36
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "album")
@Getter
@Setter
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Version
    @Column(name = "VERSION")
    private int version;

    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    private Singer singer;

    @Override
    public String toString() {
        return "Album - Id: " + id + ", Title: " +
                title + ", Release Date: " + releaseDate;
    }
}
