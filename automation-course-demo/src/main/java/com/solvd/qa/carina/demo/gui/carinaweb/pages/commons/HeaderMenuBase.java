package com.solvd.qa.carina.demo.gui.carinaweb.pages.commons;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HeaderMenuBase extends AbstractPage {
    public HeaderMenuBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }
}
