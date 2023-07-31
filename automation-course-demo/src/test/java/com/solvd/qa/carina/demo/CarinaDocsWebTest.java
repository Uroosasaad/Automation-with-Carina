package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.gui.carinaweb.pages.CarinaHomePage;
import com.zebrunner.carina.core.IAbstractTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarinaDocsWebTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarinaDocsWebTest.class);

    private CarinaHomePage OpenCarinaPage() {
        CarinaHomePage homePage = new CarinaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Carina Home page is not opened");
        return  homePage;
    }
    @Test
    public void testIfClickingOnParentRevealsChildElements() {
        Assert.assertTrue(OpenCarinaPage().getNavigationPage().ClickOnParentRevealsChildElements(),"Clicking On Parent Does Not Reveals Child Element");
    }
    @Test
    public void testIfCarinaIsFirstElementInNavigation() {
        Assert.assertTrue(OpenCarinaPage().getNavigationPage().checkIfCarinaHeadingIsFirstElement(),"Carina Tag is not the first element in navigation menu");
    }

    @Test
    public void testIfSelectedLinkIsHighlighted() {
        Assert.assertTrue(OpenCarinaPage().getNavigationPage().checkCurrentPageLinkHighlighted(),"Currently selected page is not highlighted");
    }

    @Test
    public void testIfZebrunnerLogoIsPresent() {
        Assert.assertTrue(OpenCarinaPage().getHeader().checkIfLogoExists(),"Logo does not exist");
    }

    @Test
    public void testIfClickingOnLogoRedirectsToSamePage() {
        Assert.assertTrue(OpenCarinaPage().getHeader().clickOnZebrunnerLogo(),"Redirects to different page");
    }

    @Test
    public void testIfSearchComponentIsPresentInHeader() {
        Assert.assertTrue(OpenCarinaPage().getHeader().CheckSearchComponentOnHeader(),"Search component not present");
    }

    @Test
    public void testIfGitHubLinkIsPresent() {
        Assert.assertTrue(OpenCarinaPage().getHeader().getGitHubLink(),"Git hub section not present");
    }

    @Test
    public void testIfClickOnLinkTakeToCarinaGitHubPage() {
        Assert.assertTrue(OpenCarinaPage().getHeader().checkIfLinkRedirectsToGitHubLink(),"GitHub link does not point to carina github page");
    }

    @Test
    public void testIfTitlePresentOnHeader() {
        Assert.assertTrue(OpenCarinaPage().getHeader().checkIfCarinaTitlePresentOnHeader(), "Carina title is not present on header");
    }

    @Test
    public void testIfHeaderSticksOnTopOfPage() {
        CarinaHomePage homePage = OpenCarinaPage();
        boolean isPageScrolled = homePage.getFooterMenu().ScrollDownToFooterMenu();
        boolean isHeaderPresent = homePage.checkIfHeaderAttachedToTopOfPage();
        Assert.assertTrue(isPageScrolled && isHeaderPresent, "Header is not attached to top of the page");
    }
    @Test
    public void testIfNavigationElementsLinkPresent() {
        Assert.assertTrue(OpenCarinaPage().getNavigationPage().checkIfListOfNavigationLinkPresent(), "List of navigation menu does not exist!");
    }

    @Test
    public void testIfSomeElementsAreHiddenInNavMenu(){
        Assert.assertTrue(OpenCarinaPage().getNavigationPage().CheckIfSomeElementsAreHidden(), "All Elements Are Visible ");
    }

}
