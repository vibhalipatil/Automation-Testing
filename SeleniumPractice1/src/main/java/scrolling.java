import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class scrolling {

    // Constants
    private static final String URL = "https://rahulshettyacademy.com/AutomationPractice/";
    private static final By TABLE_VALUES = By.cssSelector(".tableFixHead td:nth-child(4)");
    private static final By TOTAL_AMOUNT = By.cssSelector(".totalAmount");

    // Initialize Driver
    private static WebDriver initializeDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
    // Open URL
    private static void openApplication(WebDriver driver) {
        driver.get(URL);
    }
    //  Scroll whole page
    private static void scrollPage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
    }
    // Scroll inside table
    private static void scrollTable(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
    }
    //Calculate sum of table column
    private static int calculateTableSum(WebDriver driver) {
        List<WebElement> values = driver.findElements(TABLE_VALUES);
        int sum = 0;

        for (WebElement value : values) {
            sum += Integer.parseInt(value.getText());
        }

        System.out.println("Calculated Sum: " + sum);
        return sum;
    }
    // Get displayed total
    private static int getDisplayedTotal(WebDriver driver) {
        String text = driver.findElement(TOTAL_AMOUNT).getText();
        int total = Integer.parseInt(text.split(":")[1].trim());
        System.out.println("Displayed Total: " + total);
        return total;
    }
    // Validation
    private static void validateSum(int actual, int expected) {
        Assert.assertEquals(actual, expected, "Sum validation failed!");
        System.out.println("Validation Passed ✅");
    }
    // Tear Down
    private static void tearDown(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
    public static void main(String[] args) {

        WebDriver driver = initializeDriver();

        try {
            openApplication(driver);
            scrollPage(driver);
            scrollTable(driver);

            int calculatedSum = calculateTableSum(driver);
            int expectedTotal = getDisplayedTotal(driver);

            validateSum(calculatedSum, expectedTotal);

        } finally {
            tearDown(driver);
        }
    }
}
