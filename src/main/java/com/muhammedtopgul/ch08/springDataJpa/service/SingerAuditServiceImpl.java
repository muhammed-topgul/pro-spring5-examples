package com.muhammedtopgul.ch08.springDataJpa.service;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 23:51
 */

import com.google.common.collect.Lists;
import com.muhammedtopgul.ch08.springDataJpa.entity.SingerAudit;
import com.muhammedtopgul.ch08.springDataJpa.repository.SingerAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("singerAuditService")
@Transactional
public class SingerAuditServiceImpl implements SingerAuditService {

    @Autowired
    private SingerAuditRepository singerAuditRepository;

    @Transactional(readOnly = true)
    @Override
    public List<SingerAudit> findAll() {
        return Lists.newArrayList(singerAuditRepository.findAll());
    }

    @Override
    public SingerAudit findById(Long id) {
        return singerAuditRepository.findById(id).get();
    }

    @Override
    public SingerAudit save(SingerAudit singer) {
        return singerAuditRepository.save(singer);
    }
}
