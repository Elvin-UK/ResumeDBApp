/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.company.bean.User;
import java.util.List;

/**
 *
 * @author User
 */
public interface UserDaoInter {

    public List<User> getAll();
    public User getById(int u);

    public boolean upDateUser(User u);

    public boolean removeUser(int id);

}
