package com.solvd.carina.demo.common.components;

import com.solvd.carina.demo.common.ProductDetailsPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductListItemComponentBase extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils {

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
