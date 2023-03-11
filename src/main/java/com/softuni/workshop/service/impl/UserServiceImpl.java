package com.softuni.workshop.service.impl;

import com.softuni.workshop.model.entity.UserEntity;
import com.softuni.workshop.model.entity.UserRoleEntity;
import com.softuni.workshop.model.entity.dto.UserLoginDTO;
import com.softuni.workshop.model.entity.dto.UserRegisterDTO;
import com.softuni.workshop.model.enums.UserRoleEnum;
import com.softuni.workshop.repository.UserRepository;
import com.softuni.workshop.service.UserService;
import com.softuni.workshop.user.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(userLoginDTO.getUsername());

        if (userOpt.isEmpty()) {
            LOGGER.info("User with name [{}] not found.", userLoginDTO.getUsername());
            return false;
        }

        String rawPassword = userLoginDTO.getPassword();
        String hashedPassword = userOpt.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, hashedPassword);

        if (success) {
            loginUser(userOpt.get());
        } else {
            logoutUser(userOpt.get().getEmail());
        }
        return success;
    }

    @Override
    public void logout() {
        currentUser.clear();
    }

    @Override
    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(userRegisterDTO.getEmail());

        if (userOpt.isPresent()) {
            LOGGER.info("User with email [{}] already exists.", userRegisterDTO.getEmail());
            return;
        }

        boolean matchingConfirmedPassword = userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword());
        if (!matchingConfirmedPassword) {
            LOGGER.info("Not matching Passwords!");
            return;
        }

        UserEntity newUser = new UserEntity()
                .setIsActive(true)
                .setFirstName(userRegisterDTO.getFirstName())
                .setLastName(userRegisterDTO.getLastName())
                .setEmail(userRegisterDTO.getEmail())
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        newUser = userRepository.save(newUser);

        loginUser(newUser);
    }

    private void loginUser(UserEntity userEntity) {
        currentUser
                .setLoggedIn(true)
                .setName(userEntity.getFirstName() + " " + userEntity.getLastName());
        LOGGER.info("User with username [{}] is logged!", userEntity.getEmail());
    }

    private void logoutUser(String username) {
        logout();
        LOGGER.info("User with username [{}] logged out!", username);
    }

}
