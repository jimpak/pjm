package com.example.androidserver.controller;

import com.example.androidserver.model.User;
import com.example.androidserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/getUserId/{id}")
    public User getUser(@PathVariable Long id) {
        log.info("id=" + id);
        return userRepository.findById(id).get();
    }

    @GetMapping("/getUsername/{username}")
    public User getUsername(@PathVariable String username) {
        log.info("username=" + username);
        return userRepository.findByUsername(username);
    }

    @PostMapping("/insert")
    public String insert(@RequestBody User user) { // json 형태로 User데이터를 가져옴
        log.info("user=" + user);
        userRepository.save(user);
        return "user data save";
    }

//    @GetMapping("/list")
//    public List<User> getList() {
//        List<User> list = userRepository.findAll();
//        return list;
//    }

    @GetMapping("/list")
    public Map<String, List<User>> getMap() {
        Map<String, List<User>> map = new HashMap<>();
        map.put("users", userRepository.findAll());
        return map;
    }


}
