package Tests;

import Common.AccountType;
import Common.Currency;
import Pages.CalculatorPage;
import Pages.CalculatorSubpage;
import Pages.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test01 {
    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\libs\\chromedriver_93.0.4577.63.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test()
    public void testCalculateEnterprise7Users3Months() throws InterruptedException {
        String expectedPriceInGBP = "£1,650.00";
        String expectedPriceInEUR = "€1,214.10";
        String expectedPriceInUSD = "$1,533.60";
        String errorInExpectedPrice = "Price should be equal to ";

        MainPage mainPage = new MainPage(driver);
        mainPage.getCalculatorPage();

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.getCalculatorSubpage();

        CalculatorSubpage calculatorSubpage = new CalculatorSubpage(driver);
        calculatorSubpage.selectAccountType(AccountType.ENTERPRISE);
        calculatorSubpage.selectUserCount(7);
        calculatorSubpage.selectSubscriptionLength(3);

        Assert.assertEquals(calculatorSubpage.checkCost(Currency.GBP), expectedPriceInGBP, errorInExpectedPrice+expectedPriceInGBP);
        Assert.assertEquals(calculatorSubpage.checkCost(Currency.EUR), expectedPriceInEUR, errorInExpectedPrice+expectedPriceInEUR);
        Assert.assertEquals(calculatorSubpage.checkCost(Currency.USD), expectedPriceInUSD, errorInExpectedPrice+expectedPriceInUSD);
    }

    @After
    public void tearDown() {
        this.driver.close();
    }
}
