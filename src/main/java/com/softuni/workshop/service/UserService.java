package com.softuni.workshop.service;

import com.softuni.workshop.model.entity.dto.UserLoginDTO;
import com.softuni.workshop.model.entity.dto.UserRegisterDTO;

public interface UserService {

    boolean login(UserLoginDTO userLoginDTO);

    void logout();

    void registerAndLogin(UserRegisterDTO userRegisterDTO);
}
