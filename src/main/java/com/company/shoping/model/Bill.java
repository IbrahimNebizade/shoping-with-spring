package com.company.shoping.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bill {
    private Long id;
    private User userId;
    private Long totalPrice;
    private Date billDate;
    private boolean adminConfirmed;
    private Product productId;
}
