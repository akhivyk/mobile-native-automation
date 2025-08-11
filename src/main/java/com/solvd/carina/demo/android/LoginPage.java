package com.solvd.carina.demo.android;

import com.solvd.carina.demo.common.LoginPageBase;
import com.solvd.carina.demo.common.MainPageBase;
import com.solvd.carina.demo.enums.UserType;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    private ExtendedWebElement usernameInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"%s\"]")
    private ExtendedWebElement selectUserCredentialsButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]//android.widget.TextView")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUsernameInputPresent() {
        return usernameInput.isElementPresent(1);
    }

    public boolean isPasswordInputPresent() {
        return passwordInput.isElementPresent(1);
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent(1);
    }

    public void inputPassword(String password) {
        passwordInput.type(password);
    }

    public void inputUsername(String username) {
        usernameInput.type(username);
    }

    public MainPageBase clickLoginButton() {
        loginButton.click();
        return initPage(getDriver(), MainPageBase.class);
    }

    public void selectUser(UserType userType) {
        selectUserCredentialsButton.format(userType.getUsername()).click();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
