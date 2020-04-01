/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.dao.inter;

import com.company.entity.EmploymentHistory;
import com.company.entity.Skill;
import com.company.entity.User;
import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.SkillDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class SkillDaoImple extends AbstractDao implements SkillDaoInter {

    private Skill getSkill(ResultSet rs) throws Exception {
        String name = rs.getString("name");

        Skill emp = new Skill(null, name);
        return emp;
    }

    @Override
    public List<Skill> getAll( ) {
        List<Skill> result = new ArrayList<>();
        try (Connection c = connect()) {//mutleq try with resource etmeliyikki sebeke baglansin connect baglansin

            PreparedStatement stmt = c.prepareStatement("select * from skill");
            

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Skill skil = getSkill(rs);
                result.add(skil);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
//    private Skill getSkill(ResultSet rs) throws Exception {
////        Integer id=rs.getInt("id");
//        String name = rs.getString("name");
//
//        Skill skil = new Skill(null, name);
//        return skil;
//    }
//    @Override
//    public List<Skill> getAll() {
//        
//        
//        
//        List<Skill> result = new ArrayList<>();
//        try (Connection c = connect()) {//mutleq try with resource etmeliyikki sebeke baglansin connect baglansin
//
//            Statement stmt = c.createStatement();
//            
//            stmt.execute("select * from skill");
//            ResultSet rs = stmt.getResultSet();
//            while (rs.next()) {
////                Skill skil = getSkill(rs);
////                result.add(skil);
//                
//                String name = rs.getString("name");
//                Skill s = new Skill(null, name);
//                result.add(s);
//            }
//            
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }

}
