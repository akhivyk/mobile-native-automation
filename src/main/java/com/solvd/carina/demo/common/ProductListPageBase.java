package com.solvd.carina.demo.common;

import com.solvd.carina.demo.common.components.ProductListItemComponentBase;
import com.solvd.carina.demo.enums.SortingType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductListPageBase extends AbstractPage implements IMobileUtils {
    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitlePresent();

    public abstract boolean isPageOpened();

    public abstract String getTitleText();

    public abstract boolean isItemsListEmpty();

    public abstract ProductDetailsPageBase openProductItem(String itemName);

    public abstract ProductListItemComponentBase findItemOnPage(String itemName);

    public abstract SideBarMenuPageBase openSideBarMenu();

    public abstract String getCountOfItemInCart();

    public abstract CartPageBase clickCartButton();

    public abstract void selectSortOption(SortingType sortingType);

    public abstract List<ProductListItemComponentBase> getAllProductItems();

    public abstract CartPageBase addItemsToCart(ProductListPageBase mainPage, List<String> productNames);
}
