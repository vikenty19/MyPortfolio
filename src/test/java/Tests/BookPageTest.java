package Tests;

import Pages.BookPagePage;
import Pages.MakePaymentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class BookPageTest extends BaseTest {
    //first name [data-code="first_name"]
//Last name  [data-id='2']
    //mail [data-id="3"]
    //phone [data-id="4"] input
    //book now //input[@value="Book Now"]
    //red frame css input.ng-pristine
    //[name = 'booking[state]'] combobox States
    // [data-id= '5']>input      address
        //[data-id= '6']>input        city
    // [data-id= '8']>input           zipCode
    @Test
    public void registrationSuccessTest() throws InterruptedException {


By firstN = By.cssSelector("input[name='booking[first_name]']");
By lastN = By.cssSelector("[data-id='2'] input");
By mailCSS = By.cssSelector("[data-id='3'] input");
By phoneCSS = By.cssSelector("[data-id='4'] input");
By submit = By.cssSelector("[data-name = 'Submit Button']");
By iframeXpath = By.xpath("//iframe[@data-lazyloaded = '1']");
By stateCss = By.cssSelector("[name = 'booking[state]']");
By addressCss = By.cssSelector("[data-id= '5']>input ");
By cityCss = By.cssSelector("[data-id= '6']>input");
By zipCss = By.cssSelector("[data-id= '8']>input");
By subEmail = By.cssSelector(".mc-field-group>[type='email']");
By subId = By.cssSelector("input[type = 'submit']");
By denyXpath = By.xpath("//div[text()='Please enter a valid email address.']");
       By dataCss = By.cssSelector("[data-id= '181']>input");
 //       By dataCss = By.id("dp1706116425190");
        By monthCss = By.xpath("//span[@class ='ui-datepicker-month']");


       JavascriptExecutor js = (JavascriptExecutor)driver;
        MakePaymentPage makePaymentPage = new MakePaymentPage(driver);
        BookPagePage bookPage = new BookPagePage(driver);
        makePaymentPage.clickBookPage();
        System.out.println("Before");
        Thread.sleep(3000);


        makePaymentPage.switchToMainIframe();
        Thread.sleep(1000);
        //First Name
        bookPage.enterFieldValue("John",firstN);

        //last name
        bookPage.enterFieldValue("Dou",lastN);
        //email
        bookPage.enterFieldValue("<@gmail.co",mailCSS);

        //phone number
        bookPage.enterFieldValue("346-75-234-44",phoneCSS);

         // Address of order
        bookPage.enterFieldValue("Oriental blvd",addressCss);

      //  System.out.println(address.getText());
        //Enter city
        bookPage.enterFieldValue("Brooklyn",cityCss);

      //Enter ZipCode
        bookPage.enterFieldValue("12345",zipCss);


        WebElement statesDrop = wait.until(ExpectedConditions
                .elementToBeClickable(stateCss));
     //   statesDrop.click();
        Select drpStates = new Select(statesDrop);
         drpStates.selectByVisibleText("NY");
         statesDrop.click();
   //        String textCheck =
    //    statesDrop.getText();
     //   System.out.println(textCheck);

        //click Submit
        WebElement submitBtn =  wait.until(ExpectedConditions
                .visibilityOfElementLocated(submit));
        submitBtn.click();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
       WebElement subscribeEmail = wait.until(ExpectedConditions
               .elementToBeClickable(subEmail));
        js.executeScript("arguments[0].scrollIntoView(true);", subscribeEmail);
       subscribeEmail.click();
        subscribeEmail.clear();
        subscribeEmail.sendKeys("<@gmail.co");

        WebElement subscribe  = driver.findElement(subId);
        subscribe.click();
        WebElement subscriptionDeny = driver.findElement(denyXpath);
        String warning = subscriptionDeny.getText();
        System.out.println(warning);
        Assert.assertEquals(warning,"Please enter a valid email address.");


    }


}
