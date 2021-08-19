package com.muhammedtopgul.ch08.springDataJpa.service;

/*
 * created by Muhammed Topgul
 * on 19/08/2021
 * at 23:37
 */

import com.muhammedtopgul.ch08.springDataJpa.entity.Album;
import com.muhammedtopgul.ch08.springDataJpa.entity.Singer;
import com.muhammedtopgul.ch08.springDataJpa.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("springJpaAlbumService")
@Transactional
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Album> findBySinger(Singer singer) {
        return albumRepository.findBySinger(singer);
    }

    @Override
    public List<Album> findByTitle(String title) {
        return albumRepository.findByTitle(title);
    }
}
