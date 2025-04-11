package com.mattheojv.dev.pokedex_api.api.repository;

import com.mattheojv.dev.pokedex_api.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
