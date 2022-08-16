package com.company.shoping.controller;

import com.company.shoping.dto.CreateBillCommand;
import com.company.shoping.dto.CreateBillResponse;
import com.company.shoping.dto.FindBillById;
import com.company.shoping.model.Bills;
import com.company.shoping.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/bills")
public class BillController {
    private final BillService billService;
@PostMapping("/create")
    public ResponseEntity<CreateBillResponse> createBill(@RequestBody CreateBillCommand command){

        return ResponseEntity.status(HttpStatus.CREATED).body(billService.createBill(command));
    }
    @GetMapping("/find-bill/{userId}")
    public ResponseEntity<FindBillById> showBill(@PathVariable Long userId){
    return ResponseEntity.ok(billService.showBillByUserId(userId));
    }
    @GetMapping("/find-bill/{billId}")
    public ResponseEntity<FindBillById> findBillByBillId(@PathVariable Long billId){
    return ResponseEntity.ok(billService.findBillByBillId(billId));
    }
    @DeleteMapping("/deleteBill/{billId}")
    public ResponseEntity<Void > deleteBill(@PathVariable Long billId){
    billService.deleteByBillId(billId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
