package com.muhammedtopgul.ch07.hibernate;

/*
 * created by Muhammed Topgul
 * on 17/08/2021
 * at 22:52
 */

import com.muhammedtopgul.ch07.hibernate.config.AppConfig;
import com.muhammedtopgul.ch07.hibernate.dao.SingerDao;
import com.muhammedtopgul.ch07.hibernate.entity.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class SpringHibernateDemo {

    private static Logger logger = LoggerFactory.getLogger(SpringHibernateDemo.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        SingerDao singerDao = ctx.getBean(SingerDao.class);
        listSingers(singerDao.findAll());

        System.out.println(singerDao.findById(1L));
        ctx.close();
    }

    private static void listSingers(List<Singer> singers) {
        logger.debug(" ---- Listing singers:");
        for (Singer singer : singers) {
            System.out.println(singer.toString());
        }
    }
}
