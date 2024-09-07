import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		WebElement sourceComponentToDrag = driver.findElement(By.id("draggable"));
		sourceComponentToDrag.click();
		
		WebElement targetComponentToDrop = driver.findElement(By.id("droppable"));
		Actions dropElement = new Actions(driver);
		dropElement.dragAndDrop(sourceComponentToDrag, targetComponentToDrop).build().perform();
		driver.switchTo().defaultContent();

	}

}
