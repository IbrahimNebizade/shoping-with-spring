package com.company.shoping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginDetails {
    private Long userDetailsId;
    private User user;
    private String email;
    private String password;
    private String phone;
}
