package com.raccoon2891.spring;

public class UserNotFoundException extends Exception {
    /**
     *  A custom exception that is thrown when a user is not found in the database
     *  @Author: Diego R
     */
    public UserNotFoundException() {
        super("No user was found with that password") ;
    }
}
