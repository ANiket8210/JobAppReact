package com.example.JobApp.service;


import com.example.JobApp.model.User;
import com.example.JobApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    BCryptPasswordEncoder encoder;

    public User createOrUpdateUser(User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        return repo.save(user);
    }

    public boolean verifyUniquess(String username) {
        return repo.findByUsername(username) == null;
    }
}
