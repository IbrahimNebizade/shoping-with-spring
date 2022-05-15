package com.company.shoping.service;

import com.company.shoping.dto.CreateBillCommand;
import com.company.shoping.dto.CreateBillResponse;
public interface BillService {
    CreateBillResponse createBill(CreateBillCommand command);
}
