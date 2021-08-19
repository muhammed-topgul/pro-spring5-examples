package com.muhammedtopgul.ch08.springDataJpa.service;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 23:49
 */

import com.muhammedtopgul.ch08.springDataJpa.entity.SingerAudit;

import java.util.List;

public interface SingerAuditService {
    List<SingerAudit> findAll();

    SingerAudit findById(Long id);

    SingerAudit save(SingerAudit singer);
}