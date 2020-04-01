/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.company.main.dao.inter.CountryDaoImple;
import com.company.main.dao.inter.EmploymentHistoryDaoImple;
import com.company.main.dao.inter.SkillDaoImple;
import com.company.main.dao.inter.UserDaoImpl;
import com.company.main.dao.inter.UserSkillDaoImpl;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.dao.inter.UserSkillDaoInter;

/**
 *
 * @author User
 */
public class Contex {

    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }

    public static UserSkillDaoInter instanceSkillUserDao() {
        return new UserSkillDaoImpl();
    }

    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao() {
        return new EmploymentHistoryDaoImple();
    }

    public static SkillDaoInter instanceSkillDao() {
        return new SkillDaoImple();
    }
     public static CountryDaoInter instanceCountryDao() {
        return new CountryDaoImple();
    }
}
