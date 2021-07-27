package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
}
