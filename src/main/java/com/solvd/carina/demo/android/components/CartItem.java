package com.solvd.carina.demo.android.components;

import com.solvd.carina.demo.common.components.CartItemBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class CartItem extends CartItemBase {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"test-Description\").childSelector(new UiSelector().className(\"android.widget.TextView\").instance(1))")
    private ExtendedWebElement description;

    @ExtendedFindBy(androidUIAutomator = "UiSelector().description(\"test-Price\").childSelector(new UiSelector().className(\"android.widget.TextView\").textMatches(\".+\")).instance(0)\n")
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
