package Tests;

import Pages.MakePaymentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MakePaymentClass extends BaseTest {


 By name = By.cssSelector("#NameOnAccount");
 By zip = By.name("BillingZipCode");
 By iframeXpath = By.xpath("//iframe[@data-lazyloaded = '1']");
 //By iframe1id = By.id("fullsteam-hosted-card-number-frame");
 By cardCss = By.cssSelector("[name='CardNumber']");
 By iframe2id = By.id("fullsteam-hosted-expiration-month-frame");
 By choseMonth = By.cssSelector("select#expiration-month");
 By month = By.cssSelector("select#expiration-month option:nth-child(5)");
 By iframe3id = By.id("fullsteam-hosted-expiration-year-frame");
 By choseYear = By.cssSelector("select#expiration-year option:nth-child(6)");
 By year = By.cssSelector("select#expiration-year option:nth-child(3)");
 By iframe4id = By.cssSelector("#fullsteam-hosted-cvv-frame");
 By cvvLocator = By.cssSelector("input#cvv");
 By sbmtLocator = By.cssSelector("[data-name='Submit Button']");
 By alertLocator = By.xpath("//div/p[contains(text(),'Enter Address')]");


    @Test(invocationCount = 4,successPercentage = 75)
    public void paymentDataTest() throws InterruptedException {
        MakePaymentPage makePaymentPage = new MakePaymentPage(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;

        makePaymentPage.clickBookPage();
          Thread.sleep(3000);
         makePaymentPage.switchToMainIframe();


        //Enter tne name of account
        makePaymentPage.enterTheUserName(js);

        //     Thread.sleep(1000);
        //Enter Zipcode
        makePaymentPage.enterZipCode(js);

        //Enter card number
       makePaymentPage.switchToCardEnterIframe();
       makePaymentPage.enterCardNumber();
       
        driver.switchTo().parentFrame();
      
     //Enter the month
     WebElement iframe2 = wait.until(ExpectedConditions
             .visibilityOfElementLocated(iframe2id));
     driver.switchTo().frame(iframe2);
     WebElement pickMonthField = wait.until(ExpectedConditions
             .elementToBeClickable(choseMonth));
     pickMonthField.click();
     WebElement monthPicker = wait.until(ExpectedConditions
             .elementToBeClickable(month));
     monthPicker.click();

        driver.switchTo().parentFrame();


        // Enter the year
        WebElement iframe3 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(iframe3id));
        driver.switchTo().frame(iframe3);
        WebElement pickYearField = wait.until(ExpectedConditions
                .elementToBeClickable(choseYear));
        pickYearField.click();
        WebElement yearPicker = wait.until(ExpectedConditions
                .elementToBeClickable(year));
        yearPicker.click();
        driver.switchTo().parentFrame();

        //Enter cvv
        driver.switchTo().frame(wait.until((ExpectedConditions
                .visibilityOfElementLocated(iframe4id))));
       WebElement cvv= wait.until(ExpectedConditions.elementToBeClickable(cvvLocator));
        cvv.click();
        cvv.sendKeys("345");
        //Submit
        driver.switchTo().parentFrame();
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(sbmtLocator));
        submitBtn.click();
        driver.switchTo().defaultContent();
        makePaymentPage.switchToMainIframe();
        //Assertion
        WebElement alertBanner = wait.until(ExpectedConditions
                .visibilityOfElementLocated(alertLocator));
        Assert.assertTrue(alertBanner.isDisplayed());
        System.out.println("You made a reservation successfully ");


// inside fridge #extra-66 div img
// final price .shadow-border.summary-panel [data-id='103'] .final-price-value

//alert locator div.alert-danger
    }




}
