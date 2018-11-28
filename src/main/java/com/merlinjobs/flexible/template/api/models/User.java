package com.merlinjobs.flexible.template.api.models;


public class User extends com.merlinjobs.flexible.template.data.models.User {
    private static final long serialVersionUID = 2396654715019746670L;

    private String token;

    public User() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void setProperties(com.merlinjobs.flexible.template.data.models.User user){
        super.setProperties(user);
    }


}