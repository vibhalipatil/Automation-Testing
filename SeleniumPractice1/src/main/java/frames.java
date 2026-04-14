import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frames {
	
	private static final String URL = "https://jqueryui.com/droppable/";
	private static final By Frame = By.className("demo-frame");
	private static final By dragf = By.id("draggable");
	private static final By dropf = By.id("droppable");
	
	//Initialize browser
	 private static WebDriver initializeDriver() {
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        return driver;
	    }
	 // Open URL
	private static void openURL(WebDriver driver) {
		driver.get(URL);
	}
	 // Switch to iframe
	 private static void switchToFrame(WebDriver driver) {
	        WebElement frame = driver.findElement(Frame);
	        driver.switchTo().frame(frame);
	    }
	  // 🔹 Perform drag and drop
	    private static void performDragAndDrop(WebDriver driver) {
	        Actions actions = new Actions(driver);

	        WebElement drag = driver.findElement(dragf);
	        WebElement drop = driver.findElement(dropf);

	        actions.dragAndDrop(drag, drop).perform();
	    }
	    // Close browser
	    private static void tearDown(WebDriver driver) {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	public static void main(String[] args) {
		
		 WebDriver driver = initializeDriver();
	        try {
	        	openURL(driver);
	            switchToFrame(driver);
	            performDragAndDrop(driver);
	        } finally {
	            tearDown(driver);
	        }
	}

}
