package com.softuni.workshop.model.entity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

}
