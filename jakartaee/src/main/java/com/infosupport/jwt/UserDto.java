package com.infosupport.jwt;

import java.util.Set;

public class UserDto {
    private String username;
    private String password;
    private Set<String> roles;
    private String token;

    public UserDto() {
    }

    public UserDto(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public static UserDto fromEntity(User user) {
        return new UserDto(user.getUsername(), user.getPassword(), user.getRoles());
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public String getToken() {
        return token;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
