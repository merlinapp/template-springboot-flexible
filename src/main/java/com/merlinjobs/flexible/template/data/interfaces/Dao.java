package com.merlinjobs.flexible.template.data.interfaces;

import com.merlinjobs.flexible.template.data.models.User;

import java.util.List;

public interface Dao<T> {

    /**
     * @param id UUID of record
     * @return record
     */
    User get(String id);

    /**
     * @param q quantity of records
     * @return list of records of T model
     */
    List<T> getAny(int q);

    /**
     * @param t Class model
     * @return id
     * Save given record and return the id
     */
    String save(T t);

    /**
     * @param t Class model
     * Save given record asynchronous
     */
    void saveAsync(T t);

    /**
     * @param t Class model
     * Delete given record asynchronous
     */
    void delete(T t);


}
