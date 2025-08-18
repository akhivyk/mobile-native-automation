package com.solvd.carina.demo.common;

import org.openqa.selenium.WebDriver;

public abstract class OverviewPageBase extends BasePage {

    public OverviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CompletedOrderPageBase clickFinishButton();

    public abstract String getItemTotalPrice();
}
