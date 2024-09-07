import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskPractice7 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//count table rows quantity
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table-display']//tbody //tr"));
		int countRowTable = 0;
		
		for(WebElement row : rows) 
		{
			countRowTable ++;
		}
		System.out.println(countRowTable);
		//count Table columns quantity
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class='table-display']//tbody //th"));
		int countColumnTable = 0;
		for(WebElement column : columns) 
		{
			countColumnTable ++;
		}
		System.out.println(countColumnTable);
	}

}
