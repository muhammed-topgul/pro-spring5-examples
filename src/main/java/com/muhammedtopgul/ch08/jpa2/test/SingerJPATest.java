package com.muhammedtopgul.ch08.jpa2.test;

/*
 * created by Muhammed Topgul
 * on 18/08/2021
 * at 23:55
 */

import com.muhammedtopgul.ch08.jpa2.config.JpaConfig;
import com.muhammedtopgul.ch08.jpa2.entity.Album;
import com.muhammedtopgul.ch08.jpa2.entity.Instrument;
import com.muhammedtopgul.ch08.jpa2.entity.Singer;
import com.muhammedtopgul.ch08.jpa2.service.SingerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SingerJPATest {

    private GenericApplicationContext ctx;
    private SingerService singerService;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        singerService = ctx.getBean(SingerService.class);
        assertNotNull(singerService);
    }

    @Test
    public void testFindAll() {
        List<Singer> singers = singerService.findAll();
        assertEquals(3, singers.size());
        listSingers(singers);
    }

    @Test
    public void testFindAllWithAlbum() {
        List<Singer> singers = singerService.findAllWithAlbum();
        assertEquals(3, singers.size());
        listSingersWithAlbum(singers);
    }

    @Test
    public void testFindById() {
        Singer singer = singerService.findById(1L);
        assertNotNull(singer);
        System.out.println(singer.toString());
    }

    private static void listSingersWithAlbum(List<Singer> singers) {
        System.out.println(" ---- Listing singers with instruments:");
        for (Singer singer : singers) {
            System.out.println(singer.toString());
            if (singer.getAlbums() != null) {
                for (Album album :
                        singer.getAlbums()) {
                    System.out.println("\t" + album.toString());
                }
            }
            if (singer.getInstruments() != null) {
                for (Instrument instrument : singer.getInstruments()) {
                    System.out.println("\tInstrument: " + instrument.getInstrumentId());
                }
            }
        }
    }

    private static void listSingers(List<Singer> singers) {
        System.out.println(" ---- Listing singers:");
        for (Singer singer : singers) {
            System.out.println(singer.toString());
        }
    }

    @After
    public void tearDown() {
        ctx.close();
    }
}
