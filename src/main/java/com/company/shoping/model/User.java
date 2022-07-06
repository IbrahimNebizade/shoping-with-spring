package com.company.shoping.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter(value = AccessLevel.PUBLIC)
public class User  {
    private Long id;

    private String name;
    private String surname;
    private Date birthDate;
    private Date createdAt;
    private FavoriteProducts favoriteProduct;
    //private Role role;
    private Long balance;
}
