import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class autodropdowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//handle check box
		//Assert method to check weather output is expected  or not
		Assert.assertFalse((driver.findElement(By.xpath(" //input[contains(@id,'IndArm')]")).isSelected()));
		//System.out.println(driver.findElement(By.xpath(" //input[contains(@id,'IndArm')]")).isSelected());   // use to validate is checkbox is selected or not
		driver.findElement(By.xpath(" //input[contains(@id,'IndArm')]")).click(); // Use to click on the checkbox.
		System.out.println(driver.findElement(By.xpath(" //input[contains(@id,'IndArm')]")).isSelected());
		
		//handle auto drop down
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(1000);
		List <WebElement> a =  driver.findElements(By.xpath("//li[@class=\"ui-menu-item\"]"));
		for (WebElement b : a) {
			if (b.getText().equalsIgnoreCase("India")){
				b.click();
				break;
			}
		}
		
	}

}
