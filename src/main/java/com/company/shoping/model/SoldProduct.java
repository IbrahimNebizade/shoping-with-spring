package com.company.shoping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SoldProduct {
    private Long id;
    private Long price;
    private boolean inBasket;
    private List<Product> productId;
    private Bill billId;
    private User userId;

}
