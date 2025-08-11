package com.solvd.carina.demo.android.components;

import com.solvd.carina.demo.common.components.CartItemBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends CartItemBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]//android.widget.TextView[2]")
    private ExtendedWebElement description;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Price\"]//android.widget.TextView[@text])[1]")
    private ExtendedWebElement price;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTextFromDescription() {
        return description.getText();
    }

    public String getTextFromPrice() {
        return price.getText();
    }
}
