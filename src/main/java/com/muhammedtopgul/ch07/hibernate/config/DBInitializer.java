package com.muhammedtopgul.ch07.hibernate.config;

/*
 * created by Muhammed Topgul
 * on 18/08/2021
 * at 10:25
 */

import com.muhammedtopgul.ch07.hibernate.dao.InstrumentDao;
import com.muhammedtopgul.ch07.hibernate.dao.SingerDao;
import com.muhammedtopgul.ch07.hibernate.entity.Album;
import com.muhammedtopgul.ch07.hibernate.entity.Instrument;
import com.muhammedtopgul.ch07.hibernate.entity.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.GregorianCalendar;

@Service
public class DBInitializer {

    @Autowired
    SingerDao singerDao;

    @Autowired
    InstrumentDao instrumentDao;

    @PostConstruct
    public void initDB() {
        System.out.println("Starting database initialization...");
        Instrument guitar = new Instrument();
        guitar.setInstrumentId("Guitar");
        instrumentDao.save(guitar);

        Singer singer = new Singer();
        singer.setFirstName("Johns");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1977, 9, 16)).getTime().getTime()));
        singer.addInstrument(guitar);

        Album album1 = new Album();
        album1.setTitle("The Search For Everything");
        album1.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(2017, 0, 20)).getTime().getTime()));
        singer.addAlbum(album1);

        Album album2 = new Album();
        album2.setTitle("Battle Studies");
        album2.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(2009, 10, 17)).getTime().getTime()));
        singer.addAlbum(album2);
        singerDao.save(singer);
    }
}
