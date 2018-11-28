package com.merlinjobs.flexible.template.api.models;


public class UserApi extends com.merlinjobs.flexible.template.data.models.User {
    private static final long serialVersionUID = 2396654715019746670L;

    private String token;

    public UserApi() {
    }

    public UserApi(String id, String username, String password, String token) {
        super(id, username, password);
        this.token = token;
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