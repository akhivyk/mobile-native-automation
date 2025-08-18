package com.solvd.carina.demo.ios;

import com.solvd.carina.demo.common.CheckoutPageBase;
import com.solvd.carina.demo.common.OverviewPageBase;
import com.solvd.carina.demo.ios.components.TopMainMenu;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    @ExtendedFindBy(accessibilityId = "test-First Name")
    private ExtendedWebElement firstNameInput;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    private ExtendedWebElement lastNameInput;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    private ExtendedWebElement zipCodeInput;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
    private ExtendedWebElement continueButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Error message\"`]")
    private ExtendedWebElement errorMessage;

    @ExtendedFindBy(accessibilityId = "headerContainer")
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
