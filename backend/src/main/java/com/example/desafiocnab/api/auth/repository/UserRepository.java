package com.example.desafiocnab.api.auth.repository;

import com.example.desafiocnab.api.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
