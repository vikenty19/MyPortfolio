package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MakePaymentPage extends BasePage {
    public MakePaymentPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By bookXml = By.cssSelector("li[id='menu-item-122']");
    By name = By.cssSelector("#NameOnAccount");
    By zip = By.name("BillingZipCode");
    By iframeXpath = By.xpath("//iframe[@data-lazyloaded ='1']");

    By iframe1id = By.id("fullsteam-hosted-card-number-frame");
    By cardCss = By.cssSelector("[name='CardNumber']");
    By iframe2id = By.id("fullsteam-hosted-expiration-month-frame");
    By choseMonth = By.cssSelector("select#expiration-month");
    By month = By.cssSelector("select#expiration-month option:nth-child(5)");
    By iframe3id = By.id("fullsteam-hosted-expiration-year-frame");
    By choseYear = By.cssSelector("select#expiration-year option:nth-child(6)");
    By year = By.cssSelector("select#expiration-year option:nth-child(3)");

    public void clickBookPage() {
        WebElement bookNowBtn = wait.until(ExpectedConditions.elementToBeClickable(bookXml));
        bookNowBtn.click();
    }

    public void switchToCardEnterIframe() {
        WebElement iframe1 = wait.until(ExpectedConditions
                .visibilityOfElementLocated(iframe1id));
        driver.switchTo().frame(iframe1);
    }

    public void switchToMainIframe() throws InterruptedException {
        WebElement iframe = wait.until(ExpectedConditions
                .visibilityOfElementLocated(iframeXpath));
        driver.switchTo().frame(iframe);
 ;
    }
    public void enterCardNumber() {
        WebElement cardNumb = wait.until(ExpectedConditions
                .visibilityOfElementLocated(cardCss));
        cardNumb.click();
        cardNumb.clear();
        cardNumb.sendKeys("1234 5678 3456 2345");
    }
    public void enterTheUserName(JavascriptExecutor js) {
        WebElement nameOfAccount = wait.until(ExpectedConditions
                .elementToBeClickable(name));
        js.executeScript("arguments[0].scrollIntoView(true);", nameOfAccount);
        js.executeScript("arguments[0].click();", nameOfAccount);
        nameOfAccount.clear();
        nameOfAccount.sendKeys("USER1");
    }
    public void enterZipCode(JavascriptExecutor js) {
        WebElement zipCode = wait.until(ExpectedConditions
                .elementToBeClickable(zip));
        js.executeScript("arguments[0].click();", zipCode);
        zipCode.sendKeys("12345");
    }
}
