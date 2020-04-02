/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.company.entity.User;
import com.mycompany.dao.inter.UserDaoInter;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) throws Exception {
    UserDaoInter skildao = Contex.instanceUserDao();

//       SkillDaoInter s=new SkillDaoImple();



        System.out.println(skildao.getAll());

    }
}
