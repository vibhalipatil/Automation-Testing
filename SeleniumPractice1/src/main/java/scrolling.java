import java.util.List;

import javax.print.attribute.SetOfIntegerSyntax;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class scrolling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver; // This line make driver awer that it can execute javascript
		js.executeScript("window.scrollBy(0,700)");   // browser scroll down
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");   //Scroll table present on the webpage.
		
		List <WebElement> values =  driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int Sum = 0;
		for(int i=0; i<values.size();i++) {
			Sum = Sum +  Integer.parseInt(values.get(i).getText());
			}
		
		System.out.print(Sum);
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(Sum, total);
	}

}
