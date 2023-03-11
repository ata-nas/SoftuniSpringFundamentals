package com.softuni.workshop.web;

import com.softuni.workshop.model.entity.dto.UserLoginDTO;
import com.softuni.workshop.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(
            @Valid UserLoginDTO userLoginDTO,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "redirect:/users/login";
        }
        userService.login(userLoginDTO);
        return "redirect:/";
    }

}
