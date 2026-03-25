import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addToCart {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		additeams(driver);
		
		driver.findElement(By.xpath("//img[@alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@class=\"promoCode\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class=\"promoBtn\"]")).click();
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		driver.findElement(By.xpath("//option[text()='Select']")).click();
		
	}
	
	public static void additeams(WebDriver driver ) {
		String[] items = {"Brocolli", "Beans","Mushroom"}; 
		List<WebElement> products = driver.findElements(By.className("product-name"));
		
		for(int i=0; i < products.size(); i++) {
			String[] product = products.get(i).getText().split("-");
			String productname = product[0].trim();
			List itemsneed = Arrays.asList(items); // converting array into list as we wand to compare value in productname with items  
			
			if(itemsneed.contains(productname)) {
				
				driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
			}
		}
	}
}
