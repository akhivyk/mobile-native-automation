package com.solvd.carina.demo.android.components;

import com.solvd.carina.demo.common.ProductDetailsPageBase;
import com.solvd.carina.demo.common.components.ProductListItemComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductListItemComponent extends ProductListItemComponentBase {

    @ExtendedFindBy(accessibilityId = "test-Item title")
    private ExtendedWebElement name;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement price;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'ADD TO CART')]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'REMOVE')]")
    private ExtendedWebElement removeFromCartButton;

    public ProductListItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductDetailsPageBase clickOnName() {
        name.click();
        return initPage(ProductDetailsPageBase.class);
    }

    public String getElementName() {
        return name.getText();
    }

    public String getTextFromAddToCartButton() {
        return addToCartButton.getText();
    }

    public String getTextFromRemoveButton() {
        return removeFromCartButton.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public Double getProductPrice() {
        swipe(price);
        return Double.parseDouble(price.getText().replaceAll("[^0-9.]", ""));
    }
}
