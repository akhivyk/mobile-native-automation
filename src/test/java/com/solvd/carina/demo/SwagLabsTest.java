package com.solvd.carina.demo;

import com.solvd.carina.demo.common.*;
import com.solvd.carina.demo.common.components.CartItemBase;
import com.solvd.carina.demo.common.components.ProductListItemComponentBase;
import com.solvd.carina.demo.enums.SortingType;
import com.solvd.carina.demo.enums.UserType;
import com.solvd.carina.demo.utils.LoginUtil;
import com.zebrunner.carina.utils.R;
import groovy.util.logging.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class SwagLabsTest extends BaseTest {
    private LoginUtil loginUtil = new LoginUtil();

    private static final String LABS_BACKPACK = "Sauce Labs Backpack";
    private static final String LABS_BIKE_LIGHT = "Sauce Labs Bike Light";
    private static final String LABS_BOLT_TSHIRT = "Sauce Labs Bolt T-Shirt";

    @Test
    public void loginTest() {
        String expectedTitle = "PRODUCTS";

        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        Assert.assertTrue(loginPage.isUsernameInputPresent(), "Username input isn't present!");
        Assert.assertTrue(loginPage.isPasswordInputPresent(), "Password input isn't present!");

        loginPage.selectUser(UserType.STANDARD_USER);
        ProductListPageBase mainPage = loginPage.clickLoginButton();

        Assert.assertTrue(mainPage.isTitlePresent(), "Title on main page isn't present!");
        Assert.assertEquals(mainPage.getTitleText(), expectedTitle, "Title on main page isn't equals to expected.");

        Assert.assertFalse(mainPage.isItemsListEmpty(), "Items list is empty.");
    }

    @Test
    public void verifyItemPage() {
        ProductListPageBase mainPage = loginUtil.loginStandardUser();

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");

        String expectedDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String expectedPrice = "$29.99";

        ProductDetailsPageBase itemPage = mainPage.openProductItem(LABS_BACKPACK);

        Assert.assertTrue(itemPage.isItemPicturePresent(), "Item picture isn't present!");
        Assert.assertTrue(itemPage.isItemDescriptionPresent(), "Item description isn't present!");
        Assert.assertTrue(itemPage.isItemPricePresent(), "Item price isn't present!");

        Assert.assertEquals(itemPage.getItemDescriptionText(), expectedDescription, "Description isn't equals to expected!");
        Assert.assertEquals(itemPage.getItemPriceText(), expectedPrice, "Price isn't equals to expected!");
    }

    @Test
    public void verifyTextChangesOnClickingCartButton() {
        ProductListPageBase mainPage = loginUtil.loginStandardUser();

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");

        String expectedTextOnAddToCartButtonBeforeClicking = "ADD TO CART";
        String expectedTextOnAddToCartButtonAfterClicking = "REMOVE";

        ProductListItemComponentBase item = mainPage.findItemOnPage(LABS_BACKPACK);
        Assert.assertEquals(item.getTextFromAddToCartButton(), expectedTextOnAddToCartButtonBeforeClicking, "Text on " +
                "add to cart button isn't equals to expected before clicking!");

        item.clickAddToCartButton();
        Assert.assertEquals(item.getTextFromRemoveButton(), expectedTextOnAddToCartButtonAfterClicking, "Text on " +
                "add to cart button isn't equals to expected after clicking!");
        Assert.assertEquals(mainPage.getTopMainMenu().getCountOfItemInCart(), "1", "Count of items in cart isn't " +
                "equals to expected after adding to cart!");
    }

    @Test
    public void verifyUserCanMakeOrder() {
        ProductListPageBase mainPage = loginUtil.loginStandardUser();

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");

        ProductDetailsPageBase itemPage = mainPage.openProductItem(LABS_BACKPACK);
        String expectedDescription = itemPage.getItemDescriptionText();
        String expectedPrice = itemPage.getItemPriceText();

        itemPage.clickAddToCartButton();
        mainPage = itemPage.clickBackToAllProductsButton();
        CartPageBase cartPage = mainPage.getTopMainMenu().clickCartButton();

        Assert.assertFalse(cartPage.isCartListEmpty(), "Cart is empty.");

        CartItemBase cartItem = cartPage.getItemByDescription(expectedDescription);
        Assert.assertEquals(cartItem.getTextFromPrice(), expectedPrice, "Price in cart isn't equals to expected");

        OverviewPageBase overviewPage = cartPage.completeCheckout(cartPage, R.TESTDATA.get("swagLabs_fName"), R.TESTDATA.get("swagLabs_lName"), R.TESTDATA.get("swagLabs_zipCode"));

        CompletedOrderPageBase completedOrderPage = overviewPage.clickFinishButton();
        Assert.assertTrue(completedOrderPage.isOrderComplete(), "Order isn't create successfully");
    }

    @Test
    public void verifyUserCanLogout() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);

        loginPage.selectUser(UserType.STANDARD_USER);
        ProductListPageBase mainPage = loginPage.clickLoginButton();

        SideBarMenuPageBase menu = mainPage.getTopMainMenu().openSideBarMenu();
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
        ProductListPageBase mainPage = loginUtil.loginStandardUser();
        Double totalPriceFromMainPage = 0.0;

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");
        ProductListItemComponentBase firstItemObject = mainPage.findItemOnPage(LABS_BIKE_LIGHT);
        totalPriceFromMainPage += firstItemObject.getProductPrice();
        firstItemObject.clickAddToCartButton();

        ProductListItemComponentBase secondItemObject = mainPage.findItemOnPage(LABS_BOLT_TSHIRT);
        totalPriceFromMainPage += secondItemObject.getProductPrice();
        secondItemObject.clickAddToCartButton();

        CartPageBase cartPage = mainPage.getTopMainMenu().clickCartButton();
        Assert.assertFalse(cartPage.isCartListEmpty(), "Cart is empty.");

        OverviewPageBase overviewPage = cartPage.completeCheckout(cartPage, R.TESTDATA.get("swagLabs_fName"), R.TESTDATA.get("swagLabs_lName"), R.TESTDATA.get("swagLabs_zipCode"));

        Assert.assertEquals(Double.parseDouble(overviewPage.getItemTotalPrice()), totalPriceFromMainPage, "Total item price on checkout overview page isn't equals to expected");
    }

    @Test
    public void verifyUserCantCreateOrderWithoutPostalCode() {
        ProductListPageBase mainPage = loginUtil.loginStandardUser();
        String expectedErrorMessage = "Postal Code is required";

        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't opened!");

        CartPageBase cartPage = mainPage.addItemsToCart(mainPage, List.of(LABS_BACKPACK));
        Assert.assertFalse(cartPage.isCartListEmpty(), "Cart is empty.");

        CheckoutPageBase checkoutPage = cartPage.clickCheckoutButton();

        checkoutPage.inputFirstName(R.TESTDATA.get("swagLabs_fName"));
        checkoutPage.inputLastName(R.TESTDATA.get("swagLabs_lName"));

        checkoutPage.clickContinueButton();

        Assert.assertTrue(checkoutPage.getErrorMessageText().equalsIgnoreCase(expectedErrorMessage), "Error message regarding missing Postal Code isn't equals to expected");
    }

    @Test
    public void verifySortingPriceInDescendingOrder() {
        ProductListPageBase mainPage = loginUtil.loginStandardUser();
        mainPage.selectSortOption(SortingType.PRICE_HIGH_LOW);

        List<ProductListItemComponentBase> allItems = mainPage.getAllProductItems();

        List<Double> actualPrices = allItems.stream()
                .map(ProductListItemComponentBase::getProductPrice)
                .collect(Collectors.toList());

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Comparator.reverseOrder());

        Assert.assertEquals(expectedPrices, actualPrices,
                "List of items isn't sorted by price in descending order");
    }

    @Test
    public void verifySortingNameInDescendingOrder() {
        ProductListPageBase mainPage = loginUtil.loginStandardUser();
        mainPage.selectSortOption(SortingType.NAME_Z_A);

        List<ProductListItemComponentBase> allItems = mainPage.getAllProductItems();

        List<String> actualNames = allItems.stream()
                .map(ProductListItemComponentBase::getElementName)
                .collect(Collectors.toList());

        List<String> expectedNames = new ArrayList<>(actualNames);
        expectedNames.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));

        Assert.assertEquals(expectedNames, actualNames,
                "List of items isn't sorted by name in descending order");
    }

    @Test
    public void verifyDrawingSquare() {
        ProductListPageBase mainPage = loginUtil.loginStandardUser();
        DrawingPageBase drawingPage = mainPage.getTopMainMenu().openSideBarMenu().clickDrawingButton();

        drawingPage.drawSquare();
        Assert.assertTrue(drawingPage.checkExpectedShape(), "Drawing shape isn't equals to expected");
    }
}