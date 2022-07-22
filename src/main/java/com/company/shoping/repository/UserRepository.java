package com.company.shoping.repository;

import com.company.shoping.dto.UpdateUserCommand;
import com.company.shoping.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("select d.email,d.phone from Users d where d.email=:email or d.phone=:phone")
    Optional<Users> findUnique(@Param("email") String email,@Param("phone") String phone);
    @Query("select u.balance from Users u where u.id=:id")
    Long findBalanceByUserId(@Param("id") Long userId);

    @Query("update Users u set u.balance=:balance where u.id=:id")
    void updateBalanceByUserId(@Param("id") Long userId, @Param("balance") Long newBalance);
//    void favoriteInsert(Long productId);
    @Query("select u from Users u where u.name=:name")
    Optional<Users> findByUserName(@Param("name") String name);

}
