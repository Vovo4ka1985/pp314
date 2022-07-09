package com.example.demo.controller;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("/admin/api/users")
public class ControllerApi {
    private final UserService userService;
    @Autowired
    public ControllerApi(UserService userService, UserRepository userRepository) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> showAllUser() {
        List<User> allUsers = userService.findAll();
        return allUsers;
    }

    @GetMapping("{id}")
    public User getOneUser(@PathVariable("id") int id) {
        return userService.getById(id);
    }

    @PostMapping()
    public User createNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }

}
