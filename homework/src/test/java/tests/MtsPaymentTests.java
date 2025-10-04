package tests;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.*;

public class MtsPaymentTests extends BaseTest {
    private MainPage main;

    @BeforeEach
    public void initPages() { main = new MainPage(driver); }

    @Test
    public void testOnlinePaymentBlock() {
        main.open(); main.acceptCookiesIfPresent();
        assertTrue(main.getOnlinePaymentBlockTitle().toLowerCase().contains("онлайн пополнение"));
    }

    @Test
    public void testPaymentLogos() {
        main.open(); main.acceptCookiesIfPresent();
        assertTrue(main.paymentLogosPresent());
    }

    @Test
    public void testMoreAboutServiceLink() {
        main.open(); main.acceptCookiesIfPresent();
        assertTrue(main.clickMoreAboutService());
    }

    @Test
    public void testPaymentFormConnection() {
        main.open(); main.acceptCookiesIfPresent();
        main.fillMobilePaymentForm("297777777");
        main.clickContinueButton();
        assertTrue(driver.getPageSource().toLowerCase().contains("оплат"), "Ожидается контент оплаты");
    }

    @Test
    public void testValidationPlaceholdersForVariants() {
        main.open(); main.acceptCookiesIfPresent();
        String[] variants = {"Услуги связи","Домашний интернет","Рассрочка","Задолженность"};
        for (String v : variants) assertFalse(main.getValidationHintsForVariant(v).isEmpty());
    }
}
