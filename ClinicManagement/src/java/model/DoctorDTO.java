/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class DoctorDTO {
      private int userId;
    private int roleId;
    private int serviceId;
    private int is_active;
    private String username;
    private String servicename;
    private String email;
    private String password;
    private String fullName;
    private Date birthDate;
    private boolean gender;
    private String phone;
    private String address;
    private String avatarImage;

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public DoctorDTO() {
    }

    public DoctorDTO(int userId, int roleId, int serviceId, int is_active, String username, String servicename, String email, String password, String fullName, Date birthDate, boolean gender, String phone, String address, String avatarImage, String serviceName) {
        this.userId = userId;
        this.roleId = roleId;
        this.serviceId = serviceId;
        this.is_active = is_active;
        this.username = username;
        this.servicename = servicename;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.avatarImage = avatarImage;
    }

    
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }


    @Override
    public String toString() {
        return "DoctorDTO{" + "userId=" + userId + ", roleId=" + roleId + ", serviceId=" + serviceId + ", username=" + username + ", servicename=" + servicename + ", email=" + email + ", password=" + password + ", fullName=" + fullName + ", birthDate=" + birthDate + ", gender=" + gender + ", phone=" + phone + ", address=" + address + ", avatarImage=" + avatarImage + ", serviceName=" + + '}';
    }
    
    
}
