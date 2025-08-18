package com.solvd.carina.demo.common.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class CartItemBase extends BaseComponent {

    public CartItemBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getTextFromDescription();

    public abstract String getTextFromPrice();
}
