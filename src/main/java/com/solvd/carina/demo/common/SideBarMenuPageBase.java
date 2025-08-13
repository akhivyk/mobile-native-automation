package com.solvd.carina.demo.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SideBarMenuPageBase extends AbstractPage {

    public SideBarMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase clickLogoutButton();

    public abstract boolean isLogoutButtonPresent();
}
