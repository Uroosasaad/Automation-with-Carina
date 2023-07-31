package com.solvd.qa.carina.demo.gui.carinaweb.pages.commons;

import com.solvd.qa.carina.demo.gui.carinaweb.components.navigation.CarinaNavigationPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CarinaHomePageBase extends AbstractPage {


    public CarinaHomePageBase(WebDriver driver) {
        super(driver);
    }
}
