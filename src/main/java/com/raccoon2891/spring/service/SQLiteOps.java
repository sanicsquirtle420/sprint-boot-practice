package com.raccoon2891.spring.service;

import java.sql.* ;
import java.util.ArrayList;
import java.util.Base64;
import com.raccoon2891.spring.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SQLiteOps {
    private Connection con ;
    private UserService us ;

    @Autowired
    public SQLiteOps(UserService us) {
        con = SQLiteConnection.connect() ;
        this.us = us ;
        if(con != null) {
            createTable(us.getList()) ;
        }
    }
    public void createTable(ArrayList<User> list) {
        try(Statement stm = con.createStatement()) {
            stm.executeUpdate("drop table if exists user") ;
            stm.executeUpdate("create table user (name TEXT, username TEXT, password TEXT)") ;
            for(User u : list) {
                stm.executeUpdate(String.format("insert into user values ('%s', '%s', '%s')",
                        u.getName(), u.getUsername(), u.getPassword())) ;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage()) ;
        }
    }

    public void readTable() {
        try(Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery("select * from user");
            System.out.println("*** Users ***") ;
            while (rs.next()) {
                System.out.println("name=" + rs.getString("name"));
                System.out.println("username=" + rs.getString("username"));
                System.out.println("password=" + rs.getString("password") + "\n");
            }
            System.out.println("*** END OF TABLE ***") ;
        } catch(SQLException e) {
            System.err.println(e.getMessage()) ;
        }
    }

    public String searchTable(String target) {
        String msg = "" ;
        try(Statement stm = con.createStatement()) {
            byte[] hash = Base64.getEncoder().encode(target.getBytes()) ;
            target = new String(hash) ;
            String tmp = "select * from user where password like ?" ;
            PreparedStatement ps = con.prepareStatement(tmp) ;
            ps.setString(1, target) ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()) {
                msg += String.format("Name: %s, Username: %s, Password: %s\n",
                            rs.getString("name"), rs.getString("username"),
                            rs.getString("password")) ;
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage()) ;
        }
        return msg ;
    }
}
