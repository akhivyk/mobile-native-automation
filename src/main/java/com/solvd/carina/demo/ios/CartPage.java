package com.solvd.carina.demo.ios;

import com.solvd.carina.demo.common.CartPageBase;
import com.solvd.carina.demo.common.CheckoutPageBase;
import com.solvd.carina.demo.common.OverviewPageBase;
import com.solvd.carina.demo.ios.components.CartItem;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.NoSuchElementException;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @ExtendedFindBy(accessibilityId = "test-Item")
    private List<CartItem> cartItems;

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartItem getItemByDescription(String itemDesc) {
        return cartItems.stream()
                .filter(item -> itemDesc.equals(item.getTextFromDescription()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Cart item not found: " + itemDesc));
    }

    public boolean isCartListEmpty() {
        return cartItems.isEmpty();
    }

    public CheckoutPageBase clickCheckoutButton() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }

    public OverviewPageBase completeCheckout(CartPageBase cartPage, String firstName, String lastName, String zipCode) {
        CheckoutPageBase checkoutPage = cartPage.clickCheckoutButton();
        checkoutPage.inputFirstName(firstName);
        checkoutPage.inputLastName(lastName);
        checkoutPage.inputZipCode(zipCode);
        return checkoutPage.clickContinueButton();
    }
}
