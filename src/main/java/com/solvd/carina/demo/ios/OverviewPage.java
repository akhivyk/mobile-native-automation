package com.solvd.carina.demo.ios;

import com.solvd.carina.demo.common.CompletedOrderPageBase;
import com.solvd.carina.demo.common.OverviewPageBase;
import com.solvd.carina.demo.ios.components.TopMainMenu;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = OverviewPageBase.class)
public class OverviewPage extends OverviewPageBase {

    @ExtendedFindBy(accessibilityId = "test-FINISH")
    private ExtendedWebElement finishButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name CONTAINS \"Item total:\"`]")
    private ExtendedWebElement itemTotalPrice;

    @ExtendedFindBy(accessibilityId = "headerContainer")
    private TopMainMenu header;

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public CompletedOrderPageBase clickFinishButton() {
        finishButton.click();
        return initPage(getDriver(), CompletedOrderPageBase.class);
    }

    public String getItemTotalPrice() {
        return itemTotalPrice.getText().replaceAll("[^0-9.]", "");
    }

    public TopMainMenu getTopMainMenu() {
        return header;
    }
}
