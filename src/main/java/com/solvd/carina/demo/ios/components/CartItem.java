package com.solvd.carina.demo.ios.components;

import com.solvd.carina.demo.common.components.CartItemBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class CartItem extends CartItemBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Description\"`]/**/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement description;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement price;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTextFromDescription() {
        return description.getAttribute("label");
    }

    public String getTextFromPrice() {
        return price.getText().replaceAll("REMOVE", "").trim();
    }
}
