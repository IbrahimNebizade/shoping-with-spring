package com.company.shoping.repository;

import com.company.shoping.model.Bill;

import java.util.Optional;

public interface BillRepository extends CrudRepository<Bill,Long> {
    Optional<Bill> findByUserId(Long userId);
}
