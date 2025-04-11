package com.mattheojv.dev.pokedex_api.api.controller;

import com.mattheojv.dev.pokedex_api.api.entity.User;
import com.mattheojv.dev.pokedex_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compte")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Object registerUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }
}
