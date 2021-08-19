package com.muhammedtopgul.ch08.springDataJpa.repository;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 23:35
 */

import com.muhammedtopgul.ch08.springDataJpa.entity.SingerAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SingerAuditRepository extends CrudRepository<SingerAudit, Long> {

}