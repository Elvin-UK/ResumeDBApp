/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class User {

    private int id;
    private String name;
    private String surname;
    private String phone;
    private String profileDesc;
    private String email;
    private Date birthdate;
    private Country nationality;
    private Country birthPlace;
    private List<UserSkill> skills;
    private String address;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(int id, String name, String surname, String phone, String email, Date birthdate, Country nationality, Country birthPlace,String profileDesc,String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.birthdate = birthdate;
        this.nationality = nationality;
        this.birthPlace = birthPlace;
        this.profileDesc=profileDesc;
        this.address=address;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Country getNationality() {
        return nationality;
    }

    public Country getBirthPlace() {
        return birthPlace;
    }

    public List<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkill> skills) {
        this.skills = skills;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public void setBirthPlace(Country birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", profileDesc=" + profileDesc + ", email=" + email + ", birthdate=" + birthdate + ", nationality=" + nationality + ", birthPlace=" + birthPlace + ", skills=" + skills + ", address=" + address + '}';
    }

    
    
    

   

}
