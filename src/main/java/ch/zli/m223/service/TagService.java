package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Tag;

@ApplicationScoped
public class TagService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Tag createEntry(Tag tag) {
        entityManager.persist(tag);
        return tag;
    }

    public List<Tag> findAll() {
        var query = entityManager.createQuery("FROM Tag", Tag.class);
        return query.getResultList();
    }

    @Transactional
    public void deleteEntry(Long Id) {
        Tag tag = entityManager.find(Tag.class, Id);
        entityManager.remove(tag);
    }

    @Transactional
    public void update(Tag tag){
        entityManager.merge(tag);
    }
}
