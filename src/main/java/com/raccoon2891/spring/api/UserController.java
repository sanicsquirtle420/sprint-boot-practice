package com.raccoon2891.spring.api;

import com.raccoon2891.spring.UserNotFoundException;
import com.raccoon2891.spring.service.SQLiteOps;
import com.raccoon2891.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService ;
    private SQLiteOps op ;

    @Autowired
    public UserController(UserService userService, SQLiteOps op) {
        this.userService = userService ;
        this.op = op ;
    }

    @GetMapping("/user")
    public String getUser(@RequestParam("pass") String pass) throws UserNotFoundException {
        if(op.searchTable(pass).isEmpty()) {
            throw new UserNotFoundException() ;
        }

        return op.searchTable(pass) ;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> noUser(UserNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
    }

    public UserService getUserService() {
        return userService ;
    }
}
