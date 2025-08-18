package com.solvd.carina.demo.common;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class BasePage extends AbstractPage implements IMobileUtils, ICustomTypePageFactory {

    public BasePage(WebDriver driver) {
        super(driver);
    }
}
