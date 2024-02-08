package Tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;


public class SwitchWindowExamples extends BaseTest {
@Test
    void switchWindow() {

        String window1 = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        Set<String> openWindows = driver.getWindowHandles();
        String window2 = null;
        for (String win : openWindows) {
            if (!win.equals(window1)) {
                window2 = win;
                break;
            }
        }
        driver.switchTo().window(window2);
        driver.get(url);
    Assert.assertEquals(driver.getCurrentUrl(),"https://quicklyn.com/");
    System.out.println(driver.getCurrentUrl()+ "  https://quicklyn.com/ ");
    }
}