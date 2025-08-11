package com.solvd.carina.demo.android;

import com.solvd.carina.demo.common.CompletedOrderPageBase;
import com.solvd.carina.demo.common.OverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OverviewPageBase.class)
public class OverviewPage extends OverviewPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
    private ExtendedWebElement finishButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Item') and contains (@text, 'total')]")
    private ExtendedWebElement itemTotalPrice;

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public CompletedOrderPageBase clickFinishButton() {
        swipe(finishButton);

        finishButton.click();
        return initPage(getDriver(), CompletedOrderPageBase.class);
    }

    public String getItemTotalPrice() {
        swipe(itemTotalPrice);
        return itemTotalPrice.getText().replaceAll("[^0-9.]", "");
    }
}
