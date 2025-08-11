package com.solvd.carina.demo.ios;

import com.solvd.carina.demo.ios.components.SortingContainer;
import com.solvd.carina.demo.common.CartPageBase;
import com.solvd.carina.demo.common.ItemPageBase;
import com.solvd.carina.demo.common.MainPageBase;
import com.solvd.carina.demo.common.MenuPageBase;
import com.solvd.carina.demo.common.components.ItemBase;
import com.solvd.carina.demo.enums.SortingType;
import com.solvd.carina.demo.ios.components.Item;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"PRODUCTS\"`]")
    private ExtendedWebElement titleLabel;

    @ExtendedFindBy(accessibilityId = "test-Item")
    private List<Item> items;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement sortingButton;

    public MainPage(WebDriver driver) {
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

    public ItemPageBase clickOnItem(String itemName) {
        items.forEach(a ->System.out.println(a.getElementName()));
        return items.stream()
                .filter(item -> itemName.equalsIgnoreCase(item.getElementName()))
                .findFirst()
                .map(Item::clickOnName)
                .orElseThrow(() -> new NoSuchElementException("Item not found: " + itemName));
    }

    public Item findItemOnPage(String itemName) {
        return items.stream()
                .filter(item -> itemName.equalsIgnoreCase(item.getElementName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item not found: " + itemName));
    }

    public MenuPageBase clickMenuButton() {
        int x = (int) (menuButton.getLocation().getX() + menuButton.getSize().getWidth() * 0.54);
        int y = (int) (menuButton.getLocation().getY() + menuButton.getSize().getHeight() * 0.9);
        tap(x, y);
        return initPage(getDriver(), MenuPageBase.class);
    }

    public String getCountOfItemInCart() {
        return cartButton.getAttribute("label");
    }

    public CartPageBase clickCartButton() {
        int x = (int) (cartButton.getLocation().getX() + cartButton.getSize().getWidth() * 0.54);
        int y = (int) (cartButton.getLocation().getY() + cartButton.getSize().getHeight() * 0.9);
        tap(x, y);
        return initPage(getDriver(), CartPageBase.class);
    }

    public void selectSortOption(SortingType sortingType) {
        sortingButton.click();
        SortingContainer sortingContainer = new SortingContainer(getDriver());
        sortingContainer.selectSortOption(sortingType);
    }

    public List<ItemBase> getItems() {
        return new ArrayList<>(items);
    }
}
