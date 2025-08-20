package com.solvd.carina.demo.ios.components;

import com.solvd.carina.demo.common.components.SortComponentBase;
import com.solvd.carina.demo.enums.SortingType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class SortComponent extends SortComponentBase {

    @ExtendedFindBy(accessibilityId = "%s")
    private ExtendedWebElement sortOption;

    public SortComponent(WebDriver driver) {
        super(driver);
    }

    public void selectSortOption(SortingType sortingType) {
        sortOption.format(sortingType.getSortOption()).click();
    }
}
