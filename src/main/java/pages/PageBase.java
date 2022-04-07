package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    protected WebDriver driver;
    int timeWaitElement = 30;

    public PageBase(WebDriver driver){
        this.driver=driver;
    }

    public void uploadFile(WebElement element, String filePath){
        waitUntilElementClickable(element, timeWaitElement);
        inputText(element, filePath);
    }

    private void inputText(WebElement element, String text) {
        waitUntilElementClickable(element, timeWaitElement);
        element.click();
        element.clear();
        element.sendKeys(text);

    }

    private void waitUntilElementClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
