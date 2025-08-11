package com.solvd.carina.demo.common.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class CartItemBase extends AbstractUIObject {

    public CartItemBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getTextFromDescription();

    public abstract String getTextFromPrice();
}
