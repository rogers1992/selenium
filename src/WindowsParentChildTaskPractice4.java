import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsParentChildTaskPractice4 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.cssSelector("[class='example'] a")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parentID = iterator.next();
		String childID = iterator.next();
		
		driver.switchTo().window(childID);
		String childWindowText = driver.findElement(By.cssSelector("[class='example'] h3")).getText();
		System.out.println(childWindowText);
		driver.switchTo().window(parentID);
		String parentWindowText = driver.findElement(By.cssSelector("[class='example'] h3")).getText();
		System.out.println(parentWindowText);
		
		
		

	}

}
