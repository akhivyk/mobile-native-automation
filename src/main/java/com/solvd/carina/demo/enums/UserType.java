package com.solvd.carina.demo.enums;

public enum UserType {
    STANDARD_USER("standard_user"),
    LOCKED_OUT_USER("locked_out_user"),
    PROBLEM_USER("problem_user");

    private final String username;

    UserType(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
