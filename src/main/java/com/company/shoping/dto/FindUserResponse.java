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
public class FindUserResponse {
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Date birthDate;
    private Long balance;
}
