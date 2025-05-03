package com.raccoon2891.spring.api;

public class User {
    private String name, username, password ;

    public User() {
        name = "" ;
        username = "" ;
        password = "" ;
    }

    public User(String name, String username, String password) {
        this.name = name ;
        this.username = username ;
        this.password = password ;
    }

    public void setName(String name) { this.name = name ; }

    public void setUsername(String username) { this.username = username ; }

    public void setPassword(String password) { this.password = password ; }

    public String getName() { return name ; }

    public String getUsername() { return username ; }

    public String getPassword() { return password ; }

    @Override
    public String toString() {
        return String.format("Name: %s, User: %s, Password: %s", name, username, password) ;
    }
}
