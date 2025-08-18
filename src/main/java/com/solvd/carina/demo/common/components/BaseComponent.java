package com.solvd.carina.demo.common.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class BaseComponent extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils {
    public BaseComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public BaseComponent(WebDriver driver) {
        super(driver);
    }
}
