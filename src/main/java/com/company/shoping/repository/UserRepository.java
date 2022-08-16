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

//    void favoriteInsert(Long productId);
    @Query("select u from Users u where u.name=:name")
    Optional<Users> findByUserName(@Param("name") String name);
    @Query("select u from Users u where u.email=:email")
    Optional<Users> findByEmail(@Param("email") String email);
    @Query("select u.password from Users u where u.password=:password")
    Optional<Users> findByPassword(@Param("password") String password);

}
