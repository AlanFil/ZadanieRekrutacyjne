package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KnowledgeBasePage {
    WebDriver driver;

    @FindBy(xpath="//a[contains(text(), \"Documentation\")]")
    WebElement documentationBookmark;

    @FindBy(xpath = "//a[contains(text(), \"XTM Manual\")]")
    WebElement xtmManualFile;

    public KnowledgeBasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getDocumentationBookmark(){
        /* it's easier to get link from element rather than click that element because
           of ElementNotInteractableException exception */
        this.driver.get(documentationBookmark.getAttribute("href"));
    }

    public String downloadXTMManualFile(){
        List<String> linkSplit = List.of(xtmManualFile.getAttribute("href").split("/"));
        String fileName = linkSplit.get(linkSplit.size() - 1);

        // There is an "onclick" action that performs download operation
        xtmManualFile.click();
        return fileName;
    }
}
