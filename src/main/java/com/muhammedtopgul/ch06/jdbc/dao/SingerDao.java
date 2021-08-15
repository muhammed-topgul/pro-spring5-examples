package com.muhammedtopgul.ch06.jdbc.dao;

/*
 * created by Muhammed Topgul
 * on 15/08/2021
 * at 19:22
 */

import com.muhammedtopgul.ch06.jdbc.entity.Singer;

import java.util.List;

public interface SingerDao {

    List<Singer> findAll();
    List<Singer> findByFirstName(String firstName);
    String findLastNameById(Long id);
    String findFirstNameById(Long id);
    void insert(Singer singer);
    void update(Singer singer);
    void delete(Long singerId);
    List<Singer> findAllWithDetail();
    void insertWithDetail(Singer singer);
}
