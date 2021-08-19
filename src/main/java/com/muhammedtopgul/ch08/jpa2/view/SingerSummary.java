package com.muhammedtopgul.ch08.jpa2.view;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 09:02
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class SingerSummary implements Serializable {

    private String firstName;
    private String lastName;
    private String latestAlbum;

    public String toString() {
        return "First name: " + firstName + ", Last Name: " + lastName
                + ", Most Recent Album: " + latestAlbum;
    }
}
