package com.muhammedtopgul.ch07.hibernate.test;

/*
 * created by Muhammed Topgul
 * on 18/08/2021
 * at 00:29
 */

import com.muhammedtopgul.ch07.hibernate.config.AppConfig;
import com.muhammedtopgul.ch07.hibernate.dao.SingerDao;
import com.muhammedtopgul.ch07.hibernate.entity.Album;
import com.muhammedtopgul.ch07.hibernate.entity.Singer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static com.muhammedtopgul.ch07.hibernate.SpringHibernateDemo.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SingerDaoTest {

    private GenericApplicationContext ctx;
    private SingerDao singerDao;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);
    }

    // INSERT
    @Test
    public void testInsert() {
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1940, 8, 16)).getTime().getTime()));

        Album album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(new Date(
                (new GregorianCalendar(1961, 7, 18)).getTime().getTime()));
        singer.addAlbum(album);

        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(new Date(
                (new GregorianCalendar(1962, 3, 20)).getTime().getTime()));
        singer.addAlbum(album);

        singerDao.save(singer);

        assertNotNull(singer.getId());
        List<Singer> singers = singerDao.findAllWithAlbum();
        assertEquals(4, singers.size());
        listSingersWithAlbum(singers);
    }

    @Test
    public void testFindAll() {
        List<Singer> singers = singerDao.findAll();
        assertEquals(3, singers.size());
        listSingers(singers);
    }

    @Test
    public void testFindAllWithAlbum() {
        List<Singer> singers = singerDao.findAllWithAlbum();
        assertEquals(3, singers.size());
        listSingersWithAlbum(singers);
    }

    @Test
    public void testFindByID() {
        Singer singer = singerDao.findById(1L);
        assertNotNull(singer);
        printSinger(singer);
    }

    // UPDATE
    @Test
    public void testUpdate(){
        Singer singer = singerDao.findById(1L);
        //making sure such singer exists
        assertNotNull(singer);
        //making sure we got expected singer
        assertEquals("Mayer", singer.getLastName());
        //retrieve the album
        Album album = singer.getAlbums()
                .stream().filter(
                a -> a.getTitle().equals("Battle Studies")).findFirst().get();
        singer.setFirstName("John Clayton");
        singer.removeAlbum(album);
        singerDao.save(singer);
        // test the update
        listSingersWithAlbum(singerDao.findAllWithAlbum());
    }

    // DELETE
    @Test
    public void testDelete(){
        Singer singer = singerDao.findById(2l);
        //making sure such singer exists
        assertNotNull(singer);
        singerDao.delete(singer);
        listSingersWithAlbum(singerDao.findAllWithAlbum());
    }

    @After
    public void tearDown(){
        ctx.close();
    }

    private static void listSingers(List<Singer> singers) {
        System.out.println(" ---- Listing singers:");
        for (Singer singer : singers) {
            printSinger(singer);
        }
    }
}
