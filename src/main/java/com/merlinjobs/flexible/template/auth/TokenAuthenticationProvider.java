package com.merlinjobs.flexible.template.auth;

import com.merlinjobs.flexible.template.auth.interfaces.TokenService;
import com.merlinjobs.flexible.template.data.models.User;
import com.merlinjobs.flexible.template.api.interfaces.UserAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Map;

import static lombok.AccessLevel.PACKAGE;

@Component
@AllArgsConstructor(access = PACKAGE)
public final class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    @NonNull
    UserAuthenticationService auth;

    @NonNull
    TokenService tokenService;


    @Override
    protected void additionalAuthenticationChecks(final UserDetails d, final UsernamePasswordAuthenticationToken auth) {
        // Nothing to do
    }

    @Override
    protected UserDetails retrieveUser(final String username, final UsernamePasswordAuthenticationToken authentication) {
        final Object token = authentication.getCredentials();
        Map<String, String> tokenDecoded = tokenService.verify(token.toString());
        User user = new User(tokenDecoded.get("username"), null, null);
        return user;
//        String webSafeUrl = tokenDecoded.get("username");
//        Key<User> userKey = Key.create(webSafeUrl);
//        UserDetails userDetails = ObjectifyService.ofy().load().key(userKey).now();
//
//        //Optional<UserDetails> user = userDao.get(webSafeUrl);
//        System.out.println("VARIABLE USER: " + userDetails.getUsername());
//        //return user.get();
//
//        return Optional
//                .ofNullable(token)
//                .map(String::valueOf)
//                .flatMap(auth::findByToken)
//                .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token=" + token));

    }
}