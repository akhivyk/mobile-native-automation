package com.solvd.carina.demo.common;

import com.solvd.carina.demo.common.components.CartItemBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCartListEmpty();

    public abstract CartItemBase getItem(String itemDesc);

    public abstract CheckoutPageBase clickCheckoutButton();
}
