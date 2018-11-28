package com.merlinjobs.flexible.template.api.controllers;

import com.merlinjobs.flexible.template.data.UserDao;
import com.merlinjobs.flexible.template.data.interfaces.Dao;
import com.merlinjobs.flexible.template.api.interfaces.UserAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.merlinjobs.flexible.template.data.models.User;


import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/public/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
final class PublicUsersController {
    @NonNull
    UserAuthenticationService authentication;

    private static Dao userDao;

    @PostMapping("/register")
    String register(@RequestParam("username") final String username, @RequestParam("password") final String password) {
        userDao = new UserDao();
        return userDao.save(new User(UUID.randomUUID().toString(), username, password));
    }

    @PostMapping("/login")
    com.merlinjobs.flexible.template.api.models.User login (@RequestParam("username") final String username, @RequestParam("password") final String password) {
        return authentication.login(username, password)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }
}