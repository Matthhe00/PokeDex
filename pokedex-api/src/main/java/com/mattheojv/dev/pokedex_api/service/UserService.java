package com.mattheojv.dev.pokedex_api.service;

import com.mattheojv.dev.pokedex_api.api.entity.User;
import com.mattheojv.dev.pokedex_api.api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User registerNewUser(User user) {
        return userRepo.save(user);
    }
}
