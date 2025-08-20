package com.solvd.carina.demo.android.components;

import com.solvd.carina.demo.common.BasePage;
import com.solvd.carina.demo.common.CartPageBase;
import com.solvd.carina.demo.common.SideBarMenuPageBase;
import com.solvd.carina.demo.common.components.TopMainMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;

public class AndroidTopMainMenu extends BasePage implements TopMainMenuBase {

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cartButton;

    public AndroidTopMainMenu(WebDriver driver) {
        super(driver);
    }

    public SideBarMenuPageBase openSideBarMenu() {
        menuButton.click();
        return initPage(getDriver(), SideBarMenuPageBase.class);
    }

    public CartPageBase clickCartButton() {
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    public String getCountOfItemInCart() {
        return cartButton.getElement().findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).getText();
    }
}
