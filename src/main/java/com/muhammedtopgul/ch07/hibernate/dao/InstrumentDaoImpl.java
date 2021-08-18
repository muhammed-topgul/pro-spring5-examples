package com.muhammedtopgul.ch07.hibernate.dao;

/*
 * created by Muhammed Topgul
 * on 18/08/2021
 * at 10:29
 */

import com.muhammedtopgul.ch07.hibernate.entity.Instrument;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Repository("instrumentDao")
public class InstrumentDaoImpl implements InstrumentDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Instrument save(Instrument instrument) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(instrument);
        System.out.println("Instrument saved with ID: " + instrument.getInstrumentId());
        return instrument;
    }
}
