package com.FinalTask.dao;

import com.FinalTask.entity.Goods;
import com.FinalTask.entity.Role;

public interface RoleDao {

    int createRole(Role role);

    int deleteRole(int id);

}
