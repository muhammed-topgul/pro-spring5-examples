package com.muhammedtopgul.ch06.jdbc.embedded.test;

/*
 * created by Muhammed Topgul
 * on 17/08/2021
 * at 16:14
 */

import com.muhammedtopgul.ch06.jdbc.embedded.EmbeddedJdbcConfig;
import com.muhammedtopgul.ch06.jdbc.embedded.SingerDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JdbcCfgTest {

    @Test
    public void testH2DB() {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
        testDao(ctx.getBean(SingerDao.class));
    }

    private void testDao(SingerDao singerDao) {
        assertNotNull(singerDao);
        String singerName = singerDao.findNameById(1l);
        assertTrue("John Mayer".equals(singerName));
    }
}
