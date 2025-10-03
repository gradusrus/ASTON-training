import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PaymentPage;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTests {
    private WebDriver driver;
    private PaymentPage paymentPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        paymentPage = new PaymentPage(driver);
    }

    @Test
    void testBlockTitle() {
        String title = paymentPage.getBlockTitle();
        assertTrue(title.contains("Онлайн пополнение без комиссии"),
                "Заголовок блока не соответствует ожидаемому");
    }

    @Test
    void testPaymentLogosDisplayed() {
        assertFalse(paymentPage.getPaymentLogos().isEmpty(),
                "Логотипы платёжных систем не найдены");
    }

    @Test
    void testMoreInfoLink() {
        paymentPage.clickMoreInfo();
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("help/poryadok-oplaty"),
                "Ссылка 'Подробнее о сервисе' не ведет на правильную страницу");
    }

    @Test
    void testFormSubmission() {
        paymentPage.fillForm("297777777", "1", "test@test.com");
        paymentPage.clickContinue();

        assertTrue(paymentPage.isModalVisible(), "Модальное окно не появилось");
        assertTrue(paymentPage.getModalAmount().contains("1.00 BYN"),
                "Сумма отображается некорректно");
        assertTrue(paymentPage.getModalPhone().contains("375297777777"),
                "Номер телефона отображается некорректно");
        assertTrue(paymentPage.areCardFieldsPresent(),
                "Не все поля для реквизитов карты присутствуют");
        assertFalse(paymentPage.getModalPaymentLogos().isEmpty(),
                "В модальном окне нет логотипов платёжных систем");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
