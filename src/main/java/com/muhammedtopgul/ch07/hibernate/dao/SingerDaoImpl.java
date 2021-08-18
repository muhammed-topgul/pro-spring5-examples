package com.muhammedtopgul.ch07.hibernate.dao;

/*
 * created by Muhammed Topgul
 * on 17/08/2021
 * at 22:45
 */

import com.muhammedtopgul.ch07.hibernate.entity.Singer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("singerDao")
public class SingerDaoImpl implements SingerDao {

    private static final Log logger = LogFactory.getLog(SingerDaoImpl.class);
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select s from Singer s")
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllWithAlbum() {
        return sessionFactory
                .getCurrentSession()
                .getNamedQuery("Singer.findAllWithAlbum")
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(Long id) {
        return (Singer) sessionFactory
                .getCurrentSession()
                .getNamedQuery("Singer.findById")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public Singer save(Singer singer) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(singer);
        System.out.println("Singer saved with id: " + singer.getId());
        return singer;
    }

    @Override
    public void delete(Singer singer) {
        sessionFactory.getCurrentSession().delete(singer);
    }
}
