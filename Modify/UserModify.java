/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modify;

import Models.Users;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author
 */
public class UserModify extends Base {

    public static List<Users> getUserList() {
        List<Users> userList = new ArrayList<>();

        openConnection();

        try {
            String sql = "select * from user";
            statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Users users = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                        resultSet.getString("birthday"),
                        resultSet.getString("password"),
                        resultSet.getInt("role_id"),
                        resultSet.getInt("active"),
                        resultSet.getString("created_at"),
                        resultSet.getString("updated_at")
                );
                userList.add(users);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return userList;
    }

    public static void insert(Users users) {
        openConnection();

        try {
            String sql = "insert into user (fullname, gender, email, phone_number, address, password, birthday, role_id, active, created_at, updated_at) values(?,?,?,?,?,?,?,?,?,?,?)";
            statement = conn.prepareStatement(sql);
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);

            statement.setString(1, users.getFullname());
            statement.setString(2, users.getGender());
            statement.setString(3, users.getEmail());
            statement.setString(4, users.getPhone_number());
            statement.setString(5, users.getAddress());
            statement.setString(6, users.getPassword());
            statement.setString(7, users.getBirthday());
            statement.setInt(8, users.getRole_id());
            statement.setInt(9, users.getActive());
            statement.setString(10, strDate);
            statement.setString(11, strDate);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    public static void updateStaff(Users users) {
        openConnection();

        try {
            String sql = "update user set fullname =?, gender = ?, email = ?, phone_number = ?, address = ?, birthday = ?, active = ? ,updated_at = ? where id = ?";
            statement = conn.prepareStatement(sql);

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);

            statement.setString(1, users.getFullname());
            statement.setString(2, users.getGender());
            statement.setString(3, users.getEmail());
            statement.setString(4, users.getPhone_number());
            statement.setString(5, users.getAddress());
            statement.setString(6, users.getBirthday());
            statement.setInt(7, users.getActive());
            statement.setString(8, strDate);
            statement.setInt(9, users.getId());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    public static void delete(int id) {
        openConnection();
        try {
            String sql = "delete from user where id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    public static Users LoginUsers(String email, String password) {
        Users users = null;
        openConnection();

        try {
            String sql = "select * from user where email = ? and password = ? ";
            statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                users = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                        resultSet.getString("password"),
                        resultSet.getString("birthday"),
                        resultSet.getInt("role_id"),
                        resultSet.getInt("active"),
                        resultSet.getString("created_at"),
                        resultSet.getString("updated_at")
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return users;
    }

    public static List<Users> Findbyfullname(String fullname) {
        List<Users> usersList = new ArrayList<>();
        openConnection();

        try {
            String sql = "select * from user where fullname like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%" + fullname + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Users users = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                        resultSet.getString("password"),
                        resultSet.getString("birthday"),
                        resultSet.getInt("role_id"),
                        resultSet.getInt("active"),
                        resultSet.getString("created_at"),
                        resultSet.getString("updated_at")
                );
                usersList.add(users);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return usersList;

    }

    public static List<Users> getListByRole(int role) {
        List<Users> dataList = new ArrayList<>();

        openConnection();

        try {
            String sql = "select * from user where role_id = ?";
            statement = conn.prepareCall(sql);
            statement.setInt(1, role);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Users users = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                        resultSet.getString("birthday"),
                        resultSet.getString("password"),
                        resultSet.getInt("role_id"),
                        resultSet.getInt("active"),
                        resultSet.getString("created_at"),
                        resultSet.getString("updated_at")
                );
                dataList.add(users);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;
    }

    public static List<Users> getListNameByID(int id) {
        List<Users> dataList = new ArrayList<>();
        openConnection();

        try {
            String sql = "Select * from user where id = ?";
            statement = conn.prepareCall(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Users users = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("fullname")
                );
                dataList.add(users);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
        return dataList;
    }

}
