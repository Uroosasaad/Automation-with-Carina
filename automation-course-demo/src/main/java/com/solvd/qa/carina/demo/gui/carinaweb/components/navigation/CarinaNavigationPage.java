package com.solvd.qa.carina.demo.gui.carinaweb.components.navigation;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarinaNavigationPage extends AbstractUIObject {

    @FindBy(xpath = "//nav[@aria-label='Navigation']//label[@for='__drawer']")
    private ExtendedWebElement firstHeadingInCarinaNavigation;

    @FindBy(xpath = "//ul[@class='md-nav__list']//li")
    List<ExtendedWebElement> NavigationLinkElementList;

    @FindBy(xpath = "//div[@class='md-content']//h1")
    private ExtendedWebElement currentlySelectedPageHeading;

    @FindBy(xpath = "//a[@class='md-nav__link md-nav__link--active']")
    private ExtendedWebElement currentlyHighlightedPageLink;

    @FindBy(xpath = "//li[contains(@class,'md-nav__item md-nav__item--nested')]")
    private List <ExtendedWebElement> ParentNavElements;

    @FindBy(xpath = "//li[@class='md-nav__item md-nav__item--nested']//li")
    List<ExtendedWebElement> ChildNavElements;

    @FindBy(xpath = "//li[contains(@class, 'md-nav__item')]")
    List<ExtendedWebElement> NavigationList;

    public CarinaNavigationPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public void clickMigrationGuideLink() {
//        for(ExtendedWebElement webElement : NavigationElements) {
//            if (webElement.getText().equalsIgnoreCase("Migration Guide")) {
//                webElement.click();
//                break;
//            }
//        }
    }

    public boolean checkIfCarinaHeadingIsFirstElement() {
        return firstHeadingInCarinaNavigation.getText().equals(("Carina"));
    }

    public boolean checkIfListOfNavigationLinkPresent() {
        for (ExtendedWebElement webElement : NavigationLinkElementList) {
            if (webElement.isElementPresent()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCurrentPageLinkHighlighted() {
         return currentlySelectedPageHeading.getText().equalsIgnoreCase(currentlyHighlightedPageLink.getText());
    }

    public boolean ClickOnParentRevealsChildElements() {
        for(ExtendedWebElement element: ParentNavElements) {
            element.click();
//            for(ExtendedWebElement childElement : ChildNavElements) {
//                if(!childElement.isElementPresent()) {
//                    return false;
//                }
//            }
        }
        return true ;
    }

    public boolean CheckIfSomeElementsAreHidden() {
        for (ExtendedWebElement element : NavigationList) {
            if (!element.isElementPresent()) {
                return false;

            }
        }
        return true;
    }
}
