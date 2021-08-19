package com.muhammedtopgul.ch08.springDataJpa.entity;

/*
 * created by Muhammed Topgul
 * on 17/08/2021
 * at 17:30
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "singer")
@NamedQueries({
        @NamedQuery(name = Singer.FIND_ALL, query = "select s from Singer s"),
        @NamedQuery(name = Singer.FIND_ALL_WITH_ALBUM,
                query = "select distinct s from Singer s " +
                        "left join fetch s.albums a " +
                        "left join fetch s.instruments"),
        @NamedQuery(name = Singer.FIND_SINGER_BY_ID,
                query = "select distinct s from Singer s " +
                        "left join fetch s.albums a " +
                        "left join fetch s.instruments " +
                        "where s.id = :id")
})
@SqlResultSetMapping(name = "singerResult",
        entities = @EntityResult(entityClass = Singer.class))
@Getter
@Setter
public class Singer implements Serializable {

    public static final String FIND_ALL = "Singer.findAll";
    public static final String FIND_SINGER_BY_ID = "Singer.findById";
    public static final String FIND_ALL_WITH_ALBUM = "Singer.findAllWithAlbum";

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

    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Album> albums = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "singer_instrument",
            joinColumns = @JoinColumn(name = "SINGER_ID"),
            inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
    private Set<Instrument> instruments = new HashSet<>();

    //
    public boolean addAlbum(Album album) {
        album.setSinger(this);
        return getAlbums().add(album);
    }

    public void removeAlbum(Album album) {
        getAlbums().remove(album);
    }

    public boolean addInstrument(Instrument instrument) {
        return getInstruments().add(instrument);
    }

    @Override
    public String toString() {
        return "Singer - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }
}
