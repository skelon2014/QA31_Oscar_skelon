package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        driver.navigate().to("https://selenium1py.pythonanywhere.com/en-gb/");
        //driver.get("https://selenium1py.pythonanywhere.com/en-gb/");
    }
    @AfterMethod
    public void teardown(){
        driver.close();
        driver.quit();
    }
}
