package com.solvd.carina.demo.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailsPageBase extends AbstractPage {

    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isItemPicturePresent();

    public abstract boolean isItemDescriptionPresent();

    public abstract boolean isItemPricePresent();

    public abstract String getItemDescriptionText();

    public abstract String getItemPriceText();

    public abstract void clickAddToCartButton();

    public abstract ProductListPageBase clickBackToAllProductsButton();
}
