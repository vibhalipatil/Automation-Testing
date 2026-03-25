import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class dropdowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[text()='1 Adult']")).click();
		int i=1;
		while(i<5) {
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		i++;
		}
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText(), "5 Adults");
	}
}
