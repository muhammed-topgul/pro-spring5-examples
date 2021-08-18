package com.muhammedtopgul.ch07.hibernate.dao;

/*
 * created by Muhammed Topgul
 * on 17/08/2021
 * at 22:45
 */

import com.muhammedtopgul.ch07.hibernate.entity.Singer;

import java.util.List;

public interface SingerDao {

    List<Singer> findAll();
    List<Singer> findAllWithAlbum();
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Singer singer);
}
