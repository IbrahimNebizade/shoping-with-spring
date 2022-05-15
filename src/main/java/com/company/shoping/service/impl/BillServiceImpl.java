package com.company.shoping.service.impl;

import com.company.shoping.dto.CreateBillCommand;
import com.company.shoping.dto.CreateBillResponse;
import com.company.shoping.mapper.BillMapper;
import com.company.shoping.repository.BillRepository;
import com.company.shoping.repository.UserRepository;
import com.company.shoping.service.BillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;
    private final UserRepository userRepository;

    @Override
    public CreateBillResponse createBill(CreateBillCommand command) {
        //userRepository.findById(command.getUser()).isPresent();
var bill= BillMapper.INSTANCE.createBillCommandtoBill(command);
billRepository.insert(bill);
        return new CreateBillResponse(bill.getId());
    }
}
