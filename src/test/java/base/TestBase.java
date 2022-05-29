package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        driver = new ChromeDriver();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}