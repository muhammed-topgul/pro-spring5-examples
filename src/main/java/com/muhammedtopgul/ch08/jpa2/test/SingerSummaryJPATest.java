package com.muhammedtopgul.ch08.jpa2.test;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 09:14
 */

import com.muhammedtopgul.ch08.jpa2.config.JpaConfig;
import com.muhammedtopgul.ch08.jpa2.service.SingerSummaryService;
import com.muhammedtopgul.ch08.jpa2.view.SingerSummary;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SingerSummaryJPATest {

    private GenericApplicationContext ctx;
    private SingerSummaryService singerSummaryService;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        singerSummaryService = ctx.getBean(SingerSummaryService.class);
        assertNotNull(singerSummaryService);
    }

    @Test
    public void testFindAll() {
        List<SingerSummary> singers = singerSummaryService.findAll();
        listSingerSummary(singers);
        assertEquals(2, singers.size());
    }

    private static void listSingerSummary(List<SingerSummary> singers) {
        System.out.println(" ---- Listing singers summary:");
        for (SingerSummary singer : singers) {
            System.out.println(singer.toString());
        }
    }

    @After
    public void tearDown() {
        ctx.close();
    }
}
