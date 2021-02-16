package com.FinalTask.dao;

import com.FinalTask.entity.Users;

public interface UsersDao {

    int createUser(Users user);

    Users findUserByNameAndPass(String userName, String userPassword);

}
