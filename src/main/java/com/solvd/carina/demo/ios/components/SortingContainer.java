package com.solvd.carina.demo.ios.components;

import com.solvd.carina.demo.common.components.SortingContainerBase;
import com.solvd.carina.demo.enums.SortingType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class SortingContainer extends SortingContainerBase {

    @ExtendedFindBy(accessibilityId = "%s")
    private ExtendedWebElement sortOption;

    public SortingContainer(WebDriver driver) {
        super(driver);
    }

    public void selectSortOption(SortingType sortingType) {
        sortOption.format(sortingType.getSortOption()).click();
    }
}
