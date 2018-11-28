package com.merlinjobs.flexible.template.api.controllers;

import com.merlinjobs.flexible.template.api.interfaces.UserAuthenticationService;
import com.merlinjobs.flexible.template.api.models.UserApi;
import com.merlinjobs.flexible.template.data.models.User;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
final class SecuredUsersController {
    @NonNull
    UserAuthenticationService authentication;

    @GetMapping("/current")
    public Optional<UserApi> getCurrent(@AuthenticationPrincipal final User user) {
        return authentication.current(user.getId());
    }

}