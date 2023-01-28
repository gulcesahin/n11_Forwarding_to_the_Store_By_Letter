package com.n11.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class Commons {

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }
}