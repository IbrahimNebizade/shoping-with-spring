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
public class UpdateUserCommand {
    private Long id;
    private String name;
    private String surname;
    private Date birthDate;
    private String email;
    private String password;
    private String phone;
}
