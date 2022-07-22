package com.company.shoping.service.impl;

import com.company.shoping.dto.CreateBillCommand;
import com.company.shoping.dto.CreateBillResponse;
import com.company.shoping.mapper.BillMapper;
import com.company.shoping.model.Bills;
import com.company.shoping.repository.BillRepository;
import com.company.shoping.repository.ProductRepository;
import com.company.shoping.repository.UserRepository;
import com.company.shoping.service.BillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public CreateBillResponse createBill(CreateBillCommand command) {
        var userBalance = userRepository.findBalanceByUserId(command.getUserId());
        if (userBalance > command.getTotalPrice()) {
            var newBalance = userBalance - command.getTotalPrice();
            userRepository.updateBalanceByUserId(command.getUserId(), newBalance);
            var bill = BillMapper.INSTANCE.createBillCommandoBill(command);
            bill = billRepository.save(bill);
            return new CreateBillResponse(bill.getId());
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Bills> showBillByUserId(Long userId) {
        return billRepository.findByUserId(userId);
    }

}
