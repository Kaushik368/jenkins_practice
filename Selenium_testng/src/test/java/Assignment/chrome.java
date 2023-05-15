package Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chrome {
	WebDriver driver;
	
	@BeforeTest
	public void pre() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	@Test(enabled=false)
	public void tc1() {
		String url="https://www.google.com/";
		driver.get(url);
		driver.manage().window().maximize();
		Actions actions=new Actions(driver);
		
		WebElement Locator=driver.findElement(By.xpath("(//a[normalize-space()='Gmail'])[1]"));
		
		actions.contextClick(Locator).sendKeys(Keys.ARROW_DOWN).build().perform();

        // Switch to new tab
        String newTab = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(newTab);
		
	}
	@Test(enabled=false)
	public void tc2() {
		String url="https://www.google.com/";
		driver.get(url);
		driver.manage().window().maximize();
		Actions actions=new Actions(driver);
		
		WebElement Locator=driver.findElement(By.xpath("(//a[normalize-space()='Gmail'])[1]"));
		actions.contextClick(Locator).perform();
		driver.findElement(By.xpath("//a[@aria-label='Gmail (opens link in new window)']")).click();
	}

	@Test
	public void tc3() {
		String url="https://the-internet.herokuapp.com/upload";
		driver.get(url);
		driver.manage().window().maximize();
		WebElement upload_file = driver.findElement(By.xpath("(//input[@id='file-upload'])[1]"));

		upload_file.sendKeys("D:\\New mobile pics\\DCMI\\IMG_20220129_130629.jpg");
		driver.findElement(By.xpath("(//input[@id='file-submit'])[1]")).click();
		
	}
	@Test
	public void tc4() {
		String url="https://designsystem.digital.gov/components/radio-buttons/";
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//label[@for='historical-washington-2'])[1]")).click();
	
		
	}
	
	@Test
	public void tc5() {
		String url="https://the-internet.herokuapp.com/javascript_alerts";
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		driver.switchTo().alert().dismiss();
	
		
	}
	@Test(enabled=false)
	public void tc6() {
		String url="https://www.makemytrip.com/";
		driver.get(url);
		driver.manage().window().maximize();
		
	
		
	}
	
}
