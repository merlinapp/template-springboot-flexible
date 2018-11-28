package com.merlinjobs.flexible.template.api.controllers;

import com.merlinjobs.flexible.template.data.UserDao;
import com.merlinjobs.flexible.template.data.models.User;
import com.merlinjobs.flexible.template.api.interfaces.UserAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
final class SecuredUsersController {
    @NonNull
    UserAuthenticationService authentication;

    static UserDao userDao = new UserDao();

    @GetMapping("/current")
    public User getCurrent(@AuthenticationPrincipal final User user) {
        userDao = new UserDao();
        User user1 = userDao.get(user.getId());
        return user1;
    }

    @GetMapping("/logout")
    boolean logout(@AuthenticationPrincipal final User user) {
        authentication.logout(user);
        return true;
    }
}