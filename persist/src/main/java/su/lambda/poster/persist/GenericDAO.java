/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.poster.persist;

import java.util.List;

/**
 *
 * @author stepan
 * @param <T>
 * @param <ID>
 */
public interface GenericDAO<T, ID> {

    T findById(ID id);

    T findReferenceById(ID id);

    List<T> findAll();

    Long getCount();

    T makePersistent(T entity);

    void makeTransient(T entity);
}
