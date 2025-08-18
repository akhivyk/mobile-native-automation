package com.solvd.carina.demo.android.components;

import com.solvd.carina.demo.common.CartPageBase;
import com.solvd.carina.demo.common.SideBarMenuPageBase;
import com.solvd.carina.demo.common.components.TopMainMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class TopMainMenu extends TopMainMenuBase {

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cartButton;

    public TopMainMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SideBarMenuPageBase openSideBarMenu() {
        int x = (int) (menuButton.getLocation().getX() + menuButton.getSize().getWidth() * 0.54);
        int y = (int) (menuButton.getLocation().getY() + menuButton.getSize().getHeight() * 0.9);
        tap(x, y);
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
