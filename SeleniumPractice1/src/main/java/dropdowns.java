import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdowns {

    // Constants (avoids hardcoding)
    private static final String URL = "https://www.spicejet.com/";
    private static final int EXPECTED_ADULT_COUNT = 5;

    public static void main(String[] args) {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        try {
            // Step 1: Open passenger dropdown
            openPassengerDropdown(driver);

            // Step 2: Select required number of adults
            selectNumberOfAdults(driver, EXPECTED_ADULT_COUNT);

            // Step 3: Validate selected count
            validateAdultCount(driver, EXPECTED_ADULT_COUNT);

        } finally {
            // Close browser
            driver.quit();
        }
    }

    // Method to open passenger dropdown
    public static void openPassengerDropdown(WebDriver driver) {
        driver.findElement(By.xpath("//div[text()='1 Adult']")).click();
    }

    // Method to increment adult count dynamically
    public static void selectNumberOfAdults(WebDriver driver, int targetCount) {

        int currentCount = 1;

        while (currentCount < targetCount) {
            driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
            currentCount++;
        }
    }
    // Method to validate selected adult count
    public static void validateAdultCount(WebDriver driver, int expectedCount) {

        String actualText = driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText();
        String expectedText = expectedCount + " Adults";

        if (actualText.equals(expectedText)) {
            System.out.println("Validation Passed: " + actualText);
        } else {
            System.out.println("Validation Failed");
            System.out.println("Expected: " + expectedText);
            System.out.println("Actual: " + actualText);
        }
    }
}