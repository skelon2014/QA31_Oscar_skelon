package helpers;

import ch.qos.logback.core.util.FileUtil;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PageActionHelper {
    public static String takeScreenShot(WebDriver webdriver) throws IOException {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Create new file name
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String curDate = formatter.format(date);
        String filePath = "ScreenShots/screen-" + curDate + ".png";

        //Move image file to new destination
        File DestFile=new File(filePath);

        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        return filePath;

    }

    public static String onException(WebDriver driver) {
        //   logger.error("ERROR!!! TEST FAILED!!!\n", throwable);

        long number = System.currentTimeMillis() / 1000;
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String pathName = "ScreenShots/screen-" + number + ".png";
        File screenshot = new File(pathName);
        try {
            Files.copy(file, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }return pathName;
    }
}