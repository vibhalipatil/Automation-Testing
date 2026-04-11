import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calenderradiobutton {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Click Round Trip FIRST
		wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//div[contains(text(),'round trip')]"))).click();

		// FROM
		driver.findElement(By.xpath("//div[text()='From']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//div[contains(text(),'Agra')]"))).click();

		// TO
		wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//div[contains(text(),'Delhi')]"))).click();

		// DEPARTURE DATE (first calendar click)
		wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("(//div[@data-testid='undefined-calendar-day-5'])[1]"))).click();
		// DEPARTURE date
		driver.findElement(By.xpath("//div[text()='11']")).click();
		
		//return date
		driver.findElement(By.xpath("//div[text()='14']")).click();
		
		//Search Button
		driver.findElement(By.xpath("//div[contains(text(),'Search Flight')]/parent::div")).click();
		
	}

}
