package com.solvd.carina.demo;

import com.solvd.carina.demo.common.*;
import com.solvd.carina.demo.common.components.CartItemBase;
import com.solvd.carina.demo.common.components.ItemBase;
import com.solvd.carina.demo.enums.SortingType;
import com.solvd.carina.demo.enums.UserType;
import com.solvd.carina.demo.utils.LoginUtil;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import groovy.util.logging.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class SwagLabsTest implements IAbstractTest, IMobileUtils {
    private LoginUtil loginUtil = new LoginUtil();

    @Test
    public void loginWithValidCredentials() {
        String expectedTitle = "PRODUCTS";

        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        Assert.assertTrue(loginPage.isUsernameInputPresent(), "Username input isn't present!");
        Assert.assertTrue(loginPage.isPasswordInputPresent(), "Password input isn't present!");

        loginPage.selectUser(UserType.STANDARD_USER);
        MainPageBase mainPage = loginPage.clickLoginButton();

        Assert.assertTrue(mainPage.isTitlePresent(), "Title on main page isn't present!");
        Assert.assertEquals(mainPage.getTitleText(), expectedTitle, "Title on main page isn't equals to expected.");

        Assert.assertFalse(mainPage.isItemsListEmpty(), "Items list is empty.");
    }

    @Test
    public void verifyItemPage() {
        MainPageBase mainPage = loginUtil.loginStandardUser();

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");

        String nameOfSelectedItem = "Sauce Labs Backpack";
        String expectedDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String expectedPrice = "$29.99";

        ItemPageBase itemPage = mainPage.clickOnItem(nameOfSelectedItem);

        Assert.assertTrue(itemPage.isItemPicturePresent(), "Item picture isn't present!");
        Assert.assertTrue(itemPage.isItemDescriptionPresent(), "Item description isn't present!");
        Assert.assertTrue(itemPage.isItemPricePresent(), "Item price isn't present!");

        Assert.assertEquals(itemPage.getItemDescriptionText(), expectedDescription, "Description isn't equals to expected!");
        Assert.assertEquals(itemPage.getItemPriceText(), expectedPrice, "Price isn't equals to expected!");
    }

    @Test
    public void textChangesOnClickingCartButton() {
        MainPageBase mainPage = loginUtil.loginStandardUser();

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");

        String itemName = "Sauce Labs Backpack";
        String expectedTextOnAddToCartButtonBeforeClicking = "ADD TO CART";
        String expectedTextOnAddToCartButtonAfterClicking = "REMOVE";

        ItemBase item = mainPage.findItemOnPage(itemName);
        Assert.assertEquals(item.getTextFromAddToCartButton(), expectedTextOnAddToCartButtonBeforeClicking, "Text on " +
                "add to cart button isn't equals to expected before clicking!");

        item.clickAddToCartButton();
        Assert.assertEquals(item.getTextFromRemoveButton(), expectedTextOnAddToCartButtonAfterClicking, "Text on " +
                "add to cart button isn't equals to expected after clicking!");
        Assert.assertEquals(mainPage.getCountOfItemInCart(), "1", "Count of items in cart isn't " +
                "equals to expected after adding to cart!");
    }

    @Test
    public void verifyUserCanMakeOrder() {
        MainPageBase mainPage = loginUtil.loginStandardUser();

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");

        String itemName = "Sauce Labs Backpack";

        ItemPageBase itemPage = mainPage.clickOnItem(itemName);
        String expectedDescription = itemPage.getItemDescriptionText();
        String expectedPrice = itemPage.getItemPriceText();

        itemPage.clickAddToCartButton();
        mainPage = itemPage.clickBackToAllProductsButton();
        CartPageBase cartPage = mainPage.clickCartButton();

        Assert.assertFalse(cartPage.isCartListEmpty(), "Cart is empty.");

        CartItemBase cartItem = cartPage.getItem(expectedDescription);
        Assert.assertEquals(cartItem.getTextFromPrice(), expectedPrice, "Price in cart isn't equals to expected");

        CheckoutPageBase checkoutPage = cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isFirstNameInputPresent(), "First name input isn't present on checkout page!");
        Assert.assertTrue(checkoutPage.isLastNamePresent(), "Last name input isn't present on checkout page!");
        Assert.assertTrue(checkoutPage.isZipCodeInputPresent(), "Zip code input isn't present on checkout page!");

        checkoutPage.inputFirstName(R.TESTDATA.get("swagLabs_fName"));
        checkoutPage.inputLastName(R.TESTDATA.get("swagLabs_lName"));
        checkoutPage.inputZipCode(R.TESTDATA.get("swagLabs_zipCode"));
        OverviewPageBase overviewPage = checkoutPage.clickContinueButton();

        CompletedOrderPageBase completedOrderPage = overviewPage.clickFinishButton();
        Assert.assertTrue(completedOrderPage.isOrderComplete(), "Order isn't create successfully");
    }

    @Test
    public void verifyUserCanLogout() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        loginPage.selectUser(UserType.STANDARD_USER);
        MainPageBase mainPage = loginPage.clickLoginButton();

        MenuPageBase menu = mainPage.clickMenuButton();
        Assert.assertTrue(menu.isLogoutButtonPresent(), "Logout button isn't present in menu!");

        loginPage = menu.clickLogoutButton();
        Assert.assertTrue(loginPage.isUsernameInputPresent(), "Username input isn't present - user isn't back to login page after logging out");
        Assert.assertTrue(loginPage.isPasswordInputPresent(), "Password input isn't present - user isn't back to login page after logging out");
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Login button isn't present - user isn't back to login page after logging out");
    }

    @Test
    public void verifyUserCantLoginWithInvalidCredentials() {
        String invalidPassword = "123456789";
        String expectedErrorMessage = "Username and password do not match any user in this service.";
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        Assert.assertTrue(loginPage.isUsernameInputPresent(), "Username input isn't present!");
        Assert.assertTrue(loginPage.isPasswordInputPresent(), "Password input isn't present!");

        loginPage.inputUsername(UserType.STANDARD_USER.getUsername());
        loginPage.inputPassword(invalidPassword);

        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessageText().equalsIgnoreCase(expectedErrorMessage), "Error message after trying to login with incorrect credentials isn't expected");
    }

    @Test
    public void verifyCorrectPriceWithTwoItemsInCart() {
        MainPageBase mainPage = loginUtil.loginStandardUser();
        String firstItem = "Sauce Labs Bike Light";
        String secondItem = "Sauce Labs Bolt T-Shirt";
        Double totalPriceFromMainPage = 0.0;

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");
        ItemBase firstItemObject = mainPage.findItemOnPage(firstItem);
        totalPriceFromMainPage += firstItemObject.getElementPrice();
        firstItemObject.clickAddToCartButton();

        ItemBase secondItemObject = mainPage.findItemOnPage(secondItem);
        totalPriceFromMainPage += secondItemObject.getElementPrice();
        secondItemObject.clickAddToCartButton();

        CartPageBase cartPage = mainPage.clickCartButton();
        Assert.assertFalse(cartPage.isCartListEmpty(), "Cart is empty.");

        CheckoutPageBase checkoutPage = cartPage.clickCheckoutButton();
        checkoutPage.inputFirstName(R.TESTDATA.get("swagLabs_fName"));
        checkoutPage.inputLastName(R.TESTDATA.get("swagLabs_lName"));
        checkoutPage.inputZipCode(R.TESTDATA.get("swagLabs_zipCode"));
        OverviewPageBase overviewPage = checkoutPage.clickContinueButton();

        Assert.assertEquals(Double.parseDouble(overviewPage.getItemTotalPrice()), totalPriceFromMainPage, "Total item price on checkout overview page isn't equals to expected");
    }

    @Test
    public void verifyUserCantCreateOrderWithoutPostalCode() {
        MainPageBase mainPage = loginUtil.loginStandardUser();
        String expectedErrorMessage = "Postal Code is required";

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");

        String itemName = "Sauce Labs Backpack";
        mainPage.findItemOnPage(itemName).clickAddToCartButton();

        CartPageBase cartPage = mainPage.clickCartButton();
        Assert.assertFalse(cartPage.isCartListEmpty(), "Cart is empty.");

        CheckoutPageBase checkoutPage = cartPage.clickCheckoutButton();

        checkoutPage.inputFirstName(R.TESTDATA.get("swagLabs_fName"));
        checkoutPage.inputLastName(R.TESTDATA.get("swagLabs_lName"));

        checkoutPage.clickContinueButton();

        Assert.assertTrue(checkoutPage.getErrorMessageText().equalsIgnoreCase(expectedErrorMessage), "Error message regarding missing Postal Code isn't equals to expected");
    }

    @Test
    public void verifySortingPriceInDescendingOrder() {
        MainPageBase mainPage = loginUtil.loginStandardUser();
        mainPage.selectSortOption(SortingType.PRICE_HIGH_LOW);

        List<ItemBase> allItems = mainPage.getItems();

        List<Double> actualPrices = allItems.stream()
                .map(ItemBase::getElementPrice)
                .collect(Collectors.toList());

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Comparator.reverseOrder());

        Assert.assertEquals(expectedPrices, actualPrices,
                "List of items isn't sorted by price in descending order");
    }

    @Test
    public void verifySortingNameInDescendingOrder() {
        MainPageBase mainPage = loginUtil.loginStandardUser();
        mainPage.selectSortOption(SortingType.NAME_Z_A);

        List<ItemBase> allItems = mainPage.getItems();

        List<String> actualNames = allItems.stream()
                .map(ItemBase::getElementName)
                .collect(Collectors.toList());

        List<String> expectedNames = new ArrayList<>(actualNames);
        expectedNames.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));

        Assert.assertEquals(expectedNames, actualNames,
                "List of items isn't sorted by name in descending order");
    }
}