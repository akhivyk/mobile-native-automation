package com.solvd.carina.demo.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class OverviewPageBase extends AbstractPage implements IMobileUtils {

    public OverviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CompletedOrderPageBase clickFinishButton();

    public abstract String getItemTotalPrice();
}
