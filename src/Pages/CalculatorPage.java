package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
    WebDriver driver;

    @FindBy(xpath = "//iframe[@class=\"pricing-iframe\"]")
    WebElement calculatorSubpage;


    public CalculatorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getCalculatorSubpage(){
        String calculatorSubpageLink = calculatorSubpage.getAttribute("src");
        this.driver.get(calculatorSubpageLink);
    }




}

