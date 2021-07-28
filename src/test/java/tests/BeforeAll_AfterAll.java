package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class BeforeAll_AfterAll {
    protected WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
     void SetUp(){
        driver.get("http://a.testaddressbook.com/sign_in");
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/sign_in", currentURL, "The incorrect page is open or invalid URL is specified");
    }

    @AfterAll
    void tearDown() {
        driver.quit();

    }

    @AfterEach
    void afterEach(TestInfo testInfo) {
        if (testInfo.getTags().contains("SkipClick")) {
            return;
        }
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();
    }
}
