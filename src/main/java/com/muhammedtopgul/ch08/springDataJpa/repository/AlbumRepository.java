package com.muhammedtopgul.ch08.springDataJpa.repository;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 23:35
 */

import com.muhammedtopgul.ch08.springDataJpa.entity.Album;
import com.muhammedtopgul.ch08.springDataJpa.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findBySinger(Singer singer);

    @Query("select a from Album a where a.title like %:title%")
    List<Album> findByTitle(@Param("title") String t);
}