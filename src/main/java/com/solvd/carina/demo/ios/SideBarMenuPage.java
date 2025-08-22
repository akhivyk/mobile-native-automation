package com.solvd.carina.demo.ios;

import com.solvd.carina.demo.common.DrawingPageBase;
import com.solvd.carina.demo.common.LoginPageBase;
import com.solvd.carina.demo.common.SideBarMenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SideBarMenuPageBase.class)
public class SideBarMenuPage extends SideBarMenuPageBase {

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutButton;

    @ExtendedFindBy(accessibilityId = "test-DRAWING")
    private ExtendedWebElement drawingButton;

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

    public DrawingPageBase clickDrawingButton() {
        drawingButton.click();
        return initPage(getDriver(), DrawingPageBase.class);
    }
}
