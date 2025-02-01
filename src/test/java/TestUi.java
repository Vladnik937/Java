import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUi {
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void checkSubmitTitleTest() {
        driver.get(BASE_URL);
        driver.findElement(By.linkText("Web form")).click();
        driver.findElement(By.id("my-text-id")).sendKeys("Test");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        WebElement submitTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals("Form submitted", submitTitle.getText());
    }
}
