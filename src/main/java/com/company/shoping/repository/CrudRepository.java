package com.company.shoping.repository;

import com.company.shoping.model.User;

import java.util.List;
import java.util.Optional;

public interface CrudRepository <T,ID>{
    T insert(T entity);
    Optional<T> findById(ID id);
    T updateById(ID id);
    void deleteById(ID id);
}