/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.dao.inter.CountryDaoInter;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) throws Exception {
        CountryDaoInter skildao = Contex.instanceCountryDao();

//       SkillDaoInter s=new SkillDaoImple();
        System.out.println(skildao.getAll());

    }
}
