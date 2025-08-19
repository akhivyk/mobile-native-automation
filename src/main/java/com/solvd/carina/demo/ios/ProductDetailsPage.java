package com.solvd.carina.demo.ios;

import com.solvd.carina.demo.common.ProductDetailsPageBase;
import com.solvd.carina.demo.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductDetailsPageBase.class)
public class ProductDetailsPage extends ProductDetailsPageBase {

    @ExtendedFindBy(accessibilityId = "test-Image Container")
    private ExtendedWebElement itemPicture;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Description\"`]/**/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement itemDescription;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement itemPrice;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(accessibilityId = "test-BACK TO PRODUCTS")
    private ExtendedWebElement backToAllProductsButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isItemPicturePresent() {
        return itemPicture.isElementPresent(1);
    }

    public boolean isItemDescriptionPresent() {
        return itemDescription.isPresent(1);
    }

    public boolean isItemPricePresent() {
        return itemPrice.isElementPresent(1);
    }

    public String getItemDescriptionText() {
        return itemDescription.getText();
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
