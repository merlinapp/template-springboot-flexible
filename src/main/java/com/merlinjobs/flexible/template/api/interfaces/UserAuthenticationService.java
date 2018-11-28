package com.merlinjobs.flexible.template.api.interfaces;

import com.merlinjobs.flexible.template.api.models.UserApi;

import java.util.Optional;

public interface UserAuthenticationService {

    /**
     * Logs in with the given {@code username} and {@code password}.
     *
     * @param username
     * @param password
     * @return an {@link Optional} of a user when login succeeds
     */
    Optional<UserApi> login(String username, String password);

    /**
     * Finds a user by its dao-key.
     *
     * @param token user dao key
     * @return
     */
    Optional<UserApi> findByToken(String token);

    /**
     * Logs out the given input {@code user}.
     *
     * @param user the user to logout
     */
    void logout(UserApi user);


    Optional<UserApi> register(String username, String password);

    Optional<UserApi> current(String idUser);
}

