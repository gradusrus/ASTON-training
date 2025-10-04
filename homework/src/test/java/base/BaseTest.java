package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown(org.junit.jupiter.api.TestInfo testInfo) {
        if (driver != null) {
            try {
                String base = "target/test-dumps/" + testInfo.getDisplayName().replaceAll("[^a-zA-Z0-9._-]", "_")
                        + "/" + DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now());
                Path dir = Path.of(base);
                Files.createDirectories(dir);
                Files.writeString(dir.resolve("page.html"), driver.getPageSource());
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Files.copy(src.toPath(), dir.resolve("screenshot.png"));
            } catch (Exception ignored) {}
            driver.quit();
        }
    }
}
