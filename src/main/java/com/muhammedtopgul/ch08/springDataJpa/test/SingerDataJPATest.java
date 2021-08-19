package com.muhammedtopgul.ch08.springDataJpa.test;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 22:31
 */

import com.muhammedtopgul.ch08.springDataJpa.config.DataJpaConfig;
import com.muhammedtopgul.ch08.springDataJpa.entity.Singer;
import com.muhammedtopgul.ch08.springDataJpa.service.SingerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class SingerDataJPATest {

    private GenericApplicationContext ctx;
    private SingerService singerService;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        singerService = ctx.getBean(SingerService.class);
        assertNotNull(singerService);
    }

    @Test
    public void testFindAll() {
        List<Singer> singers = singerService.findAll();
        assertTrue(singers.size() > 0);
        listSingers(singers);
    }

    @Test
    public void testFindByFirstName() {
        List<Singer> singers = singerService.findByFirstName("John");
        assertTrue(singers.size() > 0);
        assertEquals(2, singers.size());
        listSingers(singers);
    }

    @Test
    public void testFindByFirstNameAndLastName() {
        List<Singer> singers =
                singerService.findByFirstNameAndLastName("John", "Mayer");
        assertTrue(singers.size() > 0);
        assertEquals(1, singers.size());
        listSingers(singers);
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
