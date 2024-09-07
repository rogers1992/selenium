import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class TaskPractice8 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		String country = "United Kingdom (UK)";
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(6))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		List<WebElement> listSuggestions = wait.until(new Function<WebDriver, List<WebElement>>() {
			
			public List<WebElement> apply(WebDriver driver) 
			{
				if(driver.findElement(By.xpath("//ul[@id='ui-id-1']")).isDisplayed()) 
				{
					return driver.findElements(By.xpath("//li[@class='ui-menu-item']//div"));
				}
				else 
				{
					return null;
					
				}
			}
		});
		//List<WebElement> suggestions = driver.findElements(By.xpath("//li[@class='ui-menu-item']//div"));
		
		for(WebElement suggest : listSuggestions) 
		{
			if(suggest.getText().equalsIgnoreCase(country)) 
			{
				suggest.click();
				break;
			}
		}		
	}

}
