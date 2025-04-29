package com.raccoon2891.spring.service;

import java.sql.* ;

public class SQLiteConnection {
    public static Connection connect() {
        Connection con = null ;
        try {
                con = DriverManager.getConnection("jdbc:sqlite:users.db") ;
                System.out.println("Successful connection!") ;
        } catch(SQLException e) {
            System.err.println(e.getMessage()) ;
        }

        return con ;
    }
}
