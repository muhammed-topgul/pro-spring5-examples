package com.muhammedtopgul.ch08.springDataJpa.service;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 23:36
 */

import com.muhammedtopgul.ch08.springDataJpa.entity.Album;
import com.muhammedtopgul.ch08.springDataJpa.entity.Singer;

import java.util.List;

public interface AlbumService {
    List<Album> findBySinger(Singer singer);

    List<Album> findByTitle(String title);
}