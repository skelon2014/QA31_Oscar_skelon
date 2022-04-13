package tests.user;


import helpers.DataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegisterPage;
import tests.TestBase;

import static helpers.DataHelper.randomNumeric;
import static pages.PageBase.generateRandomEmail;

public class RegistrationTests extends TestBase {
    HomePage homePage;
    LoginAndRegisterPage loginAndRegisterPage;
   // DataHelper dataHelper;

   // String email = dataHelper.generateRandomEmail(10);
   // String email = "skelon3@bk.ru";
    String password = "Durdom2@14";
    String email = "skelon"+randomNumeric(3)+"@bk.ru";

    @BeforeMethod
    public void initTest() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginAndRegisterPage = PageFactory.initElements(driver, LoginAndRegisterPage.class);
    }

    @Test
    public void registrationPositiveTest()  {
        homePage.clickToLoginAndRegisterButton();
        Assert.assertTrue(loginAndRegisterPage.loginAndRegistrationFormIsOpened());
        loginAndRegisterPage.fillEmailField(email);
        loginAndRegisterPage.fillPasswordField(password);
        loginAndRegisterPage.fillConfirmPasswordField(password);
        loginAndRegisterPage.clickOnRegisterButton();
        Assert.assertTrue(homePage.registerSuccessMessageIsDisplayed());
    }
}
