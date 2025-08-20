package com.solvd.carina.demo.utils;

import com.solvd.carina.demo.common.LoginPageBase;
import com.solvd.carina.demo.common.ProductListPageBase;
import com.solvd.carina.demo.enums.UserType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class LoginUtil implements ICustomTypePageFactory {

    public ProductListPageBase loginStandardUser() {
        return login(UserType.STANDARD_USER);
    }

    public ProductListPageBase login(UserType userType) {
        LoginPageBase loginPage = initPage(LoginPageBase.class);

        loginPage.selectUser(userType);
        return loginPage.clickLoginButton();
    }
}
