import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesTaskPractice5 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		//Switch to Top frame component
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
		//Switch to Middle frame component
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
		String textToPrint = driver.findElement(By.id("content")).getText();
		System.out.println(textToPrint);
		

	}

}
