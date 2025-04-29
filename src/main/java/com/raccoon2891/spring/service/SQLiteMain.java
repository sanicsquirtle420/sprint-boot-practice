package com.raccoon2891.spring.service;

import com.raccoon2891.spring.UserNotFoundException;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLiteMain {
    public static void main(String[] args) throws UserNotFoundException {
        Connection con = SQLiteConnection.connect() ;
//      SQLiteOps op = new SQLiteOps() ;
        if(con != null) {
//            if(op.searchTable("asdf").isEmpty()) {
//                throw new UserNotFoundException() ;
//            }
//            System.out.println(op.searchTable("asdf")) ;
            try {
                con.close() ;
                System.out.println("Awesome!") ;
            } catch (SQLException e) {
                System.err.println(e.getMessage()) ;
            }
        }
    }
}
