package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BeforeAll_AfterAll{


    public void getLogin(){
        driver.findElement(By.id("session_email")).sendKeys("www@www.qqq");
        driver.findElement(By.name("session[password]")).sendKeys("123QWE");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
    }

    @Test
    @Tag("SkipClick")
    @DisplayName("Testing of Login page")
    public void Login() {
        driver.findElement(By.id("session_email")).sendKeys("www@www.qqq");
        driver.findElement(By.name("session[password]")).sendKeys("123QWE");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        getLogin();
        String title = driver.getTitle();
        Assertions.assertEquals("Address Book", title, "The incorrect page is open or invalid title is specified");
    }
}
