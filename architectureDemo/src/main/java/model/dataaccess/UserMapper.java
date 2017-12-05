package model.dataaccess;

import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 10, 2016 
 */
public class UserMapper {
    public User getUser(int id){
        User user = null;
        try {
            String sql = "SELECT id, name, password FROM user WHERE id = ?";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                String username = rs.getString("name");
                String password = rs.getString("password");
                user = new User(id, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    public void createUser(User user){
        try {
            String sql = "Insert into user (name, password) values (?,?)";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    public List<User> getAllUsers(){
        List<User> users = new ArrayList();
        try {
            String sql = "SELECT id, name, password FROM user";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String username = rs.getString("name");
                String password = rs.getString("password");
                User user = new User(username, password);
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }
//    public User getUserByName(String name){}
    public boolean authenticate(String name, String password){
        try {
            String sql = "SELECT id, name, password FROM user WHERE name = ?";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                if(rs.getString("password").equals(password)){
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }
    public User getUserByName(String username){
        User user = null;
        try {
            String sql = "SELECT id, name FROM user WHERE name = ?";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                user = new User(id, username);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    public static void main(String[] args) {
        UserMapper um = new UserMapper();
        um.createUser(new User("Peder", "peder123"));
    }
}
