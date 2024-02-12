package StepDefinition;

import Pages.MakePaymentPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceOrderStepDefinitions {
   public static WebDriver driver = null;
   public static String url = "https://quicklyn.com/";
   ;
   public static WebDriverWait wait = null;

   @Before

    public void openBrowser(){
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      options.addArguments("--disable-notifications");
      options.addArguments("--start-maximized");
      driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
      driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
      driver.manage().timeouts().getScriptTimeout();
      wait = new WebDriverWait(driver, Duration.ofSeconds(20));

      By closeAdd = By.xpath("//img[@alt = 'Close']");
      WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(closeAdd));
      close.click();

   }

   @After
   public void closeBrowser(){
       driver.quit();
   }
      @Given("I open url")
           public void iOpenUrl(){
    driver.get(url);
}

   @When("I switch to the book page")
   public void iSwitchToTheBookPage() {
       MakePaymentPage makePaymentPage = new MakePaymentPage(driver);
       makePaymentPage.clickBookPage();
   }

   @And("I enter my name")
   public void iEnterMyName() {
       MakePaymentPage makePaymentPage = new MakePaymentPage(driver);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       makePaymentPage.switchToMainIframe();
       makePaymentPage.enterTheUserName(js);

   }

   @And("I enter my last name")
   public void iEnterMyLastName() {
       MakePaymentPage makePaymentPage = new MakePaymentPage(driver);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       makePaymentPage.switchToMainIframe();
       makePaymentPage.enterTheUserName(js);
   }

   @And("I enter my address")
   public void iEnterMyAddress() {
       MakePaymentPage makePaymentPage = new MakePaymentPage(driver);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       makePaymentPage.enterZipCode(js);
   }

   @And("I click submit button")
   public void iClickSubmitButton() {
       MakePaymentPage makePaymentPage = new MakePaymentPage(driver);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       //driver.switchTo().parentFrame();
       makePaymentPage.clickSubmitBtn();
   }

   @Then("I placed the order")
   public void iPlacedTheOrder() {
       MakePaymentPage makePaymentPage = new MakePaymentPage(driver);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       driver.switchTo().defaultContent();
       makePaymentPage.switchToMainIframe();
       makePaymentPage.isAlertDisplayed();
       System.out.println("You made a reservation successfully ");
   }
}
