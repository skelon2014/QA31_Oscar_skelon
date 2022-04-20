package tests.home_page;

import helpers.PageActionHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test
    public void changeLanguageTest() {
        String lang = "ru";
        String expTextBasketButton = "Посмотреть корзину";
        String expTextGoButton = "Выполнить";
        homePage.selectLanguage(lang);
        homePage.clickOnGoButton();
        Assert.assertEquals(homePage.getTextFromGoButton(), expTextGoButton, "Texts are differents!!!");
        Assert.assertEquals(homePage.getTextFromBasketButton(), expTextBasketButton, "Texts are differents!!!");
    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "readingDataFromFile")
    public void changeLanguageTestDataProvider(String lang, String expTextGoButton) {
       // String lang = "ru";
       // String expTextGoButton = "Выполнить";
        homePage.selectLanguage(lang);
        homePage.clickOnGoButton();
        Assert.assertEquals(homePage.getTextFromGoButton(), expTextGoButton, "Texts are differents!!!");
    }
}
