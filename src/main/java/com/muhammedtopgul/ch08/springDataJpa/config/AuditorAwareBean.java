package com.muhammedtopgul.ch08.springDataJpa.config;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 23:57
 */

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareBean implements AuditorAware<String> {
    public Optional<String> getCurrentAuditor() {
        return Optional.of("muhammed.topgul");
    }
}