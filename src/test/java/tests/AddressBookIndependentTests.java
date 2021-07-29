package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.io.File;

import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)

public class AddressBookIndependentTests {

    private static final String PICTURE = new File("src/main/resources/LA_foto.jpg").getAbsolutePath();

    private WebDriver driver = Driver.getChromeDriver();

   @BeforeEach
   void SetUp(){
       driver.get("http://a.testaddressbook.com/sign_in");
       String currentURL = driver.getCurrentUrl();
       Assertions.assertEquals("http://a.testaddressbook.com/sign_in", currentURL, "The incorrect page is open or invalid URL is specified");
   }
    @AfterEach
    void tearDown() {
        driver.quit();

    }

    @Order(1)
    @Test
    @DisplayName("Testing of Login page")
    void Login() {
        driver.findElement(By.id("session_email")).sendKeys("www@www.qqq");
        driver.findElement(By.name("session[password]")).sendKeys("123QWE");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        String title = driver.getTitle();
        Assertions.assertEquals("Address Book", title, "The incorrect page is open or invalid title is specified");

    }


    @Order(2)
    @Test
    @DisplayName("Testing of adding address")
    void AddAddress() {

        driver.findElement(By.id("session_email")).sendKeys("www@www.qqq");
        driver.findElement(By.name("session[password]")).sendKeys("123QWE");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();

        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();
        driver.findElement(By.cssSelector("a[data-test='create']")).click();
        driver.findElement(By.name("address[first_name]")).sendKeys("Rodger");
        driver.findElement(By.name("address[last_name]")).sendKeys("Federer");
        driver.findElement(By.id("address_street_address")).sendKeys("zxc 11");
        driver.findElement(By.id("address_secondary_address")).sendKeys("qwe 33");
        driver.findElement(By.id("address_city")).sendKeys("LA");

        Select drpCountry = new Select(driver.findElement(By.name("address[state]")));
        drpCountry.selectByIndex(4);

        driver.findElement(By.id("address_zip_code")).sendKeys("345987");

        WebElement radioUS = driver.findElement(By.xpath("//input[@value='us']"));
        radioUS.click();

        driver.findElement(By.id("address_birthday")).sendKeys("09091999");
        driver.findElement(By.id("address_color")).sendKeys("#FFFF00");
        driver.findElement(By.id("address_age")).sendKeys("30");
        driver.findElement(By.id("address_website")).sendKeys("http://www.eee.eu");
        driver.findElement(By.id("address_picture")).sendKeys(PICTURE);
        driver.findElement(By.id("address_phone")).sendKeys("8098765432");
        driver.findElement(By.xpath("//input[@id='address_interest_climb']")).click();
        driver.findElement(By.id("address_note")).sendKeys("home address");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        WebElement success = driver.findElement(By.cssSelector(".alert.alert-notice"));
        String elementTitle = success.getText();
        Assertions.assertTrue("Address was successfully created.".contains(elementTitle));
    }


    @Order(3)
    @Test
    @DisplayName("Testing of editing address")
    void EditAddress() {
        driver.findElement(By.id("session_email")).sendKeys("www@www.qqq");
        driver.findElement(By.name("session[password]")).sendKeys("123QWE");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();

        List<WebElement> listOfElements = driver.findElements(By.xpath("//a[text()='Edit']"));

        if (listOfElements.size() >= 1) {
            listOfElements.get(listOfElements.size()-1).click();
        } else {
            System.out.println("There are no addresses in the tests.AddressBook");
        }


        driver.findElement(By.xpath("//a[text()='Edit'][1]")).click();
        driver.findElement(By.id("address_city")).clear();
        driver.findElement(By.id("address_city")).sendKeys("New York");
        Select drpCountry2 = new Select(driver.findElement(By.name("address[state]")));
        drpCountry2.selectByVisibleText("New York");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        WebElement success = driver.findElement(By.cssSelector(".alert.alert-notice"));
        String elementTitle = success.getText();
        Assertions.assertTrue("Address was successfully updated.".contains(elementTitle));
    }

    @Order(4)
    @Test
    @DisplayName("Testing of deleting an address")
    void DeleteAddress() {
    driver.findElement(By.id("session_email")).sendKeys("www@www.qqq");
        driver.findElement(By.name("session[password]")).sendKeys("123QWE");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();


        List<WebElement> listOfElements = driver.findElements(By.xpath("//a[text()='Destroy']"));

        if (listOfElements.size() >= 1) {
            listOfElements.get(listOfElements.size()-1).click();
        } else {
            System.out.println("There are no addresses in the tests.AddressBook");
        }
        driver.switchTo().alert().accept();

        WebElement success = driver.findElement(By.cssSelector(".alert.alert-notice"));
        String elementTitle = success.getText();
        Assertions.assertTrue("Address was successfully destroyed.".contains(elementTitle));
    }

    @Order(5)
    @Test
    @DisplayName("Testing of Sign out")
   // @Disabled
    void SignOut() {
         driver.findElement(By.id("session_email")).sendKeys("www@www.qqq");
        driver.findElement(By.name("session[password]")).sendKeys("123QWE");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();

        driver.findElement(By.xpath("//a[text()='Sign out']")).click();
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/sign_in", currentURL, "The incorrect page is open or invalid URL is specified");

    }
}
