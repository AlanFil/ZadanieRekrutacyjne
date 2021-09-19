package Tests;

import Pages.KnowledgeBasePage;
import Pages.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Test02 {
    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\libs\\chromedriver_93.0.4577.63.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test()
    public void testDownloadXTMManual() throws InterruptedException {
        String downloadPath = System.getProperty("user.home") + "\\Downloads\\";
        String downloadedFileName;
        File downloadFileObject;

        MainPage mainPage = new MainPage(driver);
        mainPage.getKnowledgeBasePage();

        KnowledgeBasePage knowledgeBasePage = new KnowledgeBasePage(driver);
        knowledgeBasePage.getDocumentationBookmark();
        downloadedFileName = knowledgeBasePage.downloadXTMManualFile();
        downloadFileObject = new File(downloadPath + downloadedFileName);

        waitForTheFileToDownload(downloadFileObject);

        Assert.assertTrue("File doesn't exist in Downloads folder", downloadFileObject.exists());
    }

    private void waitForTheFileToDownload(File downloadFileObject) throws InterruptedException {
        for (int i = 0; i <= 60; i++) {
            if (!downloadFileObject.exists())
                TimeUnit.SECONDS.sleep(1);
            else break;
        }
    }

    @After
    public void tearDown() {
        this.driver.close();
    }
}
