package com.solvd.carina.demo.android;

import com.solvd.carina.demo.android.components.TopMainMenu;
import com.solvd.carina.demo.common.CompletedOrderPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CompletedOrderPageBase.class)
public class CompletedOrderPage extends CompletedOrderPageBase {

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT: COMPLETE!")
    private ExtendedWebElement completedOrderLabel;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/..")
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
