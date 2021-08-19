package com.muhammedtopgul.ch08.springDataJpa.repository;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 22:19
 */

import com.muhammedtopgul.ch08.springDataJpa.entity.Singer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SingerRepository extends CrudRepository<Singer, Long> {
    List<Singer> findByFirstName(String firstName);

    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}