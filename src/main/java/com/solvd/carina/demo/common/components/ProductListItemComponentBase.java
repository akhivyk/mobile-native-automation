package com.solvd.carina.demo.common.components;

import com.solvd.carina.demo.common.ProductDetailsPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductListItemComponentBase extends BaseComponent {

    public ProductListItemComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ProductDetailsPageBase clickOnName();

    public abstract String getElementName();

    public abstract String getTextFromAddToCartButton();

    public abstract String getTextFromRemoveButton();

    public abstract void clickAddToCartButton();

    public abstract Double getProductPrice();
}
