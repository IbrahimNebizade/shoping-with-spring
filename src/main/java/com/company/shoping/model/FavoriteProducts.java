package com.company.shoping.model;

import liquibase.pro.packaged.J;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavoriteProducts implements Serializable {

    private Long id;

    private User user;

    private Product product;
}
