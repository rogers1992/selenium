import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverBoundariesLinksTabsManage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		
		WebElement columnDriverElement = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int sizeColumnDrier = columnDriverElement.findElements(By.tagName("a")).size();
		System.out.println(sizeColumnDrier);
		
		// 4 click  on each link in the columns and check if the pages are opening
		for(int i = 1; i<sizeColumnDrier; i++) 
		{
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			//separateTabs
			columnDriverElement.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(5000L);
			
		}
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> itTabs = tabs.iterator();
		
		while(itTabs.hasNext())
		{
			driver.switchTo().window(itTabs.next());
			System.out.println(driver.getTitle()); 
		}
		

	}

}
