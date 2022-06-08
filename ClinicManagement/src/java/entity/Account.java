/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-11      1.0                 namnv           First Implement 
 */
package entity;

import java.sql.Date;

/**
 * The class contains attributes and getter,setter for information of [User]
 * object <br>
 * The getter will throw an attribute of [User] object<br>
 * The setter will set an attribute of [User] object<br>
 *
 * @author nguye
 */
public class Account {

    private int ID;
    private int service_id;
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Date dob;
    private boolean gender;
    private String phone;
    private String street;
    private String city;
    private String country;

    public Account() {
    }

    public Account(int ID, int service_id, String username, String email, String password, String firstname, String lastname, Date dob, boolean gender, String phone, String street, String city, String country) {
        this.ID = ID;
        this.service_id = service_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Account(String username, String email, String password, String firstname, String lastname, Date dob, boolean gender, String phone, String street, String city, String country) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.country = country;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}