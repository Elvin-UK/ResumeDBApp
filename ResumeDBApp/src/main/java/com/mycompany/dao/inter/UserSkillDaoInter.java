/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.company.entity.UserSkill;
import java.util.List;

/**
 *
 * @author User
 */
public interface UserSkillDaoInter {
     public List<UserSkill> getAllSkillByUserId(int userId);
}
