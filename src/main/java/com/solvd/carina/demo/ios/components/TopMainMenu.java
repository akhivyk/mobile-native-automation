package com.solvd.carina.demo.ios.components;

import com.solvd.carina.demo.common.CartPageBase;
import com.solvd.carina.demo.common.SideBarMenuPageBase;
import com.solvd.carina.demo.common.components.TopMainMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
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

    public String getCountOfItemInCart() {
        return cartButton.getAttribute("label");
    }

    public CartPageBase clickCartButton() {
        int x = (int) (cartButton.getLocation().getX() + cartButton.getSize().getWidth() * 0.54);
        int y = (int) (cartButton.getLocation().getY() + cartButton.getSize().getHeight() * 0.9);
        tap(x, y);
        return initPage(getDriver(), CartPageBase.class);
    }
}
