package com.solvd.carina.demo.common;

import org.openqa.selenium.WebDriver;

public abstract class CompletedOrderPageBase extends BasePage {

    public CompletedOrderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOrderComplete();
}
