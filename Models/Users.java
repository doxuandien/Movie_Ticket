/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author xuandien
 */
public class Users {
    int id;
    String fullname, gender, email, phone_number, address, birthday, password;
    int role_id, active;
    String createdAt, updatedAt;

    public Users() {
    }

    public Users(int id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    
    public Users(int id, String fullname, String gender, String email, String phone_number, String address, String birthday, String password, int role_id, int active, String createdAt, String updatedAt) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.birthday = birthday;
        this.password = password;
        this.role_id = role_id;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Users(String fullname, String gender, String email, String phone_number, String address, String birthday, String password, int role_id, int active, String createdAt, String updatedAt) {
        this.fullname = fullname;
        this.gender = gender;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.birthday = birthday;
        this.password = password;
        this.role_id = role_id;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    

    

    

    

   
    
    
    
}

