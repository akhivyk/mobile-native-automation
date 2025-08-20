package com.solvd.carina.demo.common;

import com.solvd.carina.demo.common.components.ProductListItemComponentBase;
import com.solvd.carina.demo.enums.SortingType;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductListPageBase extends BasePage {
    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitlePresent();

    public abstract boolean isPageOpened();

    public abstract String getTitleText();

    public abstract boolean isItemsListEmpty();

    public abstract ProductDetailsPageBase openProductItem(String itemName);

    public abstract ProductListItemComponentBase findItemOnPage(String itemName);

    public abstract void selectSortOption(SortingType sortingType);

    public abstract List<ProductListItemComponentBase> getAllProductItems();

    public abstract CartPageBase addItemsToCart(ProductListPageBase mainPage, List<String> productNames);
}
