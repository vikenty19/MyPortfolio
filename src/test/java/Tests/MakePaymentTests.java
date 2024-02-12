package Tests;

import Pages.MakePaymentPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class MakePaymentTests extends BaseTest {

    @Test(invocationCount = 1, successPercentage = 75)
    public void paymentDataTest() throws InterruptedException {
        MakePaymentPage makePaymentPage = new MakePaymentPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        makePaymentPage.clickBookPage();
    //  Thread.sleep(3000);
        makePaymentPage.switchToMainIframe();
        makePaymentPage.enterTheUserName(js);
        makePaymentPage.enterZipCode(js);
        makePaymentPage.switchToCardEnterIframe();
        makePaymentPage.enterCardNumber();

        driver.switchTo().parentFrame();

        makePaymentPage.pickTheMonth();
        driver.switchTo().parentFrame()
        ;
        makePaymentPage.pickTheYear();
        driver.switchTo().parentFrame();

        makePaymentPage.enterCvvCode();
        driver.switchTo().parentFrame();

        makePaymentPage.clickSubmitBtn();
        driver.switchTo().defaultContent();
        makePaymentPage.switchToMainIframe();
        //Assertion
        makePaymentPage.isAlertDisplayed();
        System.out.println("You made a reservation successfully ");


// inside fridge #extra-66 div img      ------//.inside-the-fridge >.ng-scope  // in checking get text ==.shadow-border.summary-panel .extra-summary-title
// final price .shadow-border.summary-panel [data-id='103'] .final-price-value

//alert locator div.alert-danger
    }


    @Test(invocationCount = 3)
    public void addInsideFridgeService() throws InterruptedException {
        MakePaymentPage makePaymentPage = new MakePaymentPage(driver);
        makePaymentPage.clickBookPage();
        makePaymentPage.switchToMainIframe();
        makePaymentPage.clickInsideFridgeService();
        makePaymentPage.isFridgeAddedToBooking();


    }


}
