package com.muhammedtopgul.ch07.hibernate.dao;

/*
 * created by Muhammed Topgul
 * on 18/08/2021
 * at 10:26
 */

import com.muhammedtopgul.ch07.hibernate.entity.Instrument;

public interface InstrumentDao {

    Instrument save(Instrument instrument);
}
