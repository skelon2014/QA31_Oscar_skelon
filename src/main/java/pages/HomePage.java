package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(.,'Oscar')]")
    WebElement homePageLink;
    @FindBy(id = "login_link")
    WebElement loginAndRegisterButton;
    //  @FindBy(xpath = "//div[@class='alertinner wicon']")
    @FindBy(css = ".alertinner.wicon")
    WebElement registerSuccessMessage;


    public boolean homeLinkIsVisible() {
        return homePageLink.isDisplayed();
    }

    public void clickToLoginAndRegisterButton() {
        loginAndRegisterButton.click();
    }

    public boolean registerSuccessMessageIsDisplayed() {
        waitUntilElementVisible(registerSuccessMessage, 30);
        return registerSuccessMessage.isDisplayed();
    }
}
