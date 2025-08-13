package com.solvd.carina.demo.android;

import com.solvd.carina.demo.common.LoginPageBase;
import com.solvd.carina.demo.common.ProductListPageBase;
import com.solvd.carina.demo.constants.TimeConstant;
import com.solvd.carina.demo.enums.UserType;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement usernameInput;

    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordInput;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"%s\"]")
    private ExtendedWebElement selectUserCredentialsButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]//android.widget.TextView")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUsernameInputPresent() {
        return usernameInput.isElementPresent(TimeConstant.SMALL_TIMEOUT);
    }

    public boolean isPasswordInputPresent() {
        return passwordInput.isElementPresent(TimeConstant.SMALL_TIMEOUT);
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent(TimeConstant.SMALL_TIMEOUT);
    }

    public void inputPassword(String password) {
        passwordInput.type(password);
    }

    public void inputUsername(String username) {
        usernameInput.type(username);
    }

    public ProductListPageBase clickLoginButton() {
        loginButton.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    public void selectUser(UserType userType) {
        selectUserCredentialsButton.format(userType.getUsername()).click();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
