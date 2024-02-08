package Tests;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeepCleaningPage extends BaseTest {
 @Test                                           //li[id="menu-item-1335"]  //h1[@class='page-title'][contains(text(),"Deep Cleaning")]
public void choseCleaningService() throws InterruptedException {

     By cleanOption = By.id("menu-item-1335");
     By clean1 = By.cssSelector("li[id ='menu-item-1336']");
     By clean2 = By.xpath("//h1[contains(text(),'Best Deep Cleaning')]");

     WebElement serviceClean =  wait.until(ExpectedConditions
             .visibilityOfElementLocated(cleanOption));

     Thread.sleep(1000);
     new Actions(driver)
             .moveToElement(serviceClean)
             .perform();
  //  Thread.sleep(1000);
    WebElement deepClean = wait.until(ExpectedConditions.visibilityOfElementLocated(clean1));
     deepClean.click();
   //   Select deepClean = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(clean1)));
  //   deepClean.selectByVisibleText("Deep Cleaning");
     WebElement deepCleanOption = wait.until(ExpectedConditions.visibilityOfElementLocated(clean2));
     String deepCleanText = deepCleanOption.getText();
    String textToCompare = deepCleanText.substring(0,18);
     System.out.println(deepCleanText.substring(0,18));
     String deepCleanSiteText = "Best Deep Cleaning";

     Assert.assertEquals(textToCompare,deepCleanSiteText);


 }

}
