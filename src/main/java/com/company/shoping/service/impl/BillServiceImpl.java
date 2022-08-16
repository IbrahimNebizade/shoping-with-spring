package com.company.shoping.service.impl;

import com.company.shoping.dto.CreateBillCommand;
import com.company.shoping.dto.CreateBillResponse;
import com.company.shoping.dto.FindBillById;
import com.company.shoping.mapper.BillMapper;
import com.company.shoping.repository.BillRepository;
import com.company.shoping.repository.ProductRepository;
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
    private final ProductRepository productRepository;

    @Override
    public CreateBillResponse createBill(CreateBillCommand command) {
        var userBalance = userRepository.findBalanceByUserId(command.getUserId());
        if (userBalance > command.getTotalPrice()) {
            var newBalance = userBalance - command.getTotalPrice();
            userRepository.findById(command.getUserId()).ifPresent(users -> {
                users.setBalance(newBalance);
                userRepository.save(users);
            });
            var bill = BillMapper.INSTANCE.createBillCommandoBill(command);
            bill = billRepository.save(bill);
            return new CreateBillResponse(bill.getId());
        } else {
            throw new RuntimeException("balance.not-enough");
        }
    }

    @Override
    public FindBillById showBillByUserId(Long userId) {
        return billRepository.findByUserId(userId);
    }

    @Override
    public FindBillById findBillByBillId(Long id) {
        var bill = billRepository.findById(id).orElseThrow();
        return FindBillById.builder()
                .billDate(bill.getBillDate())
                .totalPrice(bill.getTotalPrice())
                .productsId(bill.getProductId().getId())
                .userId(bill.getUserId().getId())
                .build();
    }

    @Override
    public void deleteByBillId(Long billId) {
        billRepository.deleteById(billId);
    }

}
