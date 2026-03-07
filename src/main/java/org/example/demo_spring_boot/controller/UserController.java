package org.example.demo_spring_boot.controller;

import jakarta.validation.Valid;
import org.example.demo_spring_boot.model.User;
import org.example.demo_spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user") //name of endpoint
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
//new comment
    @Autowired
    private UserRepository userRepository;

    // ---------------- CREATE (POST) ----------------
    @PostMapping
    public User createUser(@Valid @RequestBody User user)
    {
        return userRepository.save(user);
    }


}
