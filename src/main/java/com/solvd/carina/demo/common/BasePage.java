package com.solvd.carina.demo.common;

import com.solvd.carina.demo.common.components.TopMainMenuBase;
import com.solvd.carina.demo.common.components.TopMainMenuFactory;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class BasePage extends AbstractPage implements IMobileUtils, ICustomTypePageFactory {

    protected TopMainMenuBase topMainMenu;

    public TopMainMenuBase getTopMainMenu() {
        if (topMainMenu == null) {
            topMainMenu = new TopMainMenuFactory(getDriver()).create();
        }
        return topMainMenu;
    }

    public BasePage(WebDriver driver) {
        super(driver);
    }
}
