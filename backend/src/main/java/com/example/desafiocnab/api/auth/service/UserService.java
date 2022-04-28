package com.example.desafiocnab.api.auth.service;

import com.example.desafiocnab.api.auth.entity.UserDetailsImpl;
import com.example.desafiocnab.api.auth.repository.UserRepository;
import com.example.desafiocnab.api.auth.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetailsImpl loadUserByUsername(final String email) {
        User user = null;
        try {
            user = userRepository.findByEmail(email);
            UserDetailsImpl customUser = new UserDetailsImpl(user);
            return customUser;
        } catch (Exception e) {
            log.error("User " + email + " não encontrado!");
            throw new UsernameNotFoundException("User " + email + " não encontrado!");
        }
    }
}
