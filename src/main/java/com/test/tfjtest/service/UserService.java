package com.test.tfjtest.service;

import com.test.tfjtest.model.User;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    List<User> getUsers();
    void deleteUser(int id);
    User getUserById(int id);
}
