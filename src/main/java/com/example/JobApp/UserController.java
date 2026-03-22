package com.example.JobApp;


import com.example.JobApp.model.User;
import com.example.JobApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("user")
@CrossOrigin(origins = "localhost:3000")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (service.verifyUniquess(user.getUsername())){
            User newuser = service.createOrUpdateUser(user);
            return new ResponseEntity<>(newuser, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("user")
    public User updateUser(@RequestBody User user) {
        return service.createOrUpdateUser(user);
    }
}
