package com.raccoon2891.spring.service;

import com.raccoon2891.spring.UserNotFoundException;
import com.raccoon2891.spring.api.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList ;
import java.util.Scanner ;
import java.util.Base64;

@Service
public class UserService {
    private ArrayList<User> userList ;

    public UserService() {
        userList = new ArrayList<>() ;
        initUsers() ;
    }

    public User getUser(String pass) throws UserNotFoundException {
        byte[] tmp = Base64.getEncoder().encode(pass.getBytes()) ;
        pass = new String(tmp) ;

        for(User u : userList) {
            if(pass.equals(u.getPassword())) {
                return u ;
            }
        }

        throw new UserNotFoundException();
    }

    public ArrayList<User> getList() {
        return userList ;
    }

    private void initUsers() {
        Scanner scan = new Scanner(System.in) ;
        System.out.print("How many users would you like to add? ") ;
        int count = scan.nextInt() ;
        scan.nextLine() ; // clears buffer

        for(int i = 0 ; i < count ; i++) {
            System.out.print("Name: ") ;
            String n = scan.nextLine() ;
            System.out.print("Username: ") ;
            String u = scan.nextLine() ;
            System.out.print("Password: ") ;
            String p = scan.nextLine() ;
            userList.add(new User(n, u, p)) ;
        }
    }
}
