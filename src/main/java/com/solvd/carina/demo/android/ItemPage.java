package com.solvd.carina.demo.android;

import com.solvd.carina.demo.common.ItemPageBase;
import com.solvd.carina.demo.common.MainPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ItemPageBase.class)
public class ItemPage extends ItemPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Image Container\"]")
    private ExtendedWebElement itemPicture;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]")
    private ExtendedWebElement itemDescription;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
    private ExtendedWebElement itemPrice;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"BACK TO PRODUCTS\"]")
    private ExtendedWebElement backToAllProductsButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]//android.widget.TextView[2]")
    private ExtendedWebElement subtitleLabel;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public boolean isItemPicturePresent() {
        return itemPicture.isElementPresent();
    }

    public boolean isItemDescriptionPresent() {
        return itemDescription.isPresent();
    }

    public boolean isItemPricePresent() {
        return itemPrice.isElementPresent();
    }

    public String getItemDescriptionText() {
        return subtitleLabel.getText();
    }

    public String getItemPriceText() {
        return itemPrice.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public MainPageBase clickBackToAllProductsButton() {
        backToAllProductsButton.click();
        return initPage(getDriver(), MainPageBase.class);
    }
}
