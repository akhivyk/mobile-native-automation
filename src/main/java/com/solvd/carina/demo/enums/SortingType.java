package com.solvd.carina.demo.enums;

public enum SortingType {
    NAME_A_Z("Name (A to Z)"),
    NAME_Z_A("Name (Z to A)"),
    PRICE_LOW_HIGH("Price (low to high)"),
    PRICE_HIGH_LOW("Price (high to low)");

    private final String sortOption;

    SortingType(String username) {
        this.sortOption = username;
    }

    public String getSortOption() {
        return sortOption;
    }
}
