package com.solvd.carina.demo.android.components;

import com.solvd.carina.demo.common.components.SortingContainerBase;
import com.solvd.carina.demo.enums.SortingType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SortingContainer extends SortingContainerBase {

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement sortOption;

    public SortingContainer(WebDriver driver) {
        super(driver);
    }

    public void selectSortOption(SortingType sortingType) {
        sortOption.format(sortingType.getSortOption()).click();
    }
}
