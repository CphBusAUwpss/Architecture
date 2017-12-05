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
public interface IDataFacade {
    List<User> getAllUsers();
    User getUser(int id);
    void createUser(User user);
    
}
