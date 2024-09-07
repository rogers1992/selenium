package introduction.streamsregularexpretions;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
public class SortTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all webelements in list
		
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all WebElements into new original List 
		
		List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the original List of Step 3 -> sorted list
		
		List<String> SortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(SortedList));
		
		//Scan the name column with getText  - find Rice product and print the price
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s))
			.collect(Collectors.toList());
			
			price.forEach(a->System.out.println(a));
			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).click();
				
			}
		}
		while(price.size() < 1);
			
		
	}

	private static String getPriceVeggie(WebElement s) {
		
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return price;
	}

}
