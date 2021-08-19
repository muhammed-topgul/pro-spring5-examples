package com.muhammedtopgul.ch08.springDataJpa.service;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 22:18
 */

import com.muhammedtopgul.ch08.springDataJpa.entity.Singer;

import java.util.List;

public interface SingerService {

    List<Singer> findAll();

    List<Singer> findByFirstName(String firstName);

    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}
