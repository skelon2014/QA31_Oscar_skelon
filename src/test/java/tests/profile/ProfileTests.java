package tests.profile;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegisterPage;
import pages.ProfilePage;
import tests.TestBase;

public class ProfileTests extends TestBase {
    HomePage homePage;
    LoginAndRegisterPage loginAndRegisterPage;
    ProfilePage profilePage;
    String email = "skelon+1@bk.ru";
    String password = "Durdom2@14";

    @BeforeMethod
    public void initTest() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginAndRegisterPage = PageFactory.initElements(driver, LoginAndRegisterPage.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
    }
    @Test
    public void changePasswordPositive(){
        String p1 = "Durdom2@14";
        String p2 = "Durdom2@144";
        homePage.login(email,password);
        loginAndRegisterPage.clickOnAccountButtom();
        Assert.assertTrue(profilePage.profileMessageIsVisible());
        profilePage.clickOnChangePasswordButton();
        profilePage.changePassword(p1,p2);
        Assert.assertTrue(profilePage.passwordUpdates());


    }


}
