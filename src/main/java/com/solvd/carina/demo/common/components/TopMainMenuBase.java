package com.solvd.carina.demo.common.components;

import com.solvd.carina.demo.common.CartPageBase;
import com.solvd.carina.demo.common.SideBarMenuPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class TopMainMenuBase extends BaseComponent{

    public TopMainMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract SideBarMenuPageBase openSideBarMenu();

    public abstract CartPageBase clickCartButton();

    public abstract String getCountOfItemInCart();
}
