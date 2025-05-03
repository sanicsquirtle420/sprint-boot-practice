package com.raccoon2891.spring.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raccoon2891.spring.api.User;
import java.sql.PreparedStatement ;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.HashMap ;
import java.util.Map;

@Service
public class SQLiteOps {
    @Autowired
    private PasswordEncoder passwordEncoder ;

    private static Connection con ;

    @Autowired
    public SQLiteOps() {
        try{
            con = DriverManager.getConnection("jdbc:sqlite:users.db") ;
            Statement stm = con.createStatement() ;
            stm.executeUpdate("drop table if exists user") ;
            stm.executeUpdate("create table user (name TEXT, username TEXT, password TEXT)") ;
        } catch (SQLException e) {
            System.err.println(e.getMessage()) ;
        }
    }

    public String readTable() {
        String msg = "" ;
        try(Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery("select * from user");
            msg += "*** Users ***\n" ;
            while (rs.next()) {
                msg += "name=" + rs.getString("name") + ", ";
                msg += "username=" + rs.getString("username") + ", ";
                msg += "password=" + rs.getString("password") + "\n" ;
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage()) ;
        }
        return msg + "*** End of Table ***\n";
    }

    public String searchTable(String target) {
        HashMap<String, String> m = new HashMap<>() ;
        try(Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery("select * from user") ;
            while(rs.next()) {
                m.put(rs.getString("name"), rs.getString("password")) ;
            }
            for(Map.Entry<String, String> a : m.entrySet()) {
                String pwd = a.getValue() ;
                if(passwordEncoder.matches(target, pwd)) {
                    return "Signed into " + a.getKey() ;
                }
            }
        } catch(Exception e) {
            System.err.println(e.getMessage()) ;
        }
        return "" ;
    }

    public boolean validUser(User u) {
        int count = 0 ;
        String q = "select * from user where username like ?" ;
        try(PreparedStatement ps = con.prepareStatement(q)) {
            ps.setString(1, "%" + u.getUsername() + "%") ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()) {
                count++ ; ;
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage()) ;
        }

        return count == 0 ;
    }

    public void addUser(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword())) ;
        try(Statement stm = con.createStatement()) {
            stm.executeUpdate(String.format("insert into user values ('%s', '%s', '%s')",
                    u.getName(), u.getUsername(), u.getPassword())) ;
        } catch(SQLException e) {
            System.err.println(e.getMessage()) ;
        }
    }
}
