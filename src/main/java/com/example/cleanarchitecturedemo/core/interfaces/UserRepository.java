package com.example.cleanarchitecturedemo.core.interfaces;

import com.example.cleanarchitecturedemo.core.entities.User;
import java.util.List;

public interface UserRepository {
    User save(User user);
    User findById(String id);
    List<User> findAll();
}

