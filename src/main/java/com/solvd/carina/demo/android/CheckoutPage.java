package com.solvd.carina.demo.android;

import com.solvd.carina.demo.android.components.TopMainMenu;
import com.solvd.carina.demo.common.CheckoutPageBase;
import com.solvd.carina.demo.common.OverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    @ExtendedFindBy(accessibilityId = "test-First Name")
    private ExtendedWebElement firstNameInput;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    private ExtendedWebElement lastNameInput;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    private ExtendedWebElement zipCodeInput;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
    private ExtendedWebElement continueButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"test-Error message\").childSelector(new UiSelector().className(\"android.widget.TextView\").textContains(\"Postal Code is required\"))")
    private ExtendedWebElement errorMessage;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/..")
    private TopMainMenu header;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFirstNameInputPresent() {
        return firstNameInput.isElementPresent();
    }

    public boolean isLastNamePresent() {
        return lastNameInput.isElementPresent();
    }

    public boolean isZipCodeInputPresent() {
        return zipCodeInput.isElementPresent();
    }

    public OverviewPageBase clickContinueButton() {
        continueButton.click();
        return initPage(getDriver(), OverviewPageBase.class);
    }

    public void inputFirstName(String firstName) {
        firstNameInput.type(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameInput.type(lastName);
    }

    public void inputZipCode(String zipCode) {
        zipCodeInput.type(zipCode);
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public TopMainMenu getTopMainMenu() {
        return header;
    }
}
