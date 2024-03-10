package com.pjm.projectsns.controller;

import com.pjm.projectsns.model.User;
import com.pjm.projectsns.model.UserRole;
import com.pjm.projectsns.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public void login() {
    }

    @GetMapping("/join")
    public void join(){

    }
    @PostMapping("/signup")
    public String register(User user){
        String password=user.getPassword();
        String enPassword=bCryptPasswordEncoder.encode(password);
        user.setPassword(enPassword);
        user.setRole(UserRole.valueOf("USER"));
        repository.save(user);
        return "redirect:/user/login";
    }
}
