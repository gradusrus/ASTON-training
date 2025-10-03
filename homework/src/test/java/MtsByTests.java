import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsByTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Обработчик окна cookies (если появится)
    private void acceptCookiesIfPresent() {
        try {
            WebElement cookieBtn = wait.withTimeout(Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Принять')]")));
            cookieBtn.click();
        } catch (TimeoutException ignored) {
        }
    }

    @Test
    @DisplayName("Проверка заголовка блока 'Онлайн пополнение без комиссии'")
    void testBlockTitle() {
        driver.get("https://www.mts.by/");
        acceptCookiesIfPresent();

        WebElement blockTitle = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//section[@class='pay']//h2")));


        assertTrue(blockTitle.getText().replace("\n", " ")
                        .contains("Онлайн пополнение без комиссии"),
                "Заголовок блока не совпадает");
    }

    @Test
    @DisplayName("Проверка наличия логотипов платёжных систем")
    void testPaymentLogos() {
        driver.get("https://www.mts.by/");
        acceptCookiesIfPresent();

        WebElement logosBlock = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='pay__partners']")));

        List<WebElement> logos = logosBlock.findElements(By.tagName("img"));
        assertFalse(logos.isEmpty(), "Логотипы не найдены");

        boolean hasVisa = logos.stream().anyMatch(l -> l.getAttribute("src").toLowerCase().contains("visa"));
        boolean hasMastercard = logos.stream().anyMatch(l -> l.getAttribute("src").toLowerCase().contains("mastercard"));
        boolean hasBelkart = logos.stream().anyMatch(l -> l.getAttribute("src").toLowerCase().contains("belkart"));

        assertTrue(hasVisa, "Нет логотипа Visa");
        assertTrue(hasMastercard, "Нет логотипа MasterCard");
        assertTrue(hasBelkart, "Нет логотипа Белкарт");
    }

    @Test
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    void testMoreLink() {
        driver.get("https://www.mts.by/");
        acceptCookiesIfPresent();

        WebElement moreLink = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//section[@class='pay']//a[contains(text(),'Подробнее о сервисе')]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", moreLink);
        moreLink.click();

        // Проверяем, что URL содержит раздел help
        wait.until(ExpectedConditions.urlContains("/help/"));
        assertTrue(driver.getCurrentUrl().contains("/help/"),
                "Ссылка ведет не на страницу помощи");
    }
}