package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
    public WebDriver driver;

    @BeforeTest
    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        driver.navigate().to("https://selenium1py.pythonanywhere.com/en-gb/");
        //driver.get("https://selenium1py.pythonanywhere.com/en-gb/");
    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver.quit();
    }
}
