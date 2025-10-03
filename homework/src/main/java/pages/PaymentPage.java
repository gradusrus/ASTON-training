package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ==== Локаторы ====
    private By blockTitle = By.xpath("//section[@class='pay']//h2");
    private By paymentLogos = By.cssSelector("div.pay__partners img");
    private By moreInfoLink = By.xpath("//a[contains(text(),'Подробнее о сервисе')]");
    private By continueButton = By.xpath("//button[contains(text(),'Продолжить')]");

    // поля формы
    private By serviceTypeDropdown = By.xpath("//select[@id='pay-select']");
    private By phoneInput = By.xpath("//input[@placeholder='Номер телефона']");
    private By sumInput = By.xpath("//input[@placeholder='Сумма']");
    private By emailInput = By.xpath("//input[@placeholder='E-mail для отправки чека']");

    // модальное окно оплаты
    private By modalWindow = By.cssSelector("div.payment-page__container");
    private By modalAmountText = By.xpath("//div[contains(text(),'BYN')]");
    private By modalPhoneText = By.xpath("//div[contains(text(),'Номер')]");
    private By cardNumberInput = By.xpath("//input[@placeholder='Номер карты']");
    private By cardDateInput = By.xpath("//input[@placeholder='Срок действия']");
    private By cardCvcInput = By.xpath("//input[@placeholder='CVC']");
    private By cardNameInput = By.xpath("//input[@placeholder='Имя и фамилия на карте']");
    private By modalLogos = By.cssSelector("app-card-page img");

    // ==== Методы ====

    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }

    public List<WebElement> getPaymentLogos() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentLogos));
    }

    public void clickMoreInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink)).click();
    }

    public void fillForm(String phone, String sum, String email) {
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(sumInput).sendKeys(sum);
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public boolean isModalVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(modalWindow)).isDisplayed();
    }

    public String getModalAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(modalAmountText)).getText();
    }

    public String getModalPhone() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(modalPhoneText)).getText();
    }

    public boolean areCardFieldsPresent() {
        return driver.findElement(cardNumberInput).isDisplayed()
                && driver.findElement(cardDateInput).isDisplayed()
                && driver.findElement(cardCvcInput).isDisplayed()
                && driver.findElement(cardNameInput).isDisplayed();
    }

    public List<WebElement> getModalPaymentLogos() {
        return driver.findElements(modalLogos);
    }
}
