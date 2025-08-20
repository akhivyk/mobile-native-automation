package com.solvd.carina.demo.android;

import com.solvd.carina.demo.android.components.ProductListItemComponent;
import com.solvd.carina.demo.android.components.SortComponent;
import com.solvd.carina.demo.common.CartPageBase;
import com.solvd.carina.demo.common.ProductDetailsPageBase;
import com.solvd.carina.demo.common.ProductListPageBase;
import com.solvd.carina.demo.common.components.ProductListItemComponentBase;
import com.solvd.carina.demo.enums.SortingType;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase {

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'PRODUCTS')]")
    private ExtendedWebElement titleLabel;

    @ExtendedFindBy(accessibilityId = "test-Item")
    private List<ProductListItemComponent> items;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement sortingButton;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isTitlePresent();
    }

    public boolean isTitlePresent() {
        return titleLabel.isElementPresent();
    }

    public String getTitleText() {
        return titleLabel.getText();
    }

    public boolean isItemsListEmpty() {
        return items.isEmpty();
    }

    public ProductDetailsPageBase openProductItem(String itemName) {
        return items.stream()
                .filter(item -> itemName.equals(item.getElementName()))
                .findFirst()
                .map(ProductListItemComponent::clickOnName)
                .orElseThrow(() -> new NoSuchElementException("Item not found: " + itemName));
    }

    public ProductListItemComponent findItemOnPage(String itemName) {
        return items.stream()
                .filter(item -> itemName.equals(item.getElementName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item not found: " + itemName));
    }

    public void selectSortOption(SortingType sortingType) {
        sortingButton.click();
        SortComponent sortingContainer = new SortComponent(getDriver());
        sortingContainer.selectSortOption(sortingType);
    }

    public List<ProductListItemComponentBase> getAllProductItems() {
        return new ArrayList<>(items);
    }

    public CartPageBase addItemsToCart(ProductListPageBase mainPage, List<String> productNames) {
        for (String productName : productNames) {
            ProductListItemComponent productListItemComponent = findItemOnPage(productName);
            productListItemComponent.clickAddToCartButton();
        }
        return getTopMainMenu().clickCartButton();
    }
}
