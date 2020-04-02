/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.dao.inter;

import com.company.entity.Country;
import com.company.entity.User;
import com.mycompany.dao.inter.AbstractDao;
import com.mycompany.dao.inter.UserDaoInter;
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
public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        int nationality_id = rs.getInt("nationality_id");
        int birthplace_id = rs.getInt("birthplace_id");
        String nationalitystr = rs.getString("nationality");
        String birthplacestr = rs.getString("birthplace");
        Date birthdate = rs.getDate("birthdate");
        String profileDesc = rs.getString("profile_description");
        String address = rs.getString("address");
        Country nationality = new Country(nationality_id, null, nationalitystr);
        Country birthplace = new Country(birthplace_id, birthplacestr, null);
        return new User(id, name, surname, phone, email, birthdate, nationality, birthplace, profileDesc, address);
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {//mutleq try with resource etmeliyikki sebeke baglansin connect baglansin

            Statement stmt = c.createStatement();
            stmt.execute("select"
                    + "	u.*,"
                    + "	n.nationality,"
                    + "	c.name as birthplace"
                    + "	from user u"
                    + "	left join country n on u.nationality_id=n.id"
                    + "	left join country c on u.birthplace_id=c.id");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean upDateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name=?,surname=?,phone=?,email=?,profile_description=?,birthdate=?,address=?,birthplace_id=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            stmt.setDate(6, u.getBirthdate());
            stmt.setString(7, u.getAddress());
            stmt.setInt(8, u.getBirthPlace().getId());

            stmt.setInt(9, u.getId());

            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id= " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public User getById(int userId) {
        User result = null;
        try (Connection c = connect()) {//mutleq try with resource etmeliyikki sebeke baglansin connect baglansin

            Statement stmt = c.createStatement();
            stmt.execute("select"
                    + "	u.*,"
                    + "	n.nationality,"
                    + "	c.name as birthplace"
                    + "	from user u"
                    + "	left join country n on u.nationality_id=n.id"
                    + "	left join country c on u.birthplace_id=c.id where u.id=" + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getUser(rs);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user(name,surname,email,phone,profile_description,address) values(?,?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            stmt.setString(6, u.getAddress());

            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

//    @Override
//    public List<UserSkill> getAllSkillByUserId(int userId) {   yeni ijmplement olunan clasimiz var deye silirik
//        List<UserSkill> result = new ArrayList<>();
//        try (Connection c = connect()) {//mutleq try with resource etmeliyikki sebeke baglansin connect baglansin
//
//            PreparedStatement stmt = c.prepareStatement("SELECT"
//                    + "	u.*,"
//                    + "	us.skill_id,"
//                    + "	s.NAME AS skill_name,"
//                    + "	us.power "
//                    + "FROM"
//                    + "	user_skill us"
//                    + "	LEFT JOIN USER u ON us.user_id = u.id"
//                    + "	LEFT JOIN skill s ON us.skill_id = s.id "
//                    + "WHERE"
//                    + "	us.user_id =?");
//            stmt.setInt(1, userId);
//
//            stmt.execute();
//            ResultSet rs = stmt.getResultSet();
//            while (rs.next()) {
//                UserSkill u = getUserSkill(rs);
//                result.add(u);
//
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//
//    }
//
//    private UserSkill getUserSkill(ResultSet rs) throws Exception {
//        Integer userid = rs.getInt("id");
//        int skillid = rs.getInt("skill_id");
//        int power = rs.getInt("power");
//        String skillname = rs.getString("skill_name");
//        return new UserSkill(null, new User(userid), new Skill(skillid, skillname), power);
//    }
}
