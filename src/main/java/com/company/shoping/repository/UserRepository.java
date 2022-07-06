package com.company.shoping.repository;

import com.company.shoping.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Long findBalanceByUserId(Long userId);
    void updateBalanceByUserId(Long userId,Long newBalance);
    void favoriteInsert(Long productId);
    Optional<User> findByUserName(String name);
}
