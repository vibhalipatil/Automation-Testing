import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowhandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); // Get all window handles
        Iterator<String> it = windows.iterator();   // Create Iterator
        String parentid = it.next();// First window = Parent
        String childid = it.next();     // Second window = Child
        driver.switchTo().window(childid);   //tell selenium to switch to child window
        // System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String email= (driver.findElement(By.cssSelector(".im-para.red")).getText()).split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(parentid);
        driver.findElement(By.xpath("//*[@id=\"username\"] ")).sendKeys(email);
		
	}

}
