import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsByTests {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("http://mts.by");
        driver.findElement(By.id("cookie-agree")).click();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testBlockName() {
        WebElement block = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div"));
        String blockName = block.findElement(By.tagName("h2")).getText();
        assertEquals("Онлайн пополнение\nбез комиссии", blockName);
    }

    @Test
    public void testPaymentSystemLogos() {
        WebElement block = driver.findElement(By.xpath("//div[@class='pay__partners']"));
        List<WebElement> logos = block.findElements(By.xpath(".//img[not(@style='hidden')]"));
        assertTrue(logos.size() > 0, "Payment system logos are not present");
    }

    @Test
    public void testMoreInfoLink() {
        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreInfoLink.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    public void testContinueButton() {
        WebElement block = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div"));

        WebElement serviceTypeDropdown = block.findElement(By.className("select__wrapper"));
        String option = serviceTypeDropdown.getText();
        assertEquals("Услуги связи", option);

        WebElement phoneNumberInput = block.findElement(By.id("connection-phone"));
        phoneNumberInput.sendKeys("297777777");

        WebElement continueButton = block.findElement(By.className("button__default"));
        continueButton.click();
    }
}
