package com.example.cleanarchitecturedemo.core.usecases;

import org.springframework.stereotype.Service;
import com.example.cleanarchitecturedemo.core.entities.User;
import com.example.cleanarchitecturedemo.core.interfaces.UserRepository;

@Service  // This annotation indicates that this class is a service component in the Spring context.
// It is used to define a service layer in the application, which contains business logic and interacts with repositories.
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String name, String email) {
        User user = new User(name, email);
        return userRepository.save(user);
    }
}
