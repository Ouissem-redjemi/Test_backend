package com.test.tfjtest.service;

import com.test.tfjtest.model.User;
import com.test.tfjtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRep;

    @Override
    public User saveUser(User user) {
        return userRep.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRep.findAll();
    }

    @Override
    public void deleteUser(int id) {
        userRep.deleteById(id);
        System.out.println("Utilisateur supprimé");
    }


    @Override
    public User getUserById(int id) {
        Optional<User> user = userRep.findById(id);
        return user.orElse(null);

    }
}
