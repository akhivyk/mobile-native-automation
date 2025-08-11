package com.solvd.carina.demo.common;

import com.solvd.carina.demo.common.components.ItemBase;
import com.solvd.carina.demo.enums.SortingType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class MainPageBase extends AbstractPage implements IMobileUtils {
    public MainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitlePresent();

    public abstract boolean isPageOpened();

    public abstract String getTitleText();

    public abstract boolean isItemsListEmpty();

    public abstract ItemPageBase clickOnItem(String itemName);

    public abstract ItemBase findItemOnPage(String itemName);

    public abstract MenuPageBase clickMenuButton();

    public abstract String getCountOfItemInCart();

    public abstract CartPageBase clickCartButton();

    public abstract void selectSortOption(SortingType sortingType);

    public abstract List<ItemBase> getItems();
}
