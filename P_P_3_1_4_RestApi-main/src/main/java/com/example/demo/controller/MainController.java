package com.example.demo.controller;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class MainController {
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public MainController(UserService userService,
                          UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String allUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "admin";
    }

    @GetMapping()
    public String showAllUsers(Model model, @AuthenticationPrincipal User user) {
        List<User> users = userService.findAll();
        Set<Role> listRoles = userService.getAllRoles();
        model.addAttribute("users", users);
        model.addAttribute("userObj", new User());
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("userRep", userRepository.findByUsername(user.getUsername()));
        return "admin";
    }
}

