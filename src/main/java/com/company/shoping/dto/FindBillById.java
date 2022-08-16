package com.company.shoping.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindBillById {
 private Date billDate;
 private Long totalPrice;
 private Long productsId;
 private Long userId;
}
