package com.solvd.carina.demo.common;

import org.openqa.selenium.WebDriver;

public abstract class SideBarMenuPageBase extends BasePage {

    public SideBarMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase clickLogoutButton();

    public abstract boolean isLogoutButtonPresent();

    public abstract DrawingPageBase clickDrawingButton();
}
