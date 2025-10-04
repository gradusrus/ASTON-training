package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() { driver.get("https://www.mts.by/"); }

    public void acceptCookiesIfPresent() {
        By[] locs = {
                By.xpath("//button[contains(.,'Принять') or contains(.,'Согласен')]"),
                By.cssSelector(".cookie button")
        };
        for (By l : locs) {
            for (WebElement e : driver.findElements(l)) {
                if (e.isDisplayed()) { try { e.click(); return; } catch (Exception ignored) {} }
            }
        }
    }

    public String getOnlinePaymentBlockTitle() {
        By[] locs = {
                By.xpath("//h2[contains(.,'Онлайн пополнение')]"),
                By.xpath("//*[contains(text(),'Онлайн пополнение') and contains(text(),'без комиссии')]")
        };
        for (By l : locs) for (WebElement e : driver.findElements(l)) if (e.isDisplayed()) return e.getText();
        return "";
    }

    public boolean paymentLogosPresent() {
        By l = By.xpath("//img[contains(@src,'visa') or contains(@src,'master') or contains(@src,'mir')]");
        return driver.findElements(l).stream().anyMatch(WebElement::isDisplayed);
    }

    public boolean clickMoreAboutService() {
        By l = By.linkText("Подробнее о сервисе");
        for (WebElement e : driver.findElements(l)) {
            if (e.isDisplayed()) { e.click(); return true; }
        }
        return false;
    }

    public void selectConnectionTab() {
        By l = By.xpath("//button[contains(.,'Услуги связи')]");
        for (WebElement e : driver.findElements(l)) {
            if (e.isDisplayed()) { try { e.click(); return; } catch (Exception ex) { new Actions(driver).moveToElement(e).click().perform(); return; } }
        }
    }

    public void fillMobilePaymentForm(String phone) {
        selectConnectionTab();
        By l = By.cssSelector("form#pay-connection input[type='tel']");
        for (WebElement e : driver.findElements(l)) {
            if (e.isDisplayed()) { e.clear(); e.sendKeys(phone); return; }
        }
    }

    public void clickContinueButton() {
        By l = By.xpath("//form[contains(@id,'pay')]//button[contains(.,'Продолжить')]");
        for (WebElement e : driver.findElements(l)) {
            if (e.isDisplayed()) { wait.until(ExpectedConditions.elementToBeClickable(e)).click(); return; }
        }
    }

    public String getValidationHintsForVariant(String variant) {
        try {
            By tab = By.xpath("//button[contains(.,'" + variant + "')]");
            for (WebElement t : driver.findElements(tab)) if (t.isDisplayed()) { t.click(); break; }
        } catch (Exception ignored) {}
        StringBuilder sb = new StringBuilder();
        By inputs = By.xpath("//form[contains(@id,'pay')]//input[@placeholder]");
        for (WebElement e : driver.findElements(inputs)) {
            if (sb.length() > 0) sb.append(" | ");
            sb.append(e.getAttribute("placeholder"));
        }
        return sb.toString();
    }
}
