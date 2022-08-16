package com.company.shoping.service;

import com.company.shoping.dto.CreateBillCommand;
import com.company.shoping.dto.CreateBillResponse;
import com.company.shoping.dto.FindBillById;
import com.company.shoping.model.Bills;

import java.util.List;
import java.util.Optional;

public interface BillService {
    CreateBillResponse createBill(CreateBillCommand command);
    FindBillById showBillByUserId(Long userId);
    FindBillById findBillByBillId(Long id);
    void deleteByBillId(Long billId);
}
