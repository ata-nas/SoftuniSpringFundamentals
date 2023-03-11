package com.softuni.workshop.web;

import com.softuni.workshop.model.entity.dto.UserRegisterDTO;
import com.softuni.workshop.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserService userService;

    @ModelAttribute("userModel")
    public UserRegisterDTO initUserModel() {
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(
            @Valid UserRegisterDTO userRegisterDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);

            return "redirect:/users/register";

        }
        userService.registerAndLogin(userRegisterDTO);
        return "redirect:/";
    }

}
