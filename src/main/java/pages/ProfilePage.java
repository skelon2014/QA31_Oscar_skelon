package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProfilePage extends PageBase{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[normalize-space()='Profile']")
    WebElement profile;
    @FindBy(xpath = "//a[normalize-space()='Change password']")
    WebElement changePassword;

    public boolean profileMessageIsVisible() {
        return profile.isDisplayed();
    }

    public void clickOnChangePasswordButton() {
       changePassword.click();
    }

    public void changePassword(String p1, String p2) {
        inputText(driver.findElement(By.cssSelector("#id_old_password")), p1);
        inputText(driver.findElement(By.cssSelector("#id_new_password1")),p2 );
        inputText(driver.findElement(By.cssSelector("#id_new_password2")),p2 );
        click(driver.findElement(By.xpath("//button[.='Save']")));
        clickOnChangePasswordButton();
        inputText(driver.findElement(By.cssSelector("#id_old_password")), p2);
        inputText(driver.findElement(By.cssSelector("#id_new_password1")),p1 );
        inputText(driver.findElement(By.cssSelector("#id_new_password2")),p1 );
        click(driver.findElement(By.xpath("//button[.='Save']")));
    }

    public boolean passwordUpdates() {
        return driver.findElement(By.xpath("//div[@class='alertinner wicon']")).isDisplayed();
    }
}
