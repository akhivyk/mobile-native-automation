package com.solvd.carina.demo.common;

import com.solvd.carina.demo.common.components.CartItemBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage implements IMobileUtils {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCartListEmpty();

    public abstract CartItemBase getItemByDescription(String itemDesc);

    public abstract CheckoutPageBase clickCheckoutButton();

    public abstract OverviewPageBase completeCheckout(CartPageBase cartPage, String firstName, String lastName, String zipCode);
}
