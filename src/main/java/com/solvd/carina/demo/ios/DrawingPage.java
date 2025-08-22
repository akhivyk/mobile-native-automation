package com.solvd.carina.demo.ios;

import com.solvd.carina.demo.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase {

    public DrawingPage(WebDriver driver) {
        super(driver);
    }
}
