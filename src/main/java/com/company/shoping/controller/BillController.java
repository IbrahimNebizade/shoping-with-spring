package com.company.shoping.controller;

import com.company.shoping.dto.CreateBillCommand;
import com.company.shoping.dto.CreateBillResponse;
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
    @PostMapping("/show/bill/{userId}")
    public ResponseEntity<List<Bills>> showBill(@PathVariable Long userId){
    return ResponseEntity.ok(billService.showBillByUserId(userId));

    }

}
