/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.company.bean.User;
import com.company.main.dao.inter.UserDaoImpl;
import com.mycompany.dao.inter.UserDaoInter;
import java.util.List;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter userdao = Contex.instanceUserDao();
        User u = new User(0, "Sarkhan", "Rasullu", "+994556895", "sarkhan@gmail.com");

        userdao.addUser(u);

    }
}
