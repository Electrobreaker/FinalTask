package com.FinalTask.dao.impl;

import com.FinalTask.dao.UsersDao;
import com.FinalTask.entity.Role;
import com.FinalTask.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UsersDaoImpl implements UsersDao {
    private static Map<String, Users> mapUsers;

    static {
        initUsers();
    }

    private static void initUsers() {
        mapUsers = new HashMap<>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserPassword(resultSet.getString("user_password"));
                user.setUserEmail(resultSet.getString("user_email"));
                user.setUserPhoneNumber(resultSet.getString("user_phone_number"));
                int roleID = resultSet.getInt("role_id");
                switch (roleID) {
                    case 1:
                        user.setRole("Admin");
                }
                mapUsers.put(user.getUserName(), user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static Users findUser(String userName, String password) {
        Users user = mapUsers.get(userName);
        if (user != null && user.getUserPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public int createUser(Users user) {
        initUsers();
        return 0;
    }

    @Override
    public int editUser(Users user) {
        initUsers();
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        initUsers();
        return 0;
    }
}
