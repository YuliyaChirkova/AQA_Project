import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class AddressBook {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "http://a.testaddressbook.com/sign_in";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get(url);

        //Login

        driver.findElement(By.id("session_email")).sendKeys("www@www.qqq");
        driver.findElement(By.name("session[password]")).sendKeys("123QWE");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();

        // Add address

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
        driver.findElement(By.id("address_age")).sendKeys("30");
        driver.findElement(By.id("address_website")).sendKeys("http://www.eee.eu");
        driver.findElement(By.id("address_picture")).sendKeys("D:\\LA_foto.jpg");
        driver.findElement(By.id("address_phone")).sendKeys("8098765432");
        driver.findElement(By.xpath("//input[@id='address_interest_climb']")).click();
        driver.findElement(By.id("address_note")).sendKeys("home address");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();

    // Edit address

        driver.findElement(By.xpath("//a[text()='Edit'][1]")).click();
        driver.findElement(By.id("address_city")).clear();
        driver.findElement(By.id("address_city")).sendKeys("New York");
        Select drpCountry2 = new Select(driver.findElement(By.name("address[state]")));
        drpCountry2.selectByVisibleText("New York");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();

   // Delete address

        List<WebElement> listOfElements = driver.findElements(By.xpath("//a[text()='Destroy']"));

       if(listOfElements.size()>=1){
            listOfElements.get(0).click();
        }else{
            System.out.println("There are no addresses in the AddressBook");
        }
        driver.switchTo().alert().accept();

       //Sign out
        driver.findElement(By.xpath("//a[text()='Sign out']")).click();


        driver.close();
        driver.quit();

    }
}
