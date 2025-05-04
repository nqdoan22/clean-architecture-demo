package com.example.cleanarchitecturedemo.adapters.gateways;

import com.example.cleanarchitecturedemo.core.entities.User;
import com.example.cleanarchitecturedemo.core.interfaces.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Repository
public class UserGateway implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional 
    public User save(User user) {
        // nếu chưa có id, sinh mới UUID
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }
        em.persist(user);
        return user;
    }

    @Override
    public User findById(String id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class)
                 .getResultList();
    }
}
