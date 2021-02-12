package com.FinalTask.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {
    public static final String ROLE_ADMIN = "Admin";
    public static final String ROLE_CASHIER = "Cashier";
    public static final String ROLE_SENIOR_CASHIER = "Senior-Cashier";
    public static final String ROLE_COMMODITY_EXPERT = "Commodity_Expert";

    // String: Role
    // List<String>: urlPatterns.
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
        mapConfig.put(ROLE_ADMIN, urlPatternsAdmin);

        // Конфигурация для роли "CASHIER".
        List<String> urlPatternsCashier = new ArrayList<>();

        urlPatternsCashier.add("/profile");
        urlPatternsCashier.add("/cashier");

        mapConfig.put(ROLE_CASHIER, urlPatternsCashier);

        // Конфигурация для роли "SENIOR_CASHIER".
        List<String> urlPatternsSeniorCashier = new ArrayList<>();

        urlPatternsSeniorCashier.add("/profile");
        urlPatternsSeniorCashier.add("/cashier");
        urlPatternsSeniorCashier.add("/Senior cashier");

        mapConfig.put(ROLE_SENIOR_CASHIER, urlPatternsSeniorCashier);

        List<String> urlPatternsCommodityExpert = new ArrayList<>();

        urlPatternsCommodityExpert.add("/profile");
        urlPatternsCommodityExpert.add("/storage");

        mapConfig.put(ROLE_COMMODITY_EXPERT, urlPatternsCommodityExpert);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }

}