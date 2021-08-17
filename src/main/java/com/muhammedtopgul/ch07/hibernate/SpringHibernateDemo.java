package com.muhammedtopgul.ch07.hibernate;

/*
 * created by Muhammed Topgul
 * on 17/08/2021
 * at 22:52
 */

import com.muhammedtopgul.ch07.hibernate.config.AppConfig;
import com.muhammedtopgul.ch07.hibernate.dao.SingerDao;
import com.muhammedtopgul.ch07.hibernate.entity.Album;
import com.muhammedtopgul.ch07.hibernate.entity.Instrument;
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

        /*
        listSingers(singerDao.findAll());
        listSingersWithAlbum(singerDao.findAllWithAlbum());
        printSinger(singerDao.findById(1L));
         */



        ctx.close();
    }

    public static void printSinger(Singer singer) {
        System.out.println("\n" + singer.toString());
    }

    public static void listSingers(List<Singer> singers) {
        System.out.println("\n ---- Listing singers:");
        for (Singer singer : singers) {
            System.out.println(singer.toString());
        }
    }

    public static void listSingersWithAlbum(List<Singer> singers) {
        System.out.println(" \n---- Listing singers with instruments:");
        for (Singer singer : singers) {
            System.out.println(singer.toString());
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println("\t" + album.toString());
                }
            }
            if (singer.getInstruments() != null) {
                for (Instrument instrument : singer.getInstruments()) {
                    System.out.println("\t" + instrument.getInstrumentId());
                }
            }
        }
    }
}
