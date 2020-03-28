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
        UserDaoInter userdao = new UserDaoImpl();
//        List<User> list = userdao.getAll();
//        userdao.removeUser(1);
//        List<User> list2 = userdao.getAll();
//        System.out.println("list="+list);
//        System.out.println("list2="+list2);

User u=userdao.getById(2);

u.setName("Eldar");
userdao.upDateUser(u);
    }
}
