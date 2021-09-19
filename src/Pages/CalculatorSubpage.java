package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CalculatorSubpage {
    WebDriver driver;

    @FindBy(xpath = "//span[contains(@id, \"select2-accountType\")]")
    WebElement accountTypeWindow;

    @FindBy(xpath = "//span[contains(@id, \"select2-numberOfUsers\")]")
    WebElement numberOfUsersWindow;

    @FindBy(xpath = "//span[contains(@id, \"select2-subscriptionLength\")]")
    WebElement subscriptionLengthWindow;

    @FindBy(xpath = "//span[contains(@id, \"select2-numberOfWords\")]")
    WebElement numberOfWordsWindow;

    @FindBy(xpath = "//ul[contains(@class, \"select2-results\")]")
    WebElement windowResults;

    @FindBy(xpath = "//div[@id=\"newSubscription-account-pricing\"]")
    WebElement currencyRadio;

    @FindBy(xpath = "//div[@class=\"total-cost\"]//span")
    WebElement totalCost;


    public CalculatorSubpage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void selectAccountType(String accountType){
        String accountTypeChosen = String.format("./li[contains(text(), \"%s\")]", accountType);
        accountTypeWindow.click();
        windowResults.findElement(By.xpath(accountTypeChosen)).click();
    }

    public void selectUserCount(int userCount){
        String numberOfUsersChosen = String.format("./li[contains(text(), \"%d\")]", userCount);
        numberOfUsersWindow.click();
        windowResults.findElement(By.xpath(numberOfUsersChosen)).click();
    }

    public void selectSubscriptionLength(int subscriptionLength){
        String subscriptionLengthChosen = String.format("./li[contains(text(), \"%d\")]", subscriptionLength);
        subscriptionLengthWindow.click();
        windowResults.findElement(By.xpath(subscriptionLengthChosen)).click();
    }

    public String checkCost(String currency) throws InterruptedException {
        String currencyRadioChosen = String.format("//label[@for=\"%s\"]", currency);
        currencyRadio.findElement(By.xpath(currencyRadioChosen)).click();

        // wait for string to appear for 60 seconds
        for (int i = 0; i <= 60; i++) {
            if (Objects.equals(totalCost.getText().strip(), ""))
                TimeUnit.SECONDS.sleep(1);
            else break;
        }

        return totalCost.getText().strip();
    }
}
