package com.softuni.workshop.model.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {

    @NotEmpty(message = "username must not be blank!")
    @Size(min = 2, max = 20, message = "username must be between 2 and 20 symbols!")
    private String username;

    @NotEmpty
    @Size(min = 5)
    private String password;

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + (password != null ? "[PROVIDED]" : null) + '\'' +
                '}';
    }
}
