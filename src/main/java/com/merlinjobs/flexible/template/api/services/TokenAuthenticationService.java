package com.merlinjobs.flexible.template.api.services;

import com.google.common.collect.ImmutableMap;

import com.merlinjobs.flexible.template.api.interfaces.UserAuthenticationService;
import com.merlinjobs.flexible.template.auth.interfaces.TokenService;
import com.merlinjobs.flexible.template.data.UserDao;
import com.merlinjobs.flexible.template.data.interfaces.Dao;
import com.merlinjobs.flexible.template.data.models.User;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class TokenAuthenticationService implements UserAuthenticationService {
    @NonNull
    TokenService tokens;
    @NonNull
    static Dao userDao;

    @Override
    public Optional<com.merlinjobs.flexible.template.api.models.User> login(final String username, final String password) {
        userDao = new UserDao();
        User user = userDao.get(username);
        com.merlinjobs.flexible.template.api.models.User apiUser = new com.merlinjobs.flexible.template.api.models.User();
        apiUser.setProperties(user);
        apiUser.setToken(tokens.expiring(ImmutableMap.of("username", username)));
        return Optional.ofNullable(apiUser);
    }

    @Override
    public Optional<User> findByToken(final String token) {

//        return Optional
//                .of(tokens.verify(token))
//                .map(map -> map.get("username"))
//                .flatMap(userDao::get());
        return Optional.empty();
    }

    @Override
    public void logout(final User user) {
        // Nothing to doy
    }
}
