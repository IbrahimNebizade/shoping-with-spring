package com.company.shoping.service;

import com.company.shoping.dto.CreateBillCommand;
import com.company.shoping.dto.CreateBillResponse;
import com.company.shoping.model.Bills;

import java.util.List;

public interface BillService {
    CreateBillResponse createBill(CreateBillCommand command);
    List<Bills> showBillByUserId(Long userId);

}
