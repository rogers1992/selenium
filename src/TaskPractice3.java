import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TaskPractice3 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(4));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");	
		login(driver, eWait);
		shoppingProducts(driver, eWait);
		

	}
	public static void login(WebDriver driver, WebDriverWait eWait) 
	{
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//div[@class='form-check-inline']//label[2]")).click();
		eWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button#okayBtn")));
		driver.findElement(By.cssSelector("button#okayBtn")).click();
		
		WebElement rolesDropdown = driver.findElement(By.xpath("//div[@class='form-group']//select"));
		
		/*for(WebElement role : roles) 
		{
			if (role.getText().equalsIgnoreCase("Consultant")) 
			{
				role.click();
				break;
			}
			
		}*/
		
		
		Select roles = new Select(rolesDropdown);
		roles.selectByVisibleText("Consultant");
		
		driver.findElement(By.xpath("//div[@class='form-group']//label[@for='terms']/span")).click();
		driver.findElement(By.cssSelector("input#signInBtn")).click();
	}
	public static void shoppingProducts(WebDriver driver, WebDriverWait eWait) 
	{
		eWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='card-footer']//button")));
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='card-footer']//button"));
		for(WebElement product : allProducts) 
		{
			product.click();		
		}
		driver.findElement(By.xpath("//li[@class='nav-item active']")).click();
	}

}
