package com.muhammedtopgul.ch08.jpa2.service;

/*
 * created by Muhammed Topgul
 * on 18/08/2021
 * at 23:38
 */

import com.muhammedtopgul.ch08.jpa2.criteriaApi.Singer_;
import com.muhammedtopgul.ch08.jpa2.entity.Singer;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Service("jpaSingerService")
@Repository
@Transactional
public class SingerServiceImpl implements SingerService {

    static final String ALL_SINGER_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from singer";

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return entityManager
                .createNamedQuery(Singer.FIND_ALL, Singer.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllWithAlbum() {
        return entityManager
                .createNamedQuery(Singer.FIND_ALL_WITH_ALBUM, Singer.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(Long id) {
        TypedQuery<Singer> query = entityManager.createNamedQuery
                (Singer.FIND_SINGER_BY_ID, Singer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Singer save(Singer singer) {
        if (singer.getId() == null) {
            System.out.println("Inserting new singer");
            entityManager.persist(singer);
        } else {
            System.out.println("Updating existing singer");
            entityManager.merge(singer);
        }
        System.out.println("Saved singer id: " + singer.getId());
        return singer;
    }

    @Override
    public void delete(Singer singer) {
        Singer mergedSinger = entityManager.merge(singer);
        entityManager.remove(mergedSinger);
        System.out.println("Singer with id: " + singer.getId() + " deleted successfully");
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllByNativeQuery() {
        return entityManager
                .createNativeQuery(ALL_SINGER_NATIVE_QUERY, "singerResult")
                .getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findByCriteriaQuery(String firstName, String lastName) {
        System.out.println("Finding singer for firstName: " + firstName
                + " and lastName: " + lastName);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Singer> criteriaQuery = criteriaBuilder.createQuery(Singer.class);
        Root<Singer> singerRoot = criteriaQuery.from(Singer.class);
        singerRoot.fetch(Singer_.albums, JoinType.LEFT);
        singerRoot.fetch(Singer_.instruments, JoinType.LEFT);
        criteriaQuery.select(singerRoot).distinct(true);

        Predicate criteria = criteriaBuilder.conjunction();
        if (firstName != null) {
            Predicate predicate = criteriaBuilder.equal(singerRoot.get(Singer_.firstName), firstName);
            criteria = criteriaBuilder.and(criteria, predicate);
        }
        if (lastName != null) {
            Predicate predicate = criteriaBuilder.equal(singerRoot.get(Singer_.lastName), lastName);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        criteriaQuery.where(criteria);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
