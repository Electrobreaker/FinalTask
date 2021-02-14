package com.FinalTask.entity;

import java.io.Serializable;

public enum Role {
    ADMIN, CASHIER, SENIOR_CASHIER, COMMODITY_EXPERT;

    public static Role getRole(Users user) {
        int roleId = user.getRoleId();
        return Role.values()[roleId];
    }

}
