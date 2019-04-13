package com.feloro.service;

import com.feloro.database.domain.User;
import com.feloro.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(String username, Integer role, String pass) {
        User user = new User();
        user.setName(username);
        user.setPassword(BCrypt.hashpw(pass, BCrypt.gensalt()));
        user.setRole(role);
        return userRepository.saveAndFlush(user);
    }

    public User createTestUser(){
        User user = new User();
        user.setName("kek");
        user.setPassword(BCrypt.hashpw("pass", BCrypt.gensalt()));
        user.setRole(1);
        return userRepository.saveAndFlush(user);
    }

    public User getUser(UUID uuid) {
        return userRepository.findById(uuid).get();
    }

    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }
}
