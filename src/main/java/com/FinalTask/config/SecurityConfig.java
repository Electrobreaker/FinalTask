package com.FinalTask.config;

import com.FinalTask.entity.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {

    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        List<String> urlPatternsAdmin = new ArrayList<>();

        urlPatternsAdmin.add("/profile");
        urlPatternsAdmin.add("/cashier");
        urlPatternsAdmin.add("/Senior cashier");
        urlPatternsAdmin.add("/storage");
        urlPatternsAdmin.add("/adminPage");
        mapConfig.put(Role.ADMIN.toString(), urlPatternsAdmin);

        // Конфигурация для роли "CASHIER".
        List<String> urlPatternsCashier = new ArrayList<>();

        urlPatternsCashier.add("/profile");
        urlPatternsCashier.add("/cashier");

        mapConfig.put(Role.CASHIER.name(), urlPatternsCashier);

        // Конфигурация для роли "SENIOR_CASHIER".
        List<String> urlPatternsSeniorCashier = new ArrayList<>();

        urlPatternsSeniorCashier.add("/profile");
        urlPatternsSeniorCashier.add("/cashier");
        urlPatternsSeniorCashier.add("/Senior cashier");

        mapConfig.put(Role.SENIOR_CASHIER.name(), urlPatternsSeniorCashier);

        List<String> urlPatternsCommodityExpert = new ArrayList<>();

        urlPatternsCommodityExpert.add("/profile");
        urlPatternsCommodityExpert.add("/storage");

        mapConfig.put(Role.COMMODITY_EXPERT.name(), urlPatternsCommodityExpert);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }

}