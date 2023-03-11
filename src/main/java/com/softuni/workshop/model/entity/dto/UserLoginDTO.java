package com.softuni.workshop.model.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {

    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + (password != null ? "[PROVIDED]" : null) + '\'' +
                '}';
    }
}
