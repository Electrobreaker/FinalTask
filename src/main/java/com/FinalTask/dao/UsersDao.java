package com.FinalTask.dao;

import com.FinalTask.entity.Users;

public interface UsersDao {

    int createUser(Users user);

    int editUser(Users user);

    int deleteUser(int id);

}
