package com.muhammedtopgul.ch08.jpa2.service;

/*
 * created by Muhammed Topgul
 * on 18/08/2021
 * at 23:38
 */

import com.muhammedtopgul.ch07.hibernate.entity.Singer;

import java.util.List;

public interface SingerService {

    List<Singer> findAll();

    List<Singer> findAllWithAlbum();

    Singer findById(Long id);

    Singer save(Singer singer);

    void delete(Singer singer);

    List<Singer> findAllByNativeQuery();
}
