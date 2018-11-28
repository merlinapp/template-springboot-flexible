package com.merlinjobs.flexible.template.api.services;

import com.google.common.collect.ImmutableMap;

import com.merlinjobs.flexible.template.api.interfaces.UserAuthenticationService;
import com.merlinjobs.flexible.template.auth.interfaces.TokenService;
import com.merlinjobs.flexible.template.data.UserDao;
import com.merlinjobs.flexible.template.data.interfaces.Dao;
import com.merlinjobs.flexible.template.api.models.UserApi;
import com.merlinjobs.flexible.template.data.models.User;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class TokenAuthenticationService implements UserAuthenticationService {
    @NonNull
    TokenService tokens;
    @NonNull
    static Dao userDao = new UserDao();

    @Override
    public Optional<UserApi> login(final String username, final String password) {

        return Optional.empty();
    }

    @Override
    public Optional<UserApi> findByToken(final String token) {
        return Optional.empty();
    }

    @Override
    public void logout(final UserApi user) {
        // Nothing to doy
    }

    @Override
    public Optional<UserApi> register(String username, String password) {
        requireNonNull(username);
        requireNonNull(password);
        String idUser = UUID.randomUUID().toString();
        UserApi userApi = new UserApi();
        String idWebSecure = userDao.save(new User(idUser, username, password));
        userApi.setToken(tokens.expiring(ImmutableMap.of("username", idWebSecure)));
        return Optional.ofNullable(userApi);
    }

    @Override
    public Optional<UserApi> current(String idUser) {
        UserApi userApi = new UserApi();
        userApi.setProperties(userDao.get(idUser));
        return Optional.ofNullable(userApi);

    }
}
