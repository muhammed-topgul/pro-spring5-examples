package com.muhammedtopgul.ch04.configWithJava.configureWithBean;

/*
 * created by Muhammed Topgul
 * on 28/07/2021
 * at 13:17
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:ch04/configWithJava/message.properties")
public class AppConfigThree {

    @Autowired
    Environment env;

    @Bean
    @Lazy
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean(name = "messageRenderer")
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}
