package com.solvd.carina.demo.common.components;

import com.solvd.carina.demo.android.components.AndroidTopMainMenu;
import com.solvd.carina.demo.common.BasePage;
import com.solvd.carina.demo.ios.components.IOSTopMainMenu;
import org.openqa.selenium.WebDriver;

public class TopMainMenuFactory extends BasePage {

    public TopMainMenuFactory(WebDriver driver) {
        super(driver);
    }

    public TopMainMenuBase create() {
        String platformName = getCapabilities().getPlatformName().name().toLowerCase();

        switch (platformName) {
            case "android":
                return new AndroidTopMainMenu(driver);
            case "ios":
                return new IOSTopMainMenu(driver);
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platformName);
        }
    }
}
