import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MtsByTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterAll
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private WebElement getPaymentBlock() {
        driver.get("https://www.mts.by/");
        try {
            WebElement cookieBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            cookieBtn.click();
        } catch (Exception ignored) {}

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1200)");

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.pay")));
    }

    @Test
    void testBlockTitle() {
        WebElement block = getPaymentBlock();
        WebElement title = block.findElement(By.tagName("h2"));
        String text = title.getText().replace("\n", " ").trim();
        assertEquals("Онлайн пополнение без комиссии", text,
                "Заголовок блока неверный");
    }

    @Test
    void testPaymentLogos() {
        WebElement block = getPaymentBlock();
        WebElement partners = block.findElement(By.cssSelector("div.pay__partners"));
        List<WebElement> logos = partners.findElements(By.tagName("img"));
        assertTrue(logos.size() >= 4, "Логотипы платёжных систем не найдены");
        boolean hasVisa = logos.stream().anyMatch(e -> e.getAttribute("src").toLowerCase().contains("visa"));
        boolean hasMastercard = logos.stream().anyMatch(e -> e.getAttribute("src").toLowerCase().contains("mastercard"));
        boolean hasBelkart = logos.stream().anyMatch(e -> e.getAttribute("src").toLowerCase().contains("belkart"));
        assertTrue(hasVisa && hasMastercard && hasBelkart, "Не все логотипы платёжных систем найдены");
    }

    @Test
    void testMoreInfoLink() {
        WebElement block = getPaymentBlock();
        WebElement link = block.findElement(By.linkText("Подробнее о сервисе"));
        String oldUrl = driver.getCurrentUrl();
        link.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));
        assertNotEquals(oldUrl, driver.getCurrentUrl(), "Ссылка не сработала");
    }

    @Test
    void testFormSubmission() {
        WebElement block = getPaymentBlock();

        WebElement phoneField = block.findElement(By.id("connection-phone"));
        phoneField.sendKeys("297777777");

        WebElement amountField = block.findElement(By.id("connection-sum"));
        amountField.sendKeys("1");

        WebElement emailField = block.findElement(By.id("connection-email"));
        emailField.sendKeys("test@test.com");

        WebElement continueBtn = block.findElement(By.xpath(".//button[contains(text(),'Продолжить')]"));
        continueBtn.click();

        boolean somethingHappened = false;
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            shortWait.until(ExpectedConditions.or(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe")),
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector(".modal")),
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error"))
            ));
            somethingHappened = true;
        } catch (Exception ignored) {}

        assertTrue(somethingHappened, "После нажатия 'Продолжить' ничего не произошло");
    }
}
