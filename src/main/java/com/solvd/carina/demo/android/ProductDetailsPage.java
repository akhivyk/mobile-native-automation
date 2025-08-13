package com.solvd.carina.demo.android;

import com.solvd.carina.demo.common.ProductDetailsPageBase;
import com.solvd.carina.demo.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsPageBase.class)
public class ProductDetailsPage extends ProductDetailsPageBase {

    @ExtendedFindBy(accessibilityId = "test-Image Container")
    private ExtendedWebElement itemPicture;

    @ExtendedFindBy(accessibilityId = "test-Description")
    private ExtendedWebElement itemDescription;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement itemPrice;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'BACK TO PRODUCTS')]")
    private ExtendedWebElement backToAllProductsButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]//android.widget.TextView[2]")
    private ExtendedWebElement subtitleLabel;

    public ProductDetailsPage(WebDriver driver) {
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

    public ProductListPageBase clickBackToAllProductsButton() {
        backToAllProductsButton.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }
}
