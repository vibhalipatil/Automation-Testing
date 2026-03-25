import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frames {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		//move selenium focus to frame from webpage
		WebElement framen = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(framen);
		
		Actions a = new Actions(driver);
		WebElement dragf = driver.findElement(By.id("draggable"));
		WebElement dropf = driver.findElement(By.id("droppable"));
		a.dragAndDrop(dragf, dropf).build().perform();
	}

}
