package com.raccoon2891.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.raccoon2891.spring.service.SQLiteOps;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.logging.*;

@RestController
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class.getName()) ;
    private SQLiteOps op ;

    @Autowired
    public UserController(SQLiteOps op) {
        this.op = op ;
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUser(@RequestParam("pass") String pass) {
        if(op.searchTable(pass).isEmpty()) {
            return new ResponseEntity<>("No user was found with the provided credentials", HttpStatus.INTERNAL_SERVER_ERROR) ;
        }

        return new ResponseEntity<>(op.searchTable(pass), HttpStatus.ACCEPTED) ;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User u) {
        if (!op.validUser(u)) {
            return new ResponseEntity<>("Username is taken", HttpStatus.INTERNAL_SERVER_ERROR) ;
        }

        op.addUser(u) ;
        logger.log(Level.INFO, "User " + u.getName() + " has been added") ;
        return new ResponseEntity<>("User has been successfully added", HttpStatus.CREATED) ;
    }

    @GetMapping("/db")
    public ResponseEntity<String> readDatabase() {
        return new ResponseEntity<>(op.readTable(), HttpStatus.ACCEPTED) ;
    }
}
