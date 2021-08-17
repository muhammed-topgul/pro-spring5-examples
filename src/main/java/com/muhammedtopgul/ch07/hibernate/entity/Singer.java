package com.muhammedtopgul.ch07.hibernate.entity;

/*
 * created by Muhammed Topgul
 * on 17/08/2021
 * at 17:30
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "singer")
public class Singer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Override
    public String toString() {
        return "Singer - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }
}
