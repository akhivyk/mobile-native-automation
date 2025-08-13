package com.solvd.carina.demo.common.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class SortComponentBase extends AbstractUIObject {

    protected SortComponentBase(WebDriver driver) {
        super(driver);
    }
}
