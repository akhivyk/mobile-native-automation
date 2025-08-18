package com.solvd.carina.demo.android;

import com.solvd.carina.demo.android.components.TopMainMenu;
import com.solvd.carina.demo.common.LoginPageBase;
import com.solvd.carina.demo.common.SideBarMenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SideBarMenuPageBase.class)
public class SideBarMenuPage extends SideBarMenuPageBase {

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/..")
    private TopMainMenu header;

    public SideBarMenuPage(WebDriver driver) {
        super(driver);
    }

    public LoginPageBase clickLogoutButton() {
        logoutButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    public boolean isLogoutButtonPresent() {
        return logoutButton.isElementPresent();
    }

    public TopMainMenu getTopMainMenu() {
        return header;
    }
}
