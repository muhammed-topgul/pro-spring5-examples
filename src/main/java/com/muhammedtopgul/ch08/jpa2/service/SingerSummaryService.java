package com.muhammedtopgul.ch08.jpa2.service;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 09:05
 */

import com.muhammedtopgul.ch08.jpa2.view.SingerSummary;

import java.util.List;

public interface SingerSummaryService {

    List<SingerSummary> findAll();
}
