package com.muhammedtopgul.ch08.springDataJpa.entity;

/*
 * created by Muhammed Topgul
 * on 17/08/2021
 * at 17:39
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instrument")
@Getter
@Setter
public class Instrument implements Serializable {

    @Id
    @Column(name = "INSTRUMENT_ID")
    private String instrumentId;

    @ManyToMany
    @JoinTable(name = "singer_instrument",
            joinColumns = @JoinColumn(name = "INSTRUMENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "SINGER_ID"))
    private Set<Singer> singers = new HashSet<>();

    @Override
    public String toString() {
        return "Instrument :" + this.instrumentId;
    }
}
