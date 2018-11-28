package com.merlinjobs.flexible.template.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Objects.requireNonNull;

@Entity
public class User implements UserDetails {
    private static final long serialVersionUID = 2396654715019746670L;

    @Id
    String id;
    String username;
    String password;

    public User() {
    }

    @JsonCreator
    public User(@JsonProperty("id") String id,
         @JsonProperty("username")  String username,
         @JsonProperty("password")  String password) {
        super();
        this.id = requireNonNull(id);
        this.username = username;
        this.password = password;
    }


    @JsonIgnore
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return id;
    }

    public void setProperties(User user){
        password = user.getPassword();
        username = user.getUsername();
        id = user.getId();
    }

}