package com.muhammedtopgul.ch06.jdbc.crud;

/*
 * created by Muhammed Topgul
 * on 15/08/2021
 * at 23:07
 */

import com.muhammedtopgul.ch06.jdbc.crud.dao.PlainSingerDao;
import com.muhammedtopgul.ch06.jdbc.crud.dao.SingerDao;
import com.muhammedtopgul.ch06.jdbc.crud.entity.Singer;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class PlainJdbcDemo {

    private static SingerDao singerDao = new PlainSingerDao();
    private static Logger logger = LoggerFactory.getLogger(PlainJdbcDemo.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Listing initial singer date: ");

        listAllSingers();

        logger.info("-------------");
        logger.info("Insert a new singer");
        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDate(new Date
                ((new GregorianCalendar(1991, 2, 1991)).getTime().getTime()));
        singerDao.insert(singer);
        logger.info("Listing singer data after new singer created:");

        listAllSingers();
        logger.info("-------------");
        logger.info("Deleting the previous created singer");
        singerDao.delete(singer.getId());
        logger.info("Listing singer data after new singer deleted:");
        listAllSingers();
    }

    private static void listAllSingers() {
        List<Singer> singers = singerDao.findAll();
        for (Singer singer: singers) {
            logger.info(singer.toString());
        }
    }
}
