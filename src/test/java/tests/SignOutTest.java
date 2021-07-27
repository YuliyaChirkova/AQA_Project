package tests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignOutTest extends BeforeAll_AfterAll{


   @Test
   @Order(1)
   public void Login() {
       driver.findElement(By.id("session_email")).sendKeys("www@www.qqq");
       driver.findElement(By.name("session[password]")).sendKeys("123QWE");
       driver.findElement(By.cssSelector("input[value='Sign in']")).click();
       String title = driver.getTitle();
       Assertions.assertEquals("Address Book", title, "The incorrect page is open or invalid title is specified");
   }

    @Test
    @Order(2)
    void SignOut() {
       /* LoginTest login = new LoginTest();
        login.getLogin();*/
        driver.findElement(By.xpath("//a[text()='Sign out']")).click();
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/sign_in", currentURL, "The incorrect page is open or invalid URL is specified");
    }
}



