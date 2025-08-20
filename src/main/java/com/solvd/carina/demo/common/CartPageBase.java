package com.solvd.carina.demo.common;

import com.solvd.carina.demo.common.components.CartItemBase;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends BasePage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCartListEmpty();

    public abstract CartItemBase getItemByDescription(String itemDesc);

    public abstract CheckoutPageBase clickCheckoutButton();

    public abstract OverviewPageBase completeCheckout(CartPageBase cartPage, String firstName, String lastName, String zipCode);
}
