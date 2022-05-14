package com.company.shoping.repository;

import com.company.shoping.model.User;
import com.company.shoping.model.UserLoginDetails;

import java.util.Optional;

public interface LoginDetailsRepository extends CrudRepository<UserLoginDetails,Long> {
    Optional<UserLoginDetails> findUnique(String email, String number);
}
