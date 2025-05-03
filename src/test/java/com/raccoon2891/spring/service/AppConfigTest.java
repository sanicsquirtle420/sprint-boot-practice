package com.raccoon2891.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppConfigTest {
    @Autowired
    private PasswordEncoder pwdEncoder ;

    @Test
    void pwdEncoderRunning() {
        assertNotNull(pwdEncoder) ;
    }

    @Test
    void encryptTest1() {
        String sample = "1234" ;
        String test = pwdEncoder.encode(sample) ;
        assertTrue(pwdEncoder.matches(sample, test)) ;
    }

    @Test
    void encryptTest2() {
        String sample = "1234" ;
        String test = pwdEncoder.encode("2345") ;
        assertFalse(pwdEncoder.matches(sample, test)) ;
    }
}