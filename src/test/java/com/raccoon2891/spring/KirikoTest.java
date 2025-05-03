package com.raccoon2891.spring;

import static org.junit.jupiter.api.Assertions.*;
import com.raccoon2891.spring.api.User;
import org.junit.jupiter.api.Test;

public class KirikoTest {
    /* User class testing */
    @Test
    void noArgConst() {
        User test = new User() ;
        assertNotNull(test) ;
    }

    @Test
    void paramConst() {
        User test = new User("a", "b", "c") ;
        assertAll("Testing parameterized constructor",
                ()-> assertEquals("a", test.getName()) ,
                ()-> assertEquals("b", test.getUsername()) ,
                ()-> assertEquals("c", test.getPassword())
        ) ;
    }

    @Test
    void nameTest() {
        User test = new User() ;
        test.setName("a") ;
        assertEquals("a", test.getName()) ;
    }

    @Test
    void usernameTest() {
        User test = new User() ;
        test.setUsername("a"); ;
        assertEquals("a", test.getUsername()) ;
    }

    @Test
    void passwordTest() {
        User test = new User() ;
        test.setPassword("a"); ;
        assertEquals("a", test.getPassword()) ;
    }
}
