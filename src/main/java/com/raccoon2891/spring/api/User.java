package com.raccoon2891.spring.api;

import java.util.Base64;

public class User {
    private String name, username, password ;

    public User(String name, String username, String password) {
        this.name = name ;
        this.username = username ;
        this.password = password ;
    }

    public String getName() { return name ; }

    public String getUsername() { return username ; }

    public String getPassword() {
        byte[] tmp = Base64.getEncoder().encode(password.getBytes()) ;
        return new String(tmp) ;
    }

    /* setters and getters are useless! */

    @Override
    public String toString() {
        return String.format("Name: %s, User: %s\nPassword: %s", name, username, getPassword()) ;
    }
}
