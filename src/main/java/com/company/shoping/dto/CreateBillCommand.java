package com.company.shoping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBillCommand {
    private Long userId;
    private Long totalPrice;
    private Date billDate;
    private Boolean adminConfirmed;
    private Long productId;
}
