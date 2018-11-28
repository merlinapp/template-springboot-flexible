package com.merlinjobs.flexible.template.auth;

import com.merlinjobs.flexible.template.data.interfaces.UserCrudService;
import com.merlinjobs.flexible.template.data.models.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
final public class InMemoryUsers implements UserCrudService {

    static Map<String, User> users = new HashMap<>();

    @Override
    public User save( User user) {
        System.out.println("PASO 1.1");
        return users.put(user.getId(), user);
    }

    @Override
    public Optional<User> find(final String id) {
        return ofNullable(users.get(id));
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        return users
                .values()
                .stream()
                .filter(u -> Objects.equals(username, u.getUsername()))
                .findFirst();
    }
}
