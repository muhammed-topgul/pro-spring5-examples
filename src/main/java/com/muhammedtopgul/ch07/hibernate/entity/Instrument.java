package com.muhammedtopgul.ch07.hibernate.entity;

/*
 * created by Muhammed Topgul
 * on 17/08/2021
 * at 17:39
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "instrument")
@Getter
@Setter
public class Instrument implements Serializable {

    @Id
    @Column(name = "INSTRUMENT_ID")
    private String instrumentId;

    @Override
    public String toString() {
        return "Instrument :" + this.instrumentId;
    }
}
