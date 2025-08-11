package com.solvd.carina.demo.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends AbstractPage {

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isFirstNameInputPresent();

    public abstract boolean isLastNamePresent();

    public abstract boolean isZipCodeInputPresent();

    public abstract OverviewPageBase clickContinueButton();

    public abstract void inputFirstName(String firstName);

    public abstract void inputLastName(String lastName);

    public abstract void inputZipCode(String zipCode);

    public abstract String getErrorMessageText();
}
