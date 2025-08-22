package com.solvd.carina.demo.common;

import com.solvd.carina.demo.constants.TimeConstant;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.*;

public abstract class DrawingPageBase extends BasePage {

    @ExtendedFindBy(accessibilityId = "test-DRAWING-SCREEN")
    private ExtendedWebElement drawingScreen;

    @ExtendedFindBy(image = "images/drawing_square.png")
    private ExtendedWebElement expectedSquareScreenshot;

    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public void drawSquare() {
        Rectangle rect = drawingScreen.getElement().getRect();
        int offsetX = rect.getX();
        int offsetY = rect.getY();
        int width = rect.getWidth();
        int height = rect.getHeight();

        List<Point> square = Arrays.asList(
                new Point(offsetX + width / 4, offsetY + height / 4),
                new Point(offsetX + 3 * width / 4, offsetY + height / 4),
                new Point(offsetX + 3 * width / 4, offsetY + 3 * height / 4),
                new Point(offsetX + width / 4, offsetY + 3 * height / 4),
                new Point(offsetX + width / 4, offsetY + height / 4)
        );

        drawPolyline(square, Duration.ofMillis(500));
    }

    public void drawPolyline(List<Point> points, Duration perSegment) {
        if (points == null || points.size() < 2) {
            throw new IllegalArgumentException("Need at least 2 points to draw a shape");
        }

        WebDriver drv = getDriver();

        if (!(drv instanceof Interactive)) {
            throw new UnsupportedOperationException("Driver does not support W3C Actions");
        }

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence seq = new Sequence(finger, 1);

        Point start = points.get(0);
        seq.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        for (int i = 1; i < points.size(); i++) {
            Point p = points.get(i);
            seq.addAction(finger.createPointerMove(perSegment, PointerInput.Origin.viewport(), p.x, p.y));
        }

        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((Interactive) drv).perform(Collections.singletonList(seq));
    }

    public boolean checkExpectedShape() {
        return expectedSquareScreenshot.isElementPresent(TimeConstant.SMALL_TIMEOUT);
    }
}
