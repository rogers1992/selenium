import java.security.SecureRandom;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TaskPractice6 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		List <WebElement> options = driver.findElements(By.xpath("//div[@id='checkbox-example']//label"));
		String optionSelected = null;
		String optionText = null;
		//Generating random option
		int upperBound = options.size();
		SecureRandom generateOption = new SecureRandom();
		String randomOption = String.valueOf(generateOption.nextInt(1, upperBound));
		
		int countInput = 0;
		for(WebElement option : options) 
		{
			String text = option.getText();
			countInput ++;
			if(text.indexOf(randomOption) != -1) 
			{
				optionText = option.getText();
				break;
			}
		}
		optionSelected = "//div[@id='checkbox-example']//label[" + countInput + "]//input";
		driver.findElement(By.xpath(optionSelected)).click();
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(optionText);
		
		driver.findElement(By.id("name")).sendKeys(optionText);
		driver.findElement(By.id("confirmbtn")).click();
	}

}
