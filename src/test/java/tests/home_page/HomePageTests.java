package tests.home_page;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.TestBase;

import static helpers.APIHelper.thisIsStaticMethod;

public class HomePageTests extends TestBase {
    HomePage homePage;

    @BeforeMethod
    public void initTest() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void homePageValidationTest() {
        Assert.assertTrue(homePage.homeLinkIsVisible(), "Home Link is invisible");
    }


}
