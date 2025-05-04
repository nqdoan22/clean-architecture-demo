package com.example.cleanarchitecturedemo.adapters.controllers;

import com.example.cleanarchitecturedemo.core.usecases.CreateUserUseCase;
import com.example.cleanarchitecturedemo.core.entities.User;
import com.example.cleanarchitecturedemo.core.interfaces.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UserRepository userRepository;

    // Inject cả hai bean
    public UserController(CreateUserUseCase createUserUseCase,
                          UserRepository userRepository) {
        this.createUserUseCase = createUserUseCase;
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(@RequestParam String name,
                           @RequestParam String email) {
        return createUserUseCase.execute(name, email);
    }

    // Thêm GET /users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userRepository.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    // Thêm GET /users
    @GetMapping
    public List<User> listAll() {
        return userRepository.findAll();
    }
}
