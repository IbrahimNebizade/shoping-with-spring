package com.company.shoping.repository;

import com.company.shoping.dto.FindBillById;
import com.company.shoping.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillRepository extends JpaRepository<Bills,Long> {
    @Query("select b from Bills b where b.userId=:userId")
    FindBillById findByUserId(@Param("userId") Long userId);
}
