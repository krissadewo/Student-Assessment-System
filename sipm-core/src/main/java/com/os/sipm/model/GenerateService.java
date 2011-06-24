/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author kris
 */
public interface GenerateService<T> {

    int saveOrUpdate(T entity);

    int delete(T entity);

    T getById(Integer id);

    List<T> getByName(Map<Object, Object> params);

    List<T> getAll(Map<Object, Object> params);
}
