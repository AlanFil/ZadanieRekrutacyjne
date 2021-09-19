package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;
    String pageLink = "https://xtm.cloud/";

    @FindBy(xpath="//a[contains(@href, \"#calculator\")]")
    WebElement calculatorPagePath;

    @FindBy(xpath="//a[contains(@href, \"knowledge-base\")]")
    WebElement getKnowledgeBasePagePath;


    public MainPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(pageLink);
        PageFactory.initElements(driver, this);
    }

    public void getCalculatorPage(){
        // it's easier to get link from element rather than expand list and click that element
        this.driver.get(this.calculatorPagePath.getAttribute("href"));
    }

    public void getKnowledgeBasePage(){
        // it's easier to get link from element rather than expand list and click that element
        this.driver.get(this.getKnowledgeBasePagePath.getAttribute("href"));
    }

}
