package com.solvd.carina.demo.ios;

import com.solvd.carina.demo.common.LoginPageBase;
import com.solvd.carina.demo.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutButton;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public LoginPageBase clickLogoutButton() {
        logoutButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    public boolean isLogoutButtonPresent() {
        return logoutButton.isElementPresent();
    }
}
