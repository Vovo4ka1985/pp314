package com.example.demo.service;

import com.example.demo.models.Role;
import com.example.demo.models.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User getById(int id);

    List<User> findAll();

    void deleteById(int id);

    Set<Role> getAllRoles();

    void saveUser(User user);

    void updateUser(User updatedUser);
}
