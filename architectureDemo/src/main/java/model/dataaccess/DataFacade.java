/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataaccess;

import java.util.ArrayList;
import logic.entity.User;
import java.util.List;
import logic.entity.Product;

/**
 *
 * @author tha
 */
public class DataFacade implements IDataFacade{
    UserMapper um = new UserMapper();
    ProductMapper pm = new ProductMapper();
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
    public void getSome(){}
    
    public static void main(String[] args) {
        DataFacade df = new DataFacade();
        for (User user : df.getAllUsers()) {
            System.out.println(user.getName());
        }
    }

    @Override
    public List<Product> getAllProducts() {
       return pm.getAllProducts();
    }
    
}
