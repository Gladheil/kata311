package org.kata.kata311.service;


import org.kata.kata311.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    List<User> getAll();
    User getUserById(int id);
    void deleteUserById(int id);
}
