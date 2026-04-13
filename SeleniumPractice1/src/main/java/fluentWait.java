import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluentWait {

    private static final String URL = "https://the-internet.herokuapp.com/dynamic_loading/1";
    private static final By START_BUTTON = By.cssSelector("#start button");
    private static final By FINISH_TEXT = By.cssSelector("#finish h4");

    public static void main(String[] args) {

        // Initialize browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        try {
            // Click Start button
            clickStartButton(driver);

            // Wait for text using Fluent Wait
            WebElement result = waitForElementUsingFluentWait(driver);

            //  Print result
            printResult(result);

        } finally {
            // Close browser
            driver.quit();
        }
    }

    // Method to click Start button
    public static void clickStartButton(WebDriver driver) {
        driver.findElement(START_BUTTON).click();
    }

    // Method to apply Fluent Wait and get element
    public static WebElement waitForElementUsingFluentWait(WebDriver driver) {

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))     // max wait time
                .pollingEvery(Duration.ofSeconds(3))     // check every 3 seconds
                .ignoring(NoSuchElementException.class); // ignore exception

        return wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {

                WebElement element = driver.findElement(FINISH_TEXT);

                // Return element only if visible
                if (element.isDisplayed()) {
                    return element;
                }
                return null; // keep waiting
            }
        });
    }

    // Method to print result
    public static void printResult(WebElement element) {
        System.out.println("✅ Loaded Text: " + element.getText());
    }
}