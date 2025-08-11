package com.solvd.carina.demo.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CompletedOrderPageBase extends AbstractPage {

    public CompletedOrderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOrderComplete();
}
