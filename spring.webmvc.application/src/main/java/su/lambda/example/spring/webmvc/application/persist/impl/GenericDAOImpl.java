/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.example.spring.webmvc.application.persist.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.transaction.annotation.Transactional;
import su.lambda.example.spring.webmvc.application.persist.GenericDAO;

/**
 *
 * @author stepan
 * @param <T>
 * @param <ID>
 */
@Transactional
public class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public T findReferenceById(ID id) {
        return entityManager.getReference(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(entityClass);
        query.select(query.from(entityClass));
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public Long getCount() {
        CriteriaQuery<Long> query = entityManager.getCriteriaBuilder().createQuery(Long.class);
        query.select(entityManager.getCriteriaBuilder().count(query.from(entityClass)));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public T makePersistent(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void makeTransient(T entity) {
        entityManager.remove(entity);
    }

}
