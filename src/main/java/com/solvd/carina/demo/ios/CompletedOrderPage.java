package com.solvd.carina.demo.ios;

import com.solvd.carina.demo.common.CompletedOrderPageBase;
import com.solvd.carina.demo.ios.components.TopMainMenu;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CompletedOrderPageBase.class)
public class CompletedOrderPage extends CompletedOrderPageBase {

    @ExtendedFindBy(accessibilityId = "THANK YOU FOR YOU ORDER")
    private ExtendedWebElement completedOrderLabel;

    @ExtendedFindBy(accessibilityId = "headerContainer")
    private TopMainMenu header;

    public CompletedOrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOrderComplete() {
        return completedOrderLabel.isElementPresent();
    }

    public TopMainMenu getTopMainMenu() {
        return header;
    }
}
