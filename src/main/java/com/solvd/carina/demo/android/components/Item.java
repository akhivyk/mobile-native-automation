package com.solvd.carina.demo.android.components;

import com.solvd.carina.demo.common.ItemPageBase;
import com.solvd.carina.demo.common.components.ItemBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Item extends ItemBase implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\"]")
    private ExtendedWebElement name;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
    private ExtendedWebElement price;

    @FindBy(xpath = "//android.widget.TextView[@text=\"ADD TO CART\"]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"REMOVE\"]")
    private ExtendedWebElement removeFromCartButton;

    public Item(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ItemPageBase clickOnName() {
        name.click();
        return initPage(ItemPageBase.class);
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

    public Double getElementPrice() {
        swipe(price);
        return Double.parseDouble(price.getText().replaceAll("[^0-9.]", ""));
    }
}
