package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookPagePage extends BasePage {
    public BookPagePage(WebDriver givenDriver) {
        super(givenDriver);
    }

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

    public void enterFieldValue(String text,By locator) {

        WebElement enterField = waitUntilClickable(locator);
        enterField.click();
        enterField.clear();
        enterField.sendKeys(text);
    }

    public WebElement waitUntilClickable(By element) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
