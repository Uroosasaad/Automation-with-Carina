package com.solvd.qa.carina.demo.gui.carinaweb.components.footer;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CarinaFooterMenu extends AbstractUIObject {

    @FindBy(xpath = "//div[contains(@class,'md-footer-copyright__highlight')]")
    private ExtendedWebElement CopyRightElementOfFooter;

    public CarinaFooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean ScrollDownToFooterMenu() {
        CopyRightElementOfFooter.scrollTo();
        return true;
    }

}
