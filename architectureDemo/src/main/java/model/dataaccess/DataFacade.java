/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataaccess;

import entity.User;
import java.util.List;

/**
 *
 * @author tha
 */
public class DataFacade implements IDataFacade{
    UserMapper um = new UserMapper();
    //KayakMapper km = new KayakMapper();
    //BookingMapper bm .....
    
    @Override
    public List<User> getAllUsers() {
        return um.getAllUsers();
    }

    @Override
    public User getUser(int id) {
        return um.getUser(id);
    }

    @Override
    public void createUser(User user) {
        um.createUser(user);
    }
    public static void main(String[] args) {
        DataFacade df = new DataFacade();
        for (User user : df.getAllUsers()) {
            System.out.println(user.getName());
        }
    }
    
}
